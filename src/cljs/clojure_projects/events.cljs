(ns clojure-projects.events
  (:require
   [re-frame.core :as rf]
   [clojure-projects.db :as db]))

(rf/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(rf/reg-event-db
 ::counter-action
 (fn [db [_ is-plus]]
   (update db :counter-state (if is-plus inc dec))))

(rf/reg-event-db
 ::update-window-size
 (fn [db [_]]
   (assoc db :window-size {:height (.-innerHeight js/window) :width (.-innerWidth js/window)})))
