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
   ;; :overflow "auto"
   :padding-bottom "0px"
   :flex-direction "column"})

(defstyles header-css []
  {:min-height "100px"
   :background-color "#3792cb"
   :display "flex"
   :flex "1"
   :color "#f2f3f4"
   :justify-content "center"
   })

(defn header [first & rest]
  [:div {:class (header-css)}
   first
   rest])

(defstyles card-css []
  {:height "40vh"
   :width "40vw"
   :min-height "300px"
   :min-width "500px"
   :margin "10px"
   :display "flex"
   :flex-direction "row"
   :border "2px solid"
   :box-shadow "0 0 10px rgba(0, 0, 0.5)"

   :&:last-child {:margin-bottom "100px" :padding-bottom "0px"}})

(defstyles card-content [img]
  {:flex "7"
   :background (str "no-repeat center/60% url(" img "), linear-gradient(0deg, #0492c2, #42a5f5)")
   :border-right "2px solid"})

(defstyles card-description []
  {:flex "3"
   :display "flex"
   :flex-direction "column"
   :color "#f2f3f4"
   })

(defstyles card-description-title []
  {:display "flex"
   :flex "1"
   :background-color "#42a5f5"
   :font-size "calc(12px + 0.5vw)"
   :justify-content "center"
   :align-items "center"})

(defstyles card-description-descr []
  {:flex "7"
   :display "flex"
   :font-size "calc(10px + 0.5vw)"
   :justify-content "center"
   :background "linear-gradient(0deg, rgba(4,146,194,1) 10%, rgba(66,165,245,1) 100%)"})

(defstyles card-description-link []
  {:flex "1"
   :display "flex"
   :font-size "calc(10px + 0.5vw)"
   :justify-content "center"
   :align-items "center"})

(defstyles card-description-button []
  {:flex "1"
   :display "flex"})

(defstyles card-description-button-decor []
  {:flex "1"
   :display "flex"
   :justify-content "center"
   :align-items "center"
   :font-size "calc(10px + 0.5vw)"
   :background-color "#0492c2"
   :border-top "2px solid black"
   :&:hover {:transition "all 0.3s ease" :background-color "#63c5da"}})

(defn card [project]
  [:div {:class (card-css) :key (:route project)}
   [:div {:class (card-content (:img project))}]
   [:div {:class (card-description)}
    [:div {:class (card-description-title)}
     [:p (:title project)]]
    [:div {:class (card-description-descr)}
     [:p {:style {:width "90%" :display "flex" :text-align "center" }} (:descr project)]]
    [:a {:href (:route project)
         :style {:text-decoration "none" :color "inherit"}
         :class (card-description-button)}
     [:div {:class (card-description-button-decor)} "Click me"]]]])

(defstyles content-css []
  {:min-height "800px"
   :display "flex"
   :background-color "#ffffff"
   :align-items "center"
   :flex-direction "column"
   :flex "9"})

(defstyles header-button []
  {:display "flex"
   :flex "1"
   :font-size "calc(16px + 1vw)"
   :justify-content "center"
   :align-items "center"
   :border-right "2px solid black"
   :border-bottom "2px solid black"
   :&:hover {:transition "all 0.3s ease" :background-color "#63c5da"}})

(defstyles blank-a []
  {:color "inherit"
   :display "flex"
   :flex "5"
   :text-decoration "none"
   :&:last-child {:border-right "none" }
   })

(defn header-elem [projects]
  [:a {:href (:link projects) :class (blank-a) :key (:title projects)}
   [:div {:class (header-button)}
    [:p (:title projects)]]])

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
        (map header-elem (take 5 projects))]
       [content]]]
     [:> Route {:path "/counter/"}
      [counter]]
     [:> Route {:path "/osu/"}
      [osu]]]]])
