(ns sk.handlers.mision.handler
  (:require
   [sk.layout :refer [application]]
   [sk.models.util :refer [get-session-id]]
   [sk.handlers.mision.view :refer [mision-view mision-scripts]]))

(defn mision [_]
  (let [title "Mision"
        ok (get-session-id)
        js (mision-scripts)
        content (mision-view title)]
    (application title ok js content)))