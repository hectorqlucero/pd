(ns sk.handlers.veterinarias.view
  (:require [sk.handlers.veterinarias.model :refer [get-rows]]
            [sk.user :as user]))

(defn build-body [row]
  (list
   [:div.card
    [:img.card-img-top.mb-3.w-auto.mt-3 {:src (str (:path user/config) (:imagen row))
                                         :style "max-width:30%;height:auto;"
                                         :alt (:comp row)}]
    [:div.card-body
     [:h5.card-title (:comp row)]
     [:div.row
      [:div.col.col-xs-6.col-sm-6.col-md-1
       [:p.card-text.font-weight-bold "Informacion:"]]
      [:div.col
       [:p.card-text.text-justify (:descripcion row)]]]
     [:div.row
      [:div.col.col-xs-6.col-sm-6.col-md-1
       [:p.card-text.font-weight-bold "Domicilio:"]]
      [:div.col
       [:p.card-text (:direccion row)]]]
     [:div.row
      [:div.col.col-xs-6.col-sm-6.col-md-1
       [:p.card-text.font-weight-bold "Telefono:"]]
      [:div.col
       [:p.card-text (:telefono row)]]]
     [:div.row
      [:div.col.col-xs-6.col-sm-6.col-md-1
       [:p.card-text.font-weight-bold "Urgencias:"]]
      [:div.col
       [:p.card-text (:urgencias row)]]]
     [:div.row
      [:div.col.col-xs-6.col-sm-6.col-md-1
       [:p.card-text.font-weight-bold "Email:"]]
      [:div.col
       [:p.card-text (:email row)]]]]]))

(defn veterinarias-view [_]
  (let [rows (get-rows "veterinarias")]
    (list
     (map build-body rows))))

(defn veterinarias-scripts []
  nil)

(comment
  (veterinarias-view "veterinarias")
  (get-rows "veterinarias"))
