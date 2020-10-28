(ns clojure-projects.utils
  (:require
   [re-frame.core :as rf]
   [clojure-projects.events :as events]))

(defn add-event-listener-resize []
  (.addEventListener js/window "resize" #(rf/dispatch [::events/update-window-size])))
