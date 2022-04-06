(ns sk.handlers.admin.voluntarios.view
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
    {:id "nombre"
     :name "nombre"
     :class "easyui-textbox"
     :prompt "Nombre del voluntario..."
     :data-options "label:'Nombre:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "paterno"
     :name "paterno"
     :class "easyui-textbox"
     :prompt "Apellido paterno del voluntario..."
     :data-options "label:'Paterno:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "materno"
     :name "materno"
     :class "easyui-textbox"
     :prompt "Apellido materno del voluntario..."
     :data-options "label:'Materno:',
        labelPosition:'top',
        required:false,
        width:'100%'"})
   (build-field
    {:id "whats_up"
     :name "whats_up"
     :class "easyui-textbox"
     :prompt "Whats Up del voluntario..."
     :data-options "label:'WHATS UP:',
        labelPosition:'top',
        required:false,
        width:'100%'"})))

(defn voluntarios-view [title]
  (list
   (anti-forgery-field)
   (build-table
    title
    "/admin/voluntarios"
    (list
     [:th {:data-options "field:'nombre',sortable:true,width:100"} "Nombre"]
     [:th {:data-options "field:'paterno',sortable:true,width:100"} "Paterno"]
     [:th {:data-options "field:'materno',sortable:true,width:100"} "Materno"]
     [:th {:data-options "field:'whats_up',sortable:true,width:100"} "Whats_up"]))
   (build-toolbar)
   (build-dialog title (dialog-fields))
   (build-dialog-buttons)))

(defn voluntarios-scripts []
  (include-js "/js/grid.js"))