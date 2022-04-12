(ns sk.handlers.admin.articulos.view
  (:require
   [hiccup.page :refer [include-js]]
   [ring.util.anti-forgery :refer [anti-forgery-field]]
   [sk.models.util :refer
    [build-dialog build-dialog-buttons build-field build-table build-toolbar build-image-field build-image-field-script]]))

(defn dialog-fields []
  (list
   (build-field
    {:id "id"
     :name "id"
     :type "hidden"})
   (build-image-field)
   (build-field
    {:id "descripcion"
     :name "descripcion"
     :class "easyui-textbox"
     :prompt "Descripcion del articulo..."
     :data-options "label:'Descripcion:',
        labelPosition:'top',
        required:true,
        multiline:true,
        height:120,
        width:'100%'"})
   (build-field
    {:id "precio"
     :name "precio"
     :class "easyui-numberbox"
     :prompt "Precio del articulo..."
     :data-options "label:'Precio:',
        labelPosition:'top',
        min: 0,
        precision: 2,
        required:true,
        width:'100%'"})
   (build-field
    {:id "contacto"
     :name "contacto"
     :class "easyui-textbox"
     :prompt "Contacto del articulo..."
     :data-options "label:'Contacto:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "telefono"
     :name "telefono"
     :class "easyui-textbox"
     :prompt "Telefono/Celular..."
     :data-options "label:'Telefono:',
        labelPosition:'top',
        required:false,
        width:'100%'"})
   (build-field
    {:id "whats_up"
     :name "whats_up"
     :class "easyui-textbox"
     :prompt "WHATSUP..."
     :data-options "label:'Whats UP:',
        labelPosition:'top',
        required:false,
        width:'100%'"})
   (build-field
    {:id "email"
     :name "email"
     :class "easyui-textbox"
     :prompt "Correo electronico..."
     :data-options "label:'Email:',
        labelPosition:'top',
        required:false,
        width:'100%'"})))

(defn articulos-view [title]
  (list
   (anti-forgery-field)
   (build-table
    title
    "/admin/articulos"
    (list
     [:th {:data-options "field:'descripcion',sortable:true,width:100"} "Descripcion"]
     [:th {:data-options "field:'precio',sortable:true,width:100"} "Precio"]
     [:th {:data-options "field:'contacto',sortable:true,width:100"} "Contacto"]
     [:th {:data-options "field:'telefono',sortable:true,width:100"} "Telefono"]
     [:th {:data-options "field:'whats_up',sortable:true,width:100"} "Whats UP"]
     [:th {:data-options "field:'email',sortable:true,width:100"} "Email"]))
   (build-toolbar)
   (build-dialog title (dialog-fields))
   (build-dialog-buttons)))

(defn articulos-scripts []
  (list
   (include-js "/js/grid.js")
   [:script
    (build-image-field-script)]))