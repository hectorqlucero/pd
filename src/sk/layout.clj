(ns sk.layout
  (:require [clj-time.core :as t]
            [hiccup.page :refer [html5 include-css include-js]]
            [sk.models.util :refer [user-level user-name]]
            [sk.user :as user]))

(defn build-admin []
  (list
   [:a.dropdown-item {:href "/admin/eventos"} "Eventos"]
   [:a.dropdown-item {:href "/admin/historia"} "Historia"]
   [:a.dropdown-item {:href "/admin/mision"} "Misión"]
   [:a.dropdown-item {:href "/admin/vision"} "Visión"]
   [:a.dropdown-item {:href "/admin/titulos"} "Titulo"]
   [:a.dropdown-item {:href "/admin/integrantes"} "Integrantes"]
   [:a.dropdown-item {:href "/admin/contactos"} "Contactos"]
   [:a.dropdown-item {:href "/admin/patrocinadores"} "Patrocinadores"]
   [:a.dropdown-item {:href "/admin/veterinarias"} "Veterinarias"]
   [:a.dropdown-item {:href "/admin/voluntarios"} "Voluntarios"]
   [:a.dropdown-item {:href "/admin/pais"} "Pais"]
   [:a.dropdown-item {:href "/admin/cuentas"} "Cuentas Bancarias"]
   [:a.dropdown-item {:href "/admin/fotos"} "Fotos"]
   [:a.dropdown-item {:href "/admin/adopciones"} "Fotos - Adopciones"]
   [:a.dropdown-item {:href "/admin/videos"} "Videos"]
   [:a.dropdown-item {:href "/admin/articulos"} "Articulos de Venta"]
   [:a.dropdown-item {:href "/admin/users"} "Usuarios"]))

(defn menus-private []
  (list
   [:nav.navbar.navbar-expand-sm.navbar-light.bg-light.fixed-top
    [:a.navbar-brand {:href "/"}
     [:img.rounded-circle {:src "/images/logo.jpeg"
                           :alt (:site-name user/config)
                           :style "width:40px;"}]]
    [:button.navbar-toggler {:type "button"
                             :data-toggle "collapse"
                             :data-target "#collapsibleNavbar"}
     [:span.navbar-toggler-icon]]
    [:div#collapsibleNavbar.collapse.navbar-collapse
     [:ul.navbar-nav
      [:li-nav-item [:a.nav-link {:href "/eventos/list"} "Eventos"]]
      [:li-nav-item [:a.nav-link {:href "/historia"} "Historia"]]
      [:li-nav-item [:a.nav-link {:href "/mision"} "Misión"]]
      [:li-nav-item [:a.nav-link {:href "/vision"} "Visión"]]
      [:li-nav-item [:a.nav-link {:href "/integrantes"} "Integrantes"]]
      [:li-nav-item [:a.nav-link {:href "/contactos"} "Contacto"]]
      [:li-nav-item [:a.nav-link {:href "/patrocinadores"} "Patrocinadores"]]
      [:li-nav-item [:a.nav-link {:href "/veterinarias"} "Veterinarias de Apoyo"]]
      [:li-nav-item [:a.nav-link {:href "/voluntarios"} "Voluntarios"]]
      [:li-nav-item [:a.nav-link {:href "/cuentas"} "Cuentas Bancarias"]]
      [:li-nav-item [:a.nav-link {:href "/fotos"} "Fotos"]]
      [:li-nav-item [:a.nav-link {:href "/adopciones"} "Fotos - Adopciones"]]
      [:li-nav-item [:a.nav-link {:href "/videos"} "Videos"]]
      [:li-nav-item [:a.nav-link {:href "/articulos"} "Articulos de venta"]]
      (when
       (or
        (= (user-level) "A")
        (= (user-level) "S"))
        [:li.nav-item.dropdown
         [:a.nav-link.dropdown-toggle {:href "#"
                                       :id "navdrop"
                                       :data-toggle "dropdown"} "Administrar"]
         [:div.dropdown-menu
          (build-admin)]])
      [:li.nav-item [:a.nav-link {:href "/home/logoff"} (str "Salir [" (user-name) "]")]]]]]))

(defn menus-public []
  (list
   [:nav.navbar.navbar-expand-sm.navbar-light.bg-light.fixed-top
    [:a.navbar-brand {:href "/"}
     [:img.rounded-circle {:src "/images/logo.jpeg"
                           :alt (:site-name user/config)
                           :style "width:40px;"}]]
    [:button.navbar-toggler {:type "button"
                             :data-toggle "collapse"
                             :data-target "#collapsibleNavbar"}
     [:span.navbar-toggler-icon]]
    [:div#collapsibleNavbar.collapse.navbar-collapse
     [:ul.navbar-nav
      [:li-nav-item [:a.nav-link {:href "/eventos/list"} "Eventos"]]
      [:li-nav-item [:a.nav-link {:href "/historia"} "Historia"]]
      [:li-nav-item [:a.nav-link {:href "/mision"} "Misión"]]
      [:li-nav-item [:a.nav-link {:href "/vision"} "Visión"]]
      [:li-nav-item [:a.nav-link {:href "/integrantes"} "Integrantes"]]
      [:li-nav-item [:a.nav-link {:href "/contactos"} "Contacto"]]
      [:li-nav-item [:a.nav-link {:href "/patrocinadores"} "Patrocinadores"]]
      [:li-nav-item [:a.nav-link {:href "/veterinarias"} "Veterinarias de Apoyo"]]
      [:li-nav-item [:a.nav-link {:href "/voluntarios"} "Voluntarios"]]
      [:li-nav-item [:a.nav-link {:href "/cuentas"} "Cuentas Bancarias"]]
      [:li-nav-item [:a.nav-link {:href "/fotos"} "Fotos"]]
      [:li-nav-item [:a.nav-link {:href "/adopciones"} "Fotos - Adopciones"]]
      [:li-nav-item [:a.nav-link {:href "/videos"} "Videos"]]
      [:li-nav-item [:a.nav-link {:href "/articulos"} "Articulos de venta"]]
      [:li.nav-item [:a.nav-link {:href "/home/login"} "Conectar"]]]]]))

(defn menus-none []
  (list
   [:nav.navbar.navbar-expand-sm.navbar-light.bg-light.fixed-top
    [:a.navbar-brand {:href "/"}
     [:img.rounded-circle {:src "/images/logo.jpeg"
                           :alt (:site-name user/config)
                           :style "width:40px;"}]]
    [:button.navbar-toggler {:type "button"
                             :data-toggle "collapse"
                             :data-target "#collapsibleNavbar"}
     [:span.navbar-toggler-icon]]
    [:div#collapsibleNavbar.collapse.navbar-collapse]]))

(defn app-css []
  (list
   (include-css "/bootstrap/css/bootstrap.min.css")
   (include-css "/bootstrap/css/lumen.min.css")
   (include-css "https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css")
   (include-css "/easyui/themes/gray/easyui.css")
   (include-css "/easyui/themes/icon.css")
   (include-css "/easyui/themes/color.css")
   (include-css "/css/main.css")
   (include-css "/RichText/src/richtext.min.css")))

(defn app-js []
  (list
   (include-js "/easyui/jquery.min.js")
   (include-js "/popper/popper.min.js")
   (include-js "/bootstrap/js/bootstrap.min.js")
   (include-js "/easyui/jquery.easyui.min.js")
   (include-js "/easyui/jquery.edatagrid.js")
   (include-js "/easyui/datagrid-detailview.js")
   (include-js "/easyui/datagrid-groupview.js")
   (include-js "/easyui/datagrid-bufferview.js")
   (include-js "/easyui/datagrid-scrollview.js")
   (include-js "/easyui/datagrid-filter.js")
   (include-js "/easyui/locale/easyui-lang-es.js")
   (include-js "/RichText/src/jquery.richtext.min.js")
   (include-js "/js/main.js")))

(defn application [title ok js & content]
  (html5 {:ng-app (:site-name user/config) :lang "en"}
         [:head
          [:title (if title
                    title
                    (:site-name user/config))]
          [:meta {:charset "UTF-8"}]
          [:meta {:name "viewport"
                  :content "width=device-width, initial-scale=1"}]
          (app-css)
          [:link {:rel "shortcut icon"
                  :type "image/x-icon"
                  :href "data:image/x-icon;,"}]]
         [:body {:style "width:100vw;height:93vh;"}
          (cond
            (= ok -1) (menus-none)
            (= ok 0) (menus-public)
            (> ok 0) (menus-private))
          [:div.container-fluid {:style "margin-top:55px;width:100vw;height:92vh;"}
           [:div.easyui-panel {:data-options "fit:true,border:false" :style "padding:5px;"} content]]
          (app-js)
          js]
         [:footer#f-layout.bg-secondary.text-center.fixed-bottom {:style "background-color:#ff69b4 !important;"}
          [:span  "Copyright &copy" (t/year (t/now)) " Pet-Daleando - All Rights Reserved"]]))

(defn error-404 [content return-url]
  (html5 {:ng-app (:site-name user/config) :lang "es"}
         [:head
          [:title "Mesaje"]
          [:meta {:charset "UTF-8"}]
          [:meta {:name "viewport"
                  :content "width=device-width, initial-scale=1"}]
          (app-css)
          [:link {:rel "shortcut icon"
                  :type "image/x-icon"
                  :href "data:image/x-icon;,"}]]
         [:body {:style "width:100vw;height:98vh;border:1px solid #000;background-color:#ff69b4 !important;"}
          [:div.container {:style "height:88vh;margin-top:75px;background-color:#ff69b4 !important;"}
           (menus-none)
           [:div.easyui-panel {:data-options "fit:true,border:false" :style "padding-left:14px;background-color:#ff69b4 !important;"}
            [:div {:style "background-color:#ff69b4 !important;"}
             [:p [:h3 [:b "Mensaje: "]] content]
             [:p [:h3 [:a {:href return-url} "Clic aqui para " [:strong "Continuar"]]]]]]]

          (app-js)
          nil]
         [:footer#f-layout.bg-secondary.text-center.fixed-bottom {:style "background-color:#ff69b4 !important;"}
          [:span  "Copyright &copy" (t/year (t/now)) " Pet-Daleando - All Rights Reserved"]]))
