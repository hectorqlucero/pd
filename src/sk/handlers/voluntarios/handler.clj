(ns sk.handlers.voluntarios.handler
  (:require
   [sk.layout :refer [application]]
   [sk.models.util :refer [get-session-id]]
   [sk.handlers.voluntarios.view :refer [voluntarios-view voluntarios-scripts]]))

(defn voluntarios [_]
  (let [title "Voluntarios"
        ok (get-session-id)
        js (voluntarios-scripts)
        content (voluntarios-view title)]
    (application title ok js content)))