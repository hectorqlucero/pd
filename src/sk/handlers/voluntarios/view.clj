(ns sk.handlers.voluntarios.view
  (:require [sk.handlers.voluntarios.model :refer [get-rows]]))

(defn build-body [row]
  (list
   [:div.card
    [:div.card-body
     [:div.card-title  (str (:nombre row) " " (:paterno row) " " (:materno row))]
     (when (:whats_up row) [:div.card-text (:whats_up row)])]]))

(defn voluntarios-view [_]
  (let [rows (get-rows "voluntarios")]
    (list
     (map build-body rows))))

(defn voluntarios-scripts []
  nil)

(comment
  (voluntarios-view "voluntarios")
  (get-rows "voluntarios"))
