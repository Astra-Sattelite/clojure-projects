(ns clojure-projects.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as rf]
   [clojure-projects.events :as Events]
   [clojure-projects.views :as views]
   [clojure-projects.config :as config]
   [cljss.core :as css]))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (rf/clear-subscription-cache!)
  (css/remove-styles!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)

    (rf/dispatch-sync [::Events/initialize-db])
    (rdom/render [views/main-panel] root-el)))

(defn init []

  (rf/dispatch-sync [::Events/initialize-db])

  (dev-setup)
  (mount-root))
