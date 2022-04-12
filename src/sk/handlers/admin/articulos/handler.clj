(ns sk.handlers.admin.articulos.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.articulos.view :refer [articulos-view articulos-scripts]]))

(defn articulos [_]
  (let [title "Articulos de Venta"
        ok (get-session-id)
        js (articulos-scripts)
        content (articulos-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn articulos-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "articulos"
        args {:sort-extra "descripcion"}]
    (build-grid params table args)))

(defn articulos-form [id]
  (let [table "articulos"]
    (build-form-row table id)))

(defn articulos-save [{params :params}]
  (let [table "articulos"]
    (build-form-save params table)))

(defn articulos-delete [{params :params}]
  (let [table "articulos"]
    (build-form-delete params table)))