(ns sk.handlers.admin.mision.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.mision.view :refer [mision-view mision-scripts]]))

(defn mision [_]
  (let [title "Mision"
        ok (get-session-id)
        js (mision-scripts)
        content (mision-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn mision-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "mision"
        args {:sort-extra "descripcion"}]
    (build-grid params table args)))

(defn mision-form [id]
  (let [table "mision"]
    (build-form-row table id)))

(defn mision-save [{params :params}]
  (let [table "mision"
        datos (assoc params :id 1)]
    (build-form-save datos table)))

(defn mision-delete [{params :params}]
  (let [table "mision"]
    (build-form-delete params table)))