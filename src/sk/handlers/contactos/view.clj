(ns sk.handlers.contactos.view
  (:require [sk.handlers.contactos.model :refer [get-rows]]))

(defn build-body [row]
  (list
   [:div.card
    [:div.card-body
     [:div.card-title  (str (:nombre row) " " (:paterno row) " " (:materno row))]
     [:div.card-text (:whats_up row)]]]))

(defn contactos-view [_]
  (let [rows (get-rows "contactos")]
    (list
     (map build-body rows))))

(defn contactos-scripts []
  nil)

(comment
  (contactos-view "contactos")
  (get-rows "contactos"))
