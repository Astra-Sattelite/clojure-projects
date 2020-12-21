(ns clojure-projects.projects)

(def counter
  {:title  "Counter"
   :route  "/counter/"
   :descr  "Learning how to work with events\\subs"
   :img "https://static.wikia.nocookie.net/bhlx/images/2/2a/Laffey.png"})

(def osu
  {:title "Minimal osu"
   :route "/osu/"
   :descr "Rythm is just click away!"
   :img "https://i.pinimg.com/originals/62/08/9e/62089ee9672198cd380b938aec5f1577.gif"})

(def azur-farm
  {:title "Tracker"
   :route "/azurfarm/"
   :descr "Tracker for drops in Azur Lane"
   :img "https://i.pinimg.com/originals/29/00/92/2900920e2ac0a0c8f16eba53c837315b.gif"})

(def projects [counter osu azur-farm])
