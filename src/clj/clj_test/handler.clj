(ns clj-test.handler
  (:require
   [compojure.core :refer [GET defroutes]]
   [compojure.route :refer [resources]]
   [ring.util.response :refer [response]]
   [ring.middleware.reload :refer [wrap-reload]]
   [shadow.http.push-state :as push-state]))

(defn get-some [{:keys [body headers]}]
  (prn (str "Body: " body "\nHeaders: " headers))
  {:status 200})

(defroutes routes
  (GET "/" [] (response "dsds"))
  (GET "/test" [] get-some)
  (resources "/"))

(defn cors [handler]
  (fn [request]
    (let [response (handler request)]
      (-> response
          (assoc-in [:headers "Access-Control-Allow-Origin"] (get-in request [:headers "origin"]))
          (assoc-in [:headers "Access-Control-Allow-Headers"] "x-requested-with, content-type")
          (assoc-in [:headers "Access-Control-Allow-Methods"] "*")))))

(def dev-handler (-> #'routes wrap-reload push-state/handle))

(def handler (-> routes
                 cors))
