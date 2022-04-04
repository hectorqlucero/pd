(ns sk.handlers.admin.titulos.view
  (:require
   [hiccup.page :refer [include-js]]
   [ring.util.anti-forgery :refer [anti-forgery-field]]
   [sk.models.util :refer
    [build-dialog build-dialog-buttons build-field build-table build-toolbar]]))

(defn dialog-fields []
  (list
   (build-field
    {:id "id"
     :name "id"
     :type "hidden"})
   (build-field
    {:id "descripcion"
     :name "descripcion"
     :class "easyui-textbox"
     :prompt "titulo aqui..."
     :data-options "label:'Titulo:',
        labelPosition:'top',
        required:true,
        width:'100%'"})))

(defn titulos-view [title]
  (list
   (anti-forgery-field)
   (build-table
    title
    "/admin/titulos"
    (list
     [:th {:data-options "field:'descripcion',sortable:true,width:100"} "Descripcion"]))
   (build-toolbar)
   (build-dialog title (dialog-fields))
   (build-dialog-buttons)))

(defn titulos-scripts []
  (include-js "/js/grid.js"))