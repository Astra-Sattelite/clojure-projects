(ns clojure-projects.projects)

(def counter
  {:title  "Counter"
   :route  "/counter/"
   :descr  "Learning how to work with events\\subs"
   :img "https://static.wikia.nocookie.net/bhlx/images/2/2a/Laffey.png/revision/latest?cb=20200101173956"})

(def osu
  {:title "Minimal osu"
   :route "/osu/"
   :descr "Rythm is just click away!"
   :img "https://static.wikia.nocookie.net/azur-lane/images/9/9a/Kaga.png/revision/latest?cb=20190830172320&path-prefix=ru"})

(def azur-farm
  {:title "Tracker"
   :route "/azurfarm/"
   :descr "Tracker for drops in Azur Lane"
   :img "https://static.wikia.nocookie.net/azur-lane/images/0/06/Akagi.png/revision/latest/top-crop/width/360/height/450?cb=20190829151734&path-prefix=ru"})

(def projects [counter osu azur-farm])
