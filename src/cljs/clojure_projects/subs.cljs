(ns clojure-projects.subs
  (:require
   [re-frame.core :as rf]))

(rf/reg-sub
 ::name
 (fn [db]
   (:name db)))

(rf/reg-sub
 ::counter-state
 #(:counter-state %))

(rf/reg-sub
 ::window-size
 #(:window-size %))

(rf/reg-sub
 ::osu-state
 #(:osu-circles %))
