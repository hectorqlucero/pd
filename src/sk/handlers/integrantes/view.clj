(ns sk.handlers.integrantes.view
  (:require [sk.handlers.integrantes.model :refer [get-rows get-titulo]]))

(defn build-body [row]
  (list
   [:div.card
    [:div.card-body
     [:div.card-title (get-titulo (:titulo row))]
     [:div.card-text (str (:nombre row) " " (:paterno row) " " (:materno row))]]]))

(defn integrantes-view [_]
  (let [rows (get-rows "integrantes")]
    (list
     (map build-body rows))))

(defn integrantes-scripts []
  nil)

(comment
  (integrantes-view "integrantes")
  (get-rows "integrantes"))
