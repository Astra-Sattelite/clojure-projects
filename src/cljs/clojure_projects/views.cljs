(ns clojure-projects.views
  (:require
   ["react-router-dom" :refer [Route BrowserRouter Switch Link]]
   [cljss.core :refer-macros [defstyles]]
   [clojure-projects.components.counter :refer [counter]]
   [clojure-projects.projects :refer [projects]]
   [clojure-projects.components.osu :refer [osu]]))

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
   :display "flex"
   :flex "1"
   :justify-content "center"
   })

(defn header [first & rest]
  [:div {:class (header-css)}
   first
   rest])

(defstyles card-css []
  {:height "300px"
   :width "500px"
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
   :height "230px"
   :display "flex"
   :justify-content "center"
   :background-color "orange"})

(defstyles card-description-link []
  {:width "inherit"
   :height "30px"
   :display "flex"
   :justify-content "center"
   :align-items "center"})

(defstyles card-description-button []
  {:width "inherit"
   :padding "0px"})

(defstyles card-description-button-link []
  {:width "149px"
   :height "20px"
   :display "flex"
   :justify-content "center"
   :outline "none"
   :align-items "center"})

(defn card [project]
  [:div {:class (card-css) :key (:route project)}
   [:div {:class (card-content)}]
   [:div {:class (card-description)}
    [:div {:class (card-description-title)}
     [:p (:title project)]]
    [:div {:class (card-description-descr)}
     [:p {:style {:width "140px" :display "flex" :text-align "center" }} (:descr project)]]
    [:div {:class (card-description-link )}
     [:p (str "by " (:author project))]]
    [:div {:class (card-description-button)}
     [:> Link {:to (:route project)}
      [:div {:class (card-description-button-link)} "Click me"]]]]])

(defstyles content-css []
  {:min-height "800px"
   :display "flex"
   :align-items "center"
   :flex-direction "column"
   :flex "9"})

(defstyles header-button []
  {:display "flex"
   :flex "5"
   :font-size "calc(16px + 1vw)"
   :justify-content "center"
   :align-items "center"
   :background-color "orange"
   :border-right "2px solid"
   :border-bottom "2px solid"
   :&:hover {:transition "all 0.3s ease" :background-color "white"}
   :&:last-child {:border-right "none" }
   })

(defstyles header-button:last-child []
  {:border-right "none"
   :backgorund-color "blue"})

(defstyles blank-a []
  {:color "inherit"
   :text-decoration "none"
   })

(defn header-elem [text link]
  [:div {:class (header-button)}
   [:a {:href link :class (blank-a)} [:p text]]
   ])

(defn content []
  [:div {:class (content-css)}
   [:<> (map card projects)]])

(defn main-panel []
  [:> BrowserRouter
   [:div {:class (main-container)}
    [:> Switch
     [:> Route {:path "/" :exact true}
      [:div {:class (container)}
       [header
        [header-elem "text1" "link1"]
        [header-elem "text2" "link2"]
        [header-elem "text3" "link3"]
        [header-elem "text4" "link4"]
        [header-elem "text5" "link5"]]
       [content]]]
     [:> Route {:path "/counter/"}
      [counter]]
     [:> Route {:path "/osu/"}
      [osu]]]]])
