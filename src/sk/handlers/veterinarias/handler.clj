(ns sk.handlers.veterinarias.handler
  (:require
   [sk.layout :refer [application]]
   [sk.models.util :refer [get-session-id]]
   [sk.handlers.veterinarias.view :refer [veterinarias-view veterinarias-scripts]]))

(defn veterinarias [_]
  (let [title "Veterinarias"
        ok (get-session-id)
        js (veterinarias-scripts)
        content (veterinarias-view title)]
    (application title ok js content)))