(ns sk.handlers.articulos.view
  (:require [sk.handlers.articulos.model :refer [get-rows]]
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
       [:p.card-text.font-weight-bold "Articulo:"]]
      [:div.col
       [:p.card-text (:descripcion row)]]]
     [:div.row
      [:div.col.col-xs-6.col-sm-6.col-md-1
       [:p.card-text.font-weight-bold "Precio:"]]
      [:div.col
       [:p.card-text (str "$" (clojure.pprint/cl-format nil "~,2f" (:precio row)))]]]
     [:div.row
      [:div.col.col-xs-6.col-sm-6.col-md-1
       [:p.card-text.font-weight-bold "Contacto:"]]
      [:div.col
       [:p.card-text (:contacto row)]]]
     [:div.row
      [:div.col.col-xs-6.col-sm-6.col-md-1
       [:p.card-text.font-weight-bold "Telefono:"]]
      [:div.col
       [:p.card-text (:telefono row)]]]
     [:div.row
      [:div.col.col-xs-6.col-sm-6.col-md-1
       [:p.card-text.font-weight-bold "Whats UP:"]]
      [:div.col
       [:p.card-text (:whats_up row)]]]
     [:div.row
      [:div.col.col-xs-6.col-sm-6.col-md-1
       [:p.card-text.font-weight-bold "Email:"]]
      [:div.col
       [:p.card-text (:email row)]]]]]))

(defn articulos-view [_]
  (let [rows (get-rows "articulos")]
    (list
     (map build-body rows))))

(defn articulos-scripts []
  nil)

(comment
  (articulos-view "articulos")
  (get-rows "articulos"))
