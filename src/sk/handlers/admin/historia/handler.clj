(ns sk.handlers.admin.historia.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.historia.view :refer [historia-view historia-scripts]]))

(defn historia [_]
  (let [title "Historia"
        ok (get-session-id)
        js (historia-scripts)
        content (historia-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn historia-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "historia"
        args {:sort-extra "descripcion"}]
    (build-grid params table args)))

(defn historia-form [id]
  (let [table "historia"]
    (build-form-row table id)))

(defn historia-save [{params :params}]
  (let [table "historia"
        datos (assoc params :id 1)]
    (build-form-save datos table)))

(defn historia-delete [{params :params}]
  (let [table "historia"]
    (build-form-delete params table)))