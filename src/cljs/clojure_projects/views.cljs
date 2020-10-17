(ns clojure-projects.views
  (:require
   [clojure-projects.events :as Event]
   ["react-router-dom" :refer [Route BrowserRouter Switch]]
   [cljss.core :refer-macros [defstyles]]
   [clojure-projects.components.counter :refer [counter]]))

(defstyles main-container []
  {:height "100vh"
   :width "100%"})

(defn landing []
  [:div "this is landing"])

(defn main-panel []
  [:> BrowserRouter
   [:div {:class (main-container)}
    [:> Switch
     [:> Route {:path "/" :exact true}
      [landing]]
     [:> Route {:path "/counter/"}
      [counter]]]]])
