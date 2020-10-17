(ns clojure-projects.views
  (:require
   [re-frame.core :as rf]
   [clojure-projects.subs :as Subs]
   [clojure-projects.events :as Event]
   ["react-router-dom" :refer [Route BrowserRouter Switch]]
   [cljss.core :refer-macros [defstyles]]))

(defstyles main-container []
  {:height "100vh"
   :width "100%"
   :background-color "black"})

(defn landing []
  [:div {:class (main-container)}])

(defn main-panel []
  [:> BrowserRouter
   [:> Switch
    [:> Route {:path "/" :exact true}
     [landing]]
    [:> Route {:path "/lulw/"}
     [landing]]]])
