(ns sk.handlers.admin.cuentas.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.cuentas.view :refer [cuentas-view cuentas-scripts]]))

(defn cuentas [_]
  (let [title "Cuentas"
        ok (get-session-id)
        js (cuentas-scripts)
        content (cuentas-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn cuentas-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "cuentas"
        args {:sort-extra "cuenta_numero"}]
    (build-grid params table args)))

(defn cuentas-form [id]
  (let [table "cuentas"]
    (build-form-row table id)))

(defn cuentas-save [{params :params}]
  (let [table "cuentas"]
    (build-form-save params table)))

(defn cuentas-delete [{params :params}]
  (let [table "cuentas"]
    (build-form-delete params table)))