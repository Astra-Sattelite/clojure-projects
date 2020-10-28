(ns clojure-projects.components.osu
  (:require
   [cljss.core :refer-macros [defstyles]]
   [re-frame.core :as rf]
   [clojure-projects.subs :as subs]))

(defstyles box []
  {:height "inherit"
   :width "inherit"
   :background-color ""})

(defstyles circle [top left]
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

(defn circle-generator []
  (let [window-size @(rf/subscribe [::subs/window-size])]
    [:<>
     (repeatedly 5
                 (fn []
                   [:div {:class
                          (circle
                           (let [res (rand (:height window-size))]
                             (cond
                               (< res 200) (+ res 200)
                               (>= res (- 200 (:height window-size))) (- res 200)
                               :else res))

                           (let [res (rand (:width window-size))]
                             (cond
                               (< res 200) (+ res 200)
                               (>= res (- 200 (:width window-size))) (- res 200)
                               :else res)))}
                    [:label "KEKW"]]))]))

(defn osu []
  [:div {:class (box)}
   [circle-generator]])
