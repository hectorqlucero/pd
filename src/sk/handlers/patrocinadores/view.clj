(ns sk.handlers.patrocinadores.view
  (:require [sk.handlers.patrocinadores.model :refer [get-rows]]
            [sk.user :as user]))

(defn build-body [row]
  (list
   [:div.card
    [:img.card-img-top.mb-3.w-auto {:src (str (:path user/config) (:imagen row))
                                    :style "max-width:10%;height:auto;"
                                    :alt (:comp row)}]
    [:div.card-body
     [:h5.card-title (:comp row)]
     [:p.card-text (:contacto row)]
     [:p.card-text (str (:direccion row) " " (:telefono row))]]]))

(defn patrocinadores-view [_]
  (let [rows (get-rows "patrocinadores")]
    (list
     (map build-body rows))))

(defn patrocinadores-scripts []
  nil)

(comment
  (patrocinadores-view "patrocinadores")
  (get-rows "patrocinadores"))
