(ns sk.handlers.admin.voluntarios.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.voluntarios.view :refer [voluntarios-view voluntarios-scripts]]))

(defn voluntarios [_]
  (let [title "Voluntarios"
        ok (get-session-id)
        js (voluntarios-scripts)
        content (voluntarios-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn voluntarios-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "voluntarios"
        args {:sort-extra "nombre,paterno,materno"}]
    (build-grid params table args)))

(defn voluntarios-form [id]
  (let [table "voluntarios"]
    (build-form-row table id)))

(defn voluntarios-save [{params :params}]
  (let [table "voluntarios"]
    (build-form-save params table)))

(defn voluntarios-delete [{params :params}]
  (let [table "voluntarios"]
    (build-form-delete params table)))