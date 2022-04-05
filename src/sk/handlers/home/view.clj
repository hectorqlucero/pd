(ns sk.handlers.home.view
  (:require [sk.models.util :refer [build-button build-field build-form]]))

(defn main-view []
  (list
   [:div#myCarousel.carousel.slide {:data-ride "carousel"}
    [:div.carousel-inner
     [:div#banner-one.carousel-item.active
      [:picture
       [:source {:media "(max-width: 425px)"
                 :srcset "images/dog1.jpg"}]
       [:source {:media "(max-width: 768px)"
                 :srcset "images/dog1.jpg"}]
       [:img.d-block.w-100 {:src "images/dog1.jpg"}]]]
     [:div#banner-two.carousel-item
      [:picture
       [:source {:media "(max-width: 425px)"
                 :srcset "images/dog2.jpg"}]
       [:source {:media "(max-width: 768px)"
                 :srcset "images/dog2.jpg"}]
       [:img.d-block.w-100 {:src "images/dog2.jpg"}]]]
     [:div#banner-three.carousel-item
      [:picture
       [:source {:media "(max-width: 425px)"
                 :srcset "images/dog3.jpg"}]
       [:source {:media "(max-width: 768px)"
                 :srcset "images/dog3.jpg"}]
       [:img.d-block.w-100 {:src "images/dog3.jpg"}]]]]]
   [:a.carousel-control-prev {:href "#myCarousel"
                              :role "button"
                              :data-slide "prev"}
    [:span.sr-only "Previous"]]
   [:a.carousel-control-next {:href "#myCarousel"
                              :role "button"
                              :data-slide "next"}
    [:span.sr-only "Next"]]))


(defn login-view [token]
  (build-form
   "Conectar"
   token
   (list
    (build-field
     {:id "username"
      :name "username"
      :class "easyui-textbox"
      :prompt "Email aqui..."
      :validType "email"
      :data-options "label:'Email:',labelPosition:'top',required:true,width:'100%'"})
    (build-field
     {:id "password"
      :name "password"
      :class "easyui-passwordbox"
      :prompt "Contraseña aqui..."
      :data-options "label:'Contraseña:',labelPosition:'top',required:true,width:'100%'"})
    (build-button
     {:href "javascript:void(0)"
      :id "submit"
      :text "Acceder al sitio"
      :class "easyui-linkbutton c6"
      :onClick "submitForm()"}))
   (list
    [:div {:style "margin-bottom:10px;"}
     [:a {:href "/register"} "Clic para registrarse"]]
    [:div {:style "margin-bottom:10px;"}
     [:a {:href "/rpaswd"} "Clic para resetear su contraseña"]])))

(defn login-script []
  [:script
   "
    function submitForm() {
        $('.fm').form('submit', {
            onSubmit:function() {
                if($(this).form('validate')) {
                  $('a#submit').linkbutton('disable');
                  $('a#submit').linkbutton({text: 'Processando!'});
                }
                return $(this).form('enableValidation').form('validate');
            },
            success: function(data) {
                try {
                    var dta = JSON.parse(data);
                    if(dta.hasOwnProperty('url')) {
                        window.location.href = dta.url;
                    } else if(dta.hasOwnProperty('error')) {
                        $.messager.show({
                            title: 'Error: ',
                            msg: dta.error
                        });
                        $('a#submit').linkbutton('enable');
                        $('a#submit').linkbutton({text: 'Acceder al sitio'});
                    }
                } catch(e) {
                    console.error('Invalid JSON');
                }
            }
        });
    }
   "])

(comment
  (main-view))