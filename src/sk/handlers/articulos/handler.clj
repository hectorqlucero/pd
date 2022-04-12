(ns sk.handlers.articulos.handler
  (:require
   [sk.layout :refer [application]]
   [sk.models.util :refer [get-session-id]]
   [sk.handlers.articulos.view :refer [articulos-view articulos-scripts]]))

(defn articulos [_]
  (let [title "Articulos de Venta"
        ok (get-session-id)
        js (articulos-scripts)
        content (articulos-view title)]
    (application title ok js content)))