(ns sk.handlers.admin.veterinarias.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.veterinarias.view :refer [veterinarias-view veterinarias-scripts]]))

(defn veterinarias [_]
  (let [title "Veterinarias"
        ok (get-session-id)
        js (veterinarias-scripts)
        content (veterinarias-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn veterinarias-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "veterinarias"
        args {:sort-extra "comp"}]
    (build-grid params table args)))

(defn veterinarias-form [id]
  (let [table "veterinarias"]
    (build-form-row table id)))

(defn veterinarias-save [{params :params}]
  (let [table "veterinarias"]
    (build-form-save params table)))

(defn veterinarias-delete [{params :params}]
  (let [table "veterinarias"]
    (build-form-delete params table)))