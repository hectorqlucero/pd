(ns sk.handlers.admin.eventos.handler
  (:require [sk.handlers.admin.eventos.view :refer [eventos-scripts eventos-view]]
            [sk.layout :refer [application]]
            [sk.models.crud :refer [build-form-delete build-form-row build-form-save]]
            [sk.models.grid :refer [build-grid]]
            [sk.models.util :refer [current_year get-session-id user-level]]))

(defn eventos [_]
  (let [title "Eventos - Semana"
        ok (get-session-id)
        js (eventos-scripts)
        content (eventos-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn eventos-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "eventos"
        args {:sort-extra "fecha desc,hora"
              :search-extra (str "YEAR(fecha) = '" (current_year) "'")}]
    (build-grid params table args)))

(defn eventos-form [id]
  (let [table "eventos"]
    (build-form-row table id)))

(defn eventos-save [{params :params}]
  (let [table "eventos"]
    (build-form-save params table)))

(defn eventos-delete [{params :params}]
  (let [table "eventos"]
    (build-form-delete params table)))
