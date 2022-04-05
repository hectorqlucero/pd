(ns sk.handlers.admin.veterinarias.view
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
     :prompt "Nombre de la veterinaria o veterinario..."
     :data-options "label:'Nombre:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "descripcion"
     :name "descripcion"
     :class "easyui-textbox"
     :prompt "Informacion extra...."
     :data-options "label:'Informacion:',
        labelPosition:'top',
        required:false,
        multiline:true,
        height:120,
        width:'100%'"})
   (build-field
    {:id "direccion"
     :name "direccion"
     :class "easyui-textbox"
     :prompt "Donde esta, domicilio..."
     :data-options "label:'Domicilio:',
        labelPosition:'top',
        required:false,
        width:'100%'"})
   (build-field
    {:id "telefono"
     :name "telefono"
     :class "easyui-textbox"
     :prompt "Telefono o celular..."
     :data-options "label:'Telefono:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "urgencias"
     :name "urgencias"
     :class "easyui-textbox"
     :prompt "Telefono o celular de emergencias..."
     :data-options "label:'Emergencias:',
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

(defn veterinarias-view [title]
  (list
   (anti-forgery-field)
   (build-table
    title
    "/admin/veterinarias"
    (list
     [:th {:data-options "field:'comp',sortable:true,width:100"} "Comp"]
     [:th {:data-options "field:'descripcion',sortable:true,width:100"} "Descripcion"]
     [:th {:data-options "field:'direccion',sortable:true,width:100"} "Direccion"]
     [:th {:data-options "field:'telefono',sortable:true,width:100"} "Telefono"]
     [:th {:data-options "field:'urgencias',sortable:true,width:100"} "Urgencias"]
     [:th {:data-options "field:'email',sortable:true,width:100"} "Email"]))
   (build-toolbar)
   (build-dialog title (dialog-fields))
   (build-dialog-buttons)))

(defn veterinarias-scripts []
  (list
   (include-js "/js/grid.js")
   [:script
    (build-image-field-script)]))