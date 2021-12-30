(ns app.handler.example
  (:require [compojure.core :refer :all]
            [integrant.core :as ig]
            [environ.core :refer [env]]))

(defmethod ig/init-key :app.handler/example [_ options]
  (context "/example" []
    (GET "/" []
      {:body {:example "data"
              :hostname (env :hostname)
              :kubernetes_port (env :kubernetes-port)}})))
