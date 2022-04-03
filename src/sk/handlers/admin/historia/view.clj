(ns sk.handlers.admin.historia.view
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
     :prompt "Historia aqui..."
     :data-options "label:'Historia:',
        labelPosition:'top',
        required:true,
        multiline:true,
        height:420,
        width:'100%'"})))

(defn historia-view [title]
  (list
   (anti-forgery-field)
   (build-table
    title
    "/admin/historia"
    (list
     [:th {:data-options "field:'descripcion',sortable:true,width:100"} "Descripcion"]))
   (build-toolbar)
   (build-dialog title (dialog-fields))
   (build-dialog-buttons)))

(defn historia-scripts []
  (include-js "/js/grid.js"))