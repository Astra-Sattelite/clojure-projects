(ns clojure-projects.projects)

(def counter
  {:title  "Counter"
   :route  "/counter/"
   :descr  "Learning how to work with events\\subs"
   :author "Man of culture"})

(def osu
  {:title "Minimal osu"
   :route "/osu/"
   :descr "Rythm is just click away!"
   :author "Man of culture"})

(def projects [counter osu])
