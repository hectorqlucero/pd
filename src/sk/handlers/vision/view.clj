(ns sk.handlers.vision.view
  (:require [sk.handlers.vision.model :refer [get-rows]]))

(defn vision-view [title]
  (let [title title
        data (:descripcion (first (get-rows "visión")))]
    (list
     [:div.card
      [:div.card-body
       [:div.card-title title]
       [:p.card-text data]]])))

(defn vision-scripts []
  nil)

(comment
  (vision-view "vision")
  (get-rows "vision"))
