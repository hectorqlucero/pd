(ns sk.handlers.patrocinadores.handler
  (:require
   [sk.layout :refer [application]]
   [sk.models.util :refer [get-session-id]]
   [sk.handlers.patrocinadores.view :refer [patrocinadores-view patrocinadores-scripts]]))

(defn patrocinadores [_]
  (let [title "Contactos"
        ok (get-session-id)
        js (patrocinadores-scripts)
        content (patrocinadores-view title)]
    (application title ok js content)))