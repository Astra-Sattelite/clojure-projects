(ns clojure-projects.views
  (:require
   ["react-router-dom" :refer [Route BrowserRouter Switch Link]]
   [cljss.core :refer-macros [defstyles]]
   [clojure-projects.components.counter :refer [counter]]
   [clojure-projects.projects :refer [projects]]))

(defstyles main-container []
  {:height "100vh"
   :width "100%"})

(defstyles container []
  {:height "100%"
   :width "100%"
   :display "flex"
   :flex-direction "column"})

(defstyles header-css []
  {:min-height "100px"
   :background-color "black"
   :flex "1"})

(defn header []
  [:div {:class (header-css)}])

(defstyles card-css []
  {:height "200px"
   :width "400px"
   :margin "10px"
   :display "flex"
   :flex-direction "row"
   :border "2px solid"
   :box-shadow "0 0 10px rgba(0, 0, 0.5)"})

(defstyles card-content []
  {:flex "7"
   :border-right "2px solid"})

(defstyles card-description []
  {:flex "3"
   :display "flex"
   :flex-direction "column"
   })

(defstyles card-description-title []
  {:width "inherit"
   :height "20px"
   :display "flex"
   :justify-content "center"
   :align-items "center"})

(defstyles card-description-descr []
  {:width "inherit"
   :height "140px"
   :display "flex"
   :justify-content "center"
   :background-color "orange"})

(defstyles card-description-link []
  {:width "inherit"
   :height "20px"
   :background-color "purple"})

(defstyles card-description-button []
  {:width "inherit"
   :height "20px"})

(defn card [project]
  [:div {:class (card-css) :key (:route project)}
   [:div {:class (card-content)}]
   [:div {:class (card-description)}
    [:div {:class (card-description-title)}
     [:p {:style (:font-size "14px")} (:title project)]]
    [:div {:class (card-description-descr)}
     [:p (:descr project)]]
    [:div {:class (card-description-link )}
     [:p (:gitrep project)]]
    [:div {:class (card-description-button)} [:> Link {:to "/counter/"} [:button {:style {:padding-right "48px"}} "click me"]]]
    [:button]]])

(defstyles content-css []
  {:min-height "800px"
   :display "flex"
   :align-items "center"
   :flex-direction "column"
   :flex "9"})

(defn content []
  [:div {:class (content-css)}
   [:<> (map card projects)]])

(defn main-panel []
  [:> BrowserRouter
   [:div {:class (main-container)}
    [:> Switch
     [:> Route {:path "/" :exact true}
      [:div {:class (container)}
       [header]
       [content]]]
     [:> Route {:path "/counter/"}
      [counter]]]]])
