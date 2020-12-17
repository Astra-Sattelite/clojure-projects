(ns clojure-projects.events
  (:require
   [re-frame.core :as rf]
   [clojure-projects.db :as db]
   [cljs-uuid.core :as uuid]))

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

(defn get-circle-position [coord offset]
   (cond
    (< coord 200) (+ coord 200)
    (>= coord (- 200 offset)) (- coord 200)
    :else coord))

(rf/reg-event-db
 ::add-osu-circle
 (fn [db [_]]
   (if (:generate-circles? db )
     (let [window-size (:window-size db)
          x (rand (:height window-size))
          y (rand (:width window-size))]
      (update db
              :osu-circles
              (fn [circles]
                (conj circles
                      {:x (get-circle-position x (:height window-size))
                       :y (get-circle-position y (:width window-size))
                       :id (uuid/make-random)}))))
     db)))

(rf/reg-event-db
 ::remove-osu-circle
 (fn [db [_ id]]
   (update db
           :osu-circles
           #(filter (fn [circle]
                      (not= (:id circle) id))
                    %))))

(rf/reg-event-db
 ::update-field-value
 (fn [db [_ field value]]
   (assoc db field value)))
