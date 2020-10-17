(ns clojure-projects.components.counter
  (:require
   [cljss.core :refer-macros [defstyles]]
   [re-frame.core :as rf]
   [clojure-projects.events :as events]
   [clojure-projects.subs :as subs]))

(defstyles value-box []
  {:width "40px"
   :height "inherit"
   :display "flex"
   :justify-content "center"
   :align-items "center"})

(defstyles button []
  {:width "30px"
   :height "inherit"})

(defstyles box []
  {:width "100px"
   :height "30px"
   :display "flex"
   :flex-direction "row"})

(defn counter []
  [:div {:class (box)}
   [:button {:class (button) :on-click #(rf/dispatch [::events/counter-action true])} "+"]
   [:div {:class (value-box)} [:label @(rf/subscribe [::subs/counter-state])]]
   [:button {:class (button) :on-click #(rf/dispatch [::events/counter-action false])} "-"]])
