(ns sk.handlers.admin.pais.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.pais.view :refer [pais-view pais-scripts]]))

(defn pais [_]
  (let [title "Pais"
        ok (get-session-id)
        js (pais-scripts)
        content (pais-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn pais-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "pais"
        args {:sort-extra "descripcion"}]
    (build-grid params table args)))

(defn pais-form [id]
  (let [table "pais"]
    (build-form-row table id)))

(defn pais-save [{params :params}]
  (let [table "pais"]
    (build-form-save params table)))

(defn pais-delete [{params :params}]
  (let [table "pais"]
    (build-form-delete params table)))