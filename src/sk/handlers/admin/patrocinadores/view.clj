(ns sk.handlers.admin.patrocinadores.view
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
    {:id "comp"
     :name "comp"
     :class "easyui-textbox"
     :prompt "Nombre de la compañia/asociacion etc..."
     :data-options "label:'Compañia:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "contacto"
     :name "contacto"
     :class "easyui-textbox"
     :prompt "Contacto de la compañia/asociacion..."
     :data-options "label:'Contacto:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "direccion"
     :name "direccion"
     :class "easyui-textbox"
     :prompt "Direccion..."
     :data-options "label:'Dirección:',
        labelPosition:'top',
        required:false,
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
     :prompt "WhatsUP..."
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

(defn patrocinadores-view [title]
  (list
   (anti-forgery-field)
   (build-table
    title
    "/admin/patrocinadores"
    (list
     [:th {:data-options "field:'comp',sortable:true,width:100"} "Comp"]
     [:th {:data-options "field:'contacto',sortable:true,width:100"} "Contacto"]
     [:th {:data-options "field:'direccion',sortable:true,width:100"} "Direccion"]
     [:th {:data-options "field:'telefono',sortable:true,width:100"} "Telefono"]
     [:th {:data-options "field:'whats_up',sortable:true,width:100"} "Whats_up"]
     [:th {:data-options "field:'email',sortable:true,width:100"} "Email"]))
   (build-toolbar)
   (build-dialog title (dialog-fields))
   (build-dialog-buttons)))

(defn patrocinadores-scripts []
  (list
   (include-js "/js/grid.js")
   [:script
    (build-image-field-script)]))