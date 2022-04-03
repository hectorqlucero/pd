(ns sk.handlers.vision.handler
  (:require
   [sk.layout :refer [application]]
   [sk.models.util :refer [get-session-id]]
   [sk.handlers.vision.view :refer [vision-view vision-scripts]]))

(defn vision [_]
  (let [title "Vision"
        ok (get-session-id)
        js (vision-scripts)
        content (vision-view title)]
    (application title ok js content)))