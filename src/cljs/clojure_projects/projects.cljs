(ns clojure-projects.projects)

(def counter
  {:title  "Counter"
   :route  "/counter/"
   :descr  "Learning how to work with events\\subs"})

(def osu
  {:title "Minimal osu"
   :route "/osu/"
   :descr "Rythm is just click away!"})

(def projects [counter osu])
