(ns sk.handlers.cuentas.handler
  (:require
   [sk.layout :refer [application]]
   [sk.models.util :refer [get-session-id]]
   [sk.handlers.cuentas.view :refer [cuentas-view cuentas-scripts]]))

(defn cuentas [_]
  (let [title "Cuentas Bancarias"
        ok (get-session-id)
        js (cuentas-scripts)
        content (cuentas-view title)]
    (application title ok js content)))