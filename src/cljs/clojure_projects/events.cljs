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
 (fn [old-db [_ is-plus]]
   (update old-db :counter-state (if is-plus inc dec))))
