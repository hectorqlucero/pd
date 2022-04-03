(ns sk.handlers.admin.vision.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.vision.view :refer [vision-view vision-scripts]]))

(defn vision [_]
  (let [title "Vision"
        ok (get-session-id)
        js (vision-scripts)
        content (vision-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn vision-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "vision"
        args {:sort-extra "descripcion"}]
    (build-grid params table args)))

(defn vision-form [id]
  (let [table "vision"]
    (build-form-row table id)))

(defn vision-save [{params :params}]
  (let [table "vision"
        datos (assoc params :id 1)]
    (build-form-save datos table)))

(defn vision-delete [{params :params}]
  (let [table "vision"]
    (build-form-delete params table)))