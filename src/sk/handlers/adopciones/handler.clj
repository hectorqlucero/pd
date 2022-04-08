(ns sk.handlers.adopciones.handler
  (:require [sk.layout :refer [application]]
            [sk.models.crud :refer [Query db]]
            [sk.models.util :refer [get-session-id]]))

(def adopciones-sql
  "
  SELECT
  DATE_FORMAT(fecha, '%W ') as dia,
  DATE_FORMAT(fecha, '%e de %M %Y') as f_fecha,
  enlace
  FROM adopciones
  ORDER BY fecha desc")

(defn get-rows []
  (Query db adopciones-sql))

(defn get-adopciones [title]
  [:div.container
   [:table.table.table-hover.table-bordered
    [:caption.text-dark {:style "caption-side:top;"} title]
    [:thead.table-light
     [:tr.table-secondary
      [:th {:data-options "field:'enlace'" :style "text-align:center;"} "PROCESAR"]
      [:th {:data-options "field:'dia'"} "DIA"]
      [:th {:data-options "field:'f_fecha'"} "FECHA"]]]
    [:tbody.bg-white
     (let [cnt (atom 0)]
       (for [row (get-rows)]
         (let [button-id (str "button_" (swap! cnt inc))]
           [:tr
            [:td [:a.btn.btn-secondary {:id button-id :href (:enlace row) :target "_blank" :onclick (str "setColor('" button-id "','#FF851B');")} [:span.float-right "Ver Fotos"]]]
            [:td (:dia row)]
            [:td (:f_fecha row)]])))]]])

(defn adopciones-scripts []
  [:script
   "
   var count = 1;
   function setColor(btn, color) {
    var property = document.getElementById(btn);
    if (count == 0) {
      property.style.color = color;
      count = 1;
    } else {
      property.style.color = color;
      count = 0
    }
   }
   "])

(defn adopciones [_]
  (let [title "Fotos - Adopciones"
        ok (get-session-id)
        js (adopciones-scripts)
        content (get-adopciones title)]
    (application title ok js content)))

(comment
  (adopciones {}))