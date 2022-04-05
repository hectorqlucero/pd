(ns sk.handlers.integrantes.handler
  (:require
   [sk.layout :refer [application]]
   [sk.models.util :refer [get-session-id]]
   [sk.handlers.integrantes.view :refer [integrantes-view integrantes-scripts]]))

(defn integrantes [_]
  (let [title "Integrantes"
        ok (get-session-id)
        js (integrantes-scripts)
        content (integrantes-view title)]
    (application title ok js content)))