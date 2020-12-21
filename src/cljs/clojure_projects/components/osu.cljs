(ns clojure-projects.components.osu
  (:require
   [cljss.core :refer-macros [defstyles]]
   [re-frame.core :as rf]
   [clojure-projects.subs :as subs]
   [clojure-projects.events :as events]))

(defstyles box []
  {:height "inherit"
   :width "inherit"
   :background-color ""})

(defstyles circle-style [top left]
  {:height "100px"
   :width "100px"
   :position "absolute"
   :top (str top "px")
   :left (str left "px")
   :background-color "pink"
   :border-radius "360px"
   :border "1px solid"
   :display "flex"
   :justify-content "center"
   :align-items "center"})

(defn circle [{:keys [x y id]}]
  [:div {:class (circle-style x y)
         :on-click #(rf/dispatch [::events/remove-osu-circle id])
         :key id}
    [:label "KEKW"]])

(defn circles []
  [:<>
   (map circle @(rf/subscribe [::subs/osu-state]))])

(defn start []
  [:button {:on-click #(rf/dispatch [::events/update-field-value :generate-circles? true])} "starto"])

(defn stop []
  [:button {:on-click #(rf/dispatch [::events/update-field-value :generate-circles? false])} "stahp"])

(defn osu []
  [:div {:class (box)}
   [circles]
   [stop]
   [start]])