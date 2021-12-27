(ns app.handler.example
  (:require [compojure.core :refer :all]
            [integrant.core :as ig]))

(defmethod ig/init-key :app.handler/example [_ options]
  (context "/example" []
    (GET "/" []
      {:body {:example "data"}})))
