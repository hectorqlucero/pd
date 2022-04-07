(ns sk.handlers.admin.cuentas.view
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
    {:id "pais_id"
     :name "pais_id"
     :class "easyui-combobox"
     :data-options "label:'Pais:',
                 labelPosition:'top',
                 url:'/table_ref/get-paises',
                 method:'GET',
                 required:true,
                 width:'100%'"})
   (build-field
    {:id "cuenta_numero"
     :name "cuenta_numero"
     :class "easyui-textbox"
     :prompt "Numero de cuenta..."
     :data-options "label:'Cuenta:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "transferencia"
     :name "transferencia"
     :class "easyui-textbox"
     :prompt "Transferencia numero..."
     :data-options "label:'Transferencia:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "deposito_directo"
     :name "deposito_directo"
     :class "easyui-textbox"
     :prompt "Deposito directo numero..."
     :data-options "label:'Deposito Directo:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "numero_tarjeta"
     :name "numero_tarjeta"
     :class "easyui-textbox"
     :prompt "Numero de tarjeta..."
     :data-options "label:'Tarjeta:',
        labelPosition:'top',
        required:true,
        width:'100%'"})))

(defn cuentas-view [title]
  (list
   (anti-forgery-field)
   (build-table
    title
    "/admin/cuentas"
    (list
     [:th {:data-options "field:'pais_id',sortable:true,width:100"
           :formatter "getPais"} "Pais"]
     [:th {:data-options "field:'cuenta_numero',sortable:true,width:100"} "Numero de cuenta"]
     [:th {:data-options "field:'transferencia',sortable:true,width:100"} "Transferencia"]
     [:th {:data-options "field:'deposito_directo',sortable:true,width:100"} "Deposito directo"]
     [:th {:data-options "field:'numero_tarjeta',sortable:true,width:100"} "Numero de tarjeta"]))
   (build-toolbar)
   (build-dialog title (dialog-fields))
   (build-dialog-buttons)))

(defn cuentas-scripts []
  (list
   (include-js "/js/grid.js")
   [:script
    "
    function getPais(value,row,index) {
     var result = null;
     var scriptUrl = '/table_ref/get-pais/' + value;
     $.ajax({
       url: scriptUrl,
       type: 'get',
       dataType: 'html',
       async: false,
       success: function(data) {
         result = data;
       }
     })
     return result;
    }
     "]))