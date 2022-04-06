(ns sk.handlers.mision.view
  (:require [sk.handlers.mision.model :refer [get-rows]]))

(defn mision-view [title]
  (let [title title
        data (:descripcion (first (get-rows "mision")))]
    (list
     [:div.card
      [:div.card-body
       [:div.card-title title]
       [:p.card-text.text-justify data]]])))

(defn mision-scripts []
  nil)

(comment
  (mision-view "Historia")
  (get-rows "mision"))
