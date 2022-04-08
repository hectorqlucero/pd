(ns sk.handlers.admin.adopciones.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.adopciones.view :refer [adopciones-view adopciones-scripts]]))

(defn adopciones [_]
  (let [title "Fotos - Adopciones"
        ok (get-session-id)
        js (adopciones-scripts)
        content (adopciones-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn adopciones-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "adopciones"
        args {:sort-extra "fecha desc"}]
    (build-grid params table args)))

(defn adopciones-form [id]
  (let [table "adopciones"]
    (build-form-row table id)))

(defn adopciones-save [{params :params}]
  (let [table "adopciones"]
    (build-form-save params table)))

(defn adopciones-delete [{params :params}]
  (let [table "adopciones"]
    (build-form-delete params table)))