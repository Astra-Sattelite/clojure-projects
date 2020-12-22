(ns clojure-projects.components.osu
  (:require
   [cljss.core :refer-macros [defstyles]]
   [re-frame.core :as rf]
   [clojure-projects.subs :as subs]
   [clojure-projects.events :as events]))

(defstyles box []
  {:height "inherit"
   :width "inherit"
   :background "linear-gradient(45deg, rgba(255,182,193,1) 35%, rgba(255,105,180,1) 100%)"})

(defstyles circle-style [top left]
  {:height "100px"
   :width "100px"
   :position "absolute"
   :top (str top "px")
   :left (str left "px")
   :background "no-repeat center/100% url(https://media.tenor.com/images/6cd0f130184b291ee0fcdada80d468b9/tenor.gif), pink"
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
