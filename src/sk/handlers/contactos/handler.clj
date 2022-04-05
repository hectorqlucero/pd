(ns sk.handlers.contactos.handler
  (:require
   [sk.layout :refer [application]]
   [sk.models.util :refer [get-session-id]]
   [sk.handlers.contactos.view :refer [contactos-view contactos-scripts]]))

(defn contactos [_]
  (let [title "Contactos"
        ok (get-session-id)
        js (contactos-scripts)
        content (contactos-view title)]
    (application title ok js content)))