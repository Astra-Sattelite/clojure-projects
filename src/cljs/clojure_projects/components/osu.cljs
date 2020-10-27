(ns clojure-projects.components.osu
  (:require
   [cljss.core :refer-macros [defstyles]]
   [re-frame.core :as rf]
   [clojure-projects.utils :as utils]
   [clojure-projects.events :as events]
   [clojure-projects.subs :as subs]))

(defstyles box []
  {:height "inherit"
   :width "inherit"
   :background-color ""})

(defn osu []
  [:div {:class (box)} (utils/get-screen "")])
