(ns sk.handlers.admin.titulos.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.titulos.view :refer [titulos-view titulos-scripts]]))

(defn titulos [_]
  (let [title "Titulos"
        ok (get-session-id)
        js (titulos-scripts)
        content (titulos-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn titulos-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "titulos"
        args {:sort-extra "descripcion"}]
    (build-grid params table args)))

(defn titulos-form [id]
  (let [table "titulos"]
    (build-form-row table id)))

(defn titulos-save [{params :params}]
  (let [table "titulos"]
    (build-form-save params table)))

(defn titulos-delete [{params :params}]
  (let [table "titulos"]
    (build-form-delete params table)))