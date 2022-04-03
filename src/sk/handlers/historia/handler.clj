(ns sk.handlers.historia.handler
  (:require
   [sk.layout :refer [application]]
   [sk.models.util :refer [get-session-id]]
   [sk.handlers.historia.view :refer [historia-view historia-scripts]]))

(defn historia [_]
  (let [title "Historia"
        ok (get-session-id)
        js (historia-scripts)
        content (historia-view title)]
    (application title ok js content)))