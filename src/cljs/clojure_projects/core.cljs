(ns clojure-projects.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as rf]
   [clojure-projects.events :as events]
   [clojure-projects.views :as views]
   [clojure-projects.config :as config]
   [cljss.core :as css]
   [clojure-projects.utils :as utils]))

(utils/add-event-listener-resize)

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (css/remove-styles!)
  (rf/clear-subscription-cache!)
  (rf/dispatch-sync [::events/initialize-db])
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel] root-el)))

(defn init []
  (js/setInterval #(rf/dispatch [::events/add-osu-circle]) 300)
  (dev-setup)
  (mount-root))
