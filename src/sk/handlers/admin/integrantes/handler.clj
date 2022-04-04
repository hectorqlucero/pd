(ns sk.handlers.admin.integrantes.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.integrantes.view :refer [integrantes-view integrantes-scripts]]))

(defn integrantes [_]
  (let [title "Integrantes"
        ok (get-session-id)
        js (integrantes-scripts)
        content (integrantes-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn integrantes-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "integrantes"
        args {:sort-extra "nombre,paterno,materno"}]
    (build-grid params table args)))

(defn integrantes-form [id]
  (let [table "integrantes"]
    (build-form-row table id)))

(defn integrantes-save [{params :params}]
  (let [table "integrantes"]
    (build-form-save params table)))

(defn integrantes-delete [{params :params}]
  (let [table "integrantes"]
    (build-form-delete params table)))