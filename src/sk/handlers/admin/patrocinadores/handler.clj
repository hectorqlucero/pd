(ns sk.handlers.admin.patrocinadores.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.patrocinadores.view :refer [patrocinadores-view patrocinadores-scripts]]))

(defn patrocinadores [_]
  (let [title "Patrocinadores"
        ok (get-session-id)
        js (patrocinadores-scripts)
        content (patrocinadores-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn patrocinadores-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "patrocinadores"
        args {:sort-extra "contacto"}]
    (build-grid params table args)))

(defn patrocinadores-form [id]
  (let [table "patrocinadores"]
    (build-form-row table id)))

(defn patrocinadores-save [{params :params}]
  (let [table "patrocinadores"]
    (build-form-save params table)))

(defn patrocinadores-delete [{params :params}]
  (let [table "patrocinadores"]
    (build-form-delete params table)))