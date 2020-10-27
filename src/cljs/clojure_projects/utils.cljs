(ns clojure-projects.utils)

(defn get-screen [value]
  (case value
    "x" "I am X"
    "y" "I am Y"
    ""  "YES, I AM!"))
