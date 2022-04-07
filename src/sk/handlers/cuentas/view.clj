(ns sk.handlers.cuentas.view
  (:require [sk.handlers.cuentas.model :refer [get-rows get-pais]]))

(defn build-body [row]
  (let [prow (get-pais (:pais_id row))
        pais (:descripcion prow)]
    (list
     [:div.card
      [:div.card-body
       [:h5.card-title pais]
       [:div.row
        [:div.col.col-xs-6.col-sm-6.col-md-2
         [:p.card-text "Numero de cuenta:"]]
        [:div.col
         [:p.card-text (:cuenta_numero row)]]]
       [:div.row
        [:div.col.col-xs-6.col-sm-6.col-md-2
         [:p.card-text "Numero de transferencia:"]]
        [:div.col
         [:p.card-text (:transferencia row)]]]
       [:div.row
        [:div.col.col-xs-6.col-sm-6.col-md-2
         [:p.card-text "Deposito directo:"]]
        [:div.col
         [:p.card-text (:deposito_directo row)]]]
       [:div.row
        [:div.col.col-xs-6.col-sm-6.col-md-2
         [:p.card-text "Numero de tarjeta:"]]
        [:div.col
         [:p.card-text (:numero_tarjeta row)]]]]])))

(defn cuentas-view [_]
  (let [rows (get-rows "cuentas")]
    (list
     (map build-body rows))))

(defn cuentas-scripts []
  nil)

(comment
  (cuentas-view "cuentas")
  (get-rows "cuentas"))
