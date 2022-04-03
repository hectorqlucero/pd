(ns sk.handlers.historia.view
  (:require [sk.handlers.historia.model :refer [get-rows]]))

(defn historia-view [title]
  (let [title title
        data (:descripcion (first (get-rows "historia")))]
    (list
     [:div.card
      [:div.card-body
       [:div.card-title title]
       [:p.card-text data]]])))

(defn historia-scripts []
  nil)

(comment
  (historia-view "Historia")
  (get-rows "historia"))
