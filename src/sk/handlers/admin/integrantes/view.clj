(ns sk.handlers.admin.integrantes.view
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
    {:id "titulo"
     :name "titulo"
     :class "easyui-combobox"
     :data-options "label:'Titulo:',
        labelPosition:'top',
        method:'GET',
        url:'/table_ref/get-titulos',
        required:true,
        width:'100%'"})
   (build-field
    {:id "nombre"
     :name "nombre"
     :class "easyui-textbox"
     :prompt "Nombre aqui..."
     :data-options "label:'Nombre:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "paterno"
     :name "paterno"
     :class "easyui-textbox"
     :prompt "Apellido Paterno aqui..."
     :data-options "label:'Paterno:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "materno"
     :name "materno"
     :class "easyui-textbox"
     :prompt "Apellido materno aqui..."
     :data-options "label:'Materno:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "descripcion"
     :name "descripcion"
     :class "easyui-textbox"
     :prompt "Datos extra aqui..."
     :data-options "label:'Datos extra:',
        labelPosition:'top',
        required:false,
        multiline:true,
        height:120,
        width:'100%'"})))

(defn integrantes-view [title]
  (list
   (anti-forgery-field)
   (build-table
    title
    "/admin/integrantes"
    (list
     [:th {:data-options "field:'titulo',sortable:true,width:100"
           :formatter "getTitulo"} "Titulo"]
     [:th {:data-options "field:'nombre',sortable:true,width:100"} "Nombre"]
     [:th {:data-options "field:'paterno',sortable:true,width:100"} "Paterno"]
     [:th {:data-options "field:'materno',sortable:true,width:100"} "Materno"]))
   (build-toolbar)
   (build-dialog title (dialog-fields))
   (build-dialog-buttons)))

(defn integrantes-scripts []
  (list
   (include-js "/js/grid.js")
   [:script
    "
    function getTitulo(value,row,index) {
      var result = null;
      var scriptUrl = '/table_ref/get-titulo/' + value;
      $.ajax({
        url: scriptUrl,
        type: 'get',
        dataType: 'html',
        async: false,
        success: function(data) {
          result = data;
        }
      });
      return result;
    }
     "]))