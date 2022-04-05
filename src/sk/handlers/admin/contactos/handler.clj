(ns sk.handlers.admin.contactos.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.contactos.view :refer [contactos-view contactos-scripts]]))

(defn contactos [_]
  (let [title "Contactos"
        ok (get-session-id)
        js (contactos-scripts)
        content (contactos-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn contactos-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "contactos"
        args {:sort-extra "nombre,paterno,materno"}]
    (build-grid params table args)))

(defn contactos-form [id]
  (let [table "contactos"]
    (build-form-row table id)))

(defn contactos-save [{params :params}]
  (let [table "contactos"]
    (build-form-save params table)))

(defn contactos-delete [{params :params}]
  (let [table "contactos"]
    (build-form-delete params table)))