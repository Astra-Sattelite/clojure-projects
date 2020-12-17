(ns clojure-projects.db)

(def default-db
  {:name "re-frame"
   :counter-state 0
   :window-size {:height (.-innerHeight js/window) :width (.-innerWidth js/window)}
   :osu-circles []
   :generate-circles? false})
