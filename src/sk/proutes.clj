(ns sk.proutes
  (:require [compojure.core :refer [defroutes GET POST]]
            [sk.handlers.admin.eventos.handler :as eventos]
            [sk.handlers.admin.users.handler :as users]
            [sk.handlers.admin.historia.handler :as historia]
            [sk.handlers.admin.mision.handler :as mision]
            [sk.handlers.admin.vision.handler :as vision]
            [sk.handlers.admin.titulos.handler :as titulos]
            [sk.handlers.admin.integrantes.handler :as integrantes]
            [sk.handlers.admin.contactos.handler :as contactos]
            [sk.handlers.admin.patrocinadores.handler :as patrocinadores]
            [sk.handlers.admin.veterinarias.handler :as veterinarias]
            [sk.handlers.admin.voluntarios.handler :as voluntarios]))

(defroutes proutes
  ;; Start users
  (GET "/admin/users"  req [] (users/users req))
  (POST "/admin/users" req [] (users/users-grid req))
  (GET "/admin/users/edit/:id" [id] (users/users-form id))
  (POST "/admin/users/save" req [] (users/users-save req))
  (POST "/admin/users/delete" req [] (users/users-delete req))
  ;; End users

  ;; Start eventos
  (GET "/admin/eventos"  req [] (eventos/eventos req))
  (POST "/admin/eventos" req [] (eventos/eventos-grid req))
  (GET "/admin/eventos/edit/:id" [id] (eventos/eventos-form id))
  (POST "/admin/eventos/save" req [] (eventos/eventos-save req))
  (POST "/admin/eventos/delete" req [] (eventos/eventos-delete req))
  ;; End eventos

  ;; Start historia
  (GET "/admin/historia"  req [] (historia/historia req))
  (POST "/admin/historia" req [] (historia/historia-grid req))
  (GET "/admin/historia/edit/:id" [id] (historia/historia-form id))
  (POST "/admin/historia/save" req [] (historia/historia-save req))
  (POST "/admin/historia/delete" req [] (historia/historia-delete req))
  ;; End historia

  ;; Start mision
  (GET "/admin/mision"  req [] (mision/mision req))
  (POST "/admin/mision" req [] (mision/mision-grid req))
  (GET "/admin/mision/edit/:id" [id] (mision/mision-form id))
  (POST "/admin/mision/save" req [] (mision/mision-save req))
  (POST "/admin/mision/delete" req [] (mision/mision-delete req))
  ;; End mision

  ;; Start vision
  (GET "/admin/vision"  req [] (vision/vision req))
  (POST "/admin/vision" req [] (vision/vision-grid req))
  (GET "/admin/vision/edit/:id" [id] (vision/vision-form id))
  (POST "/admin/vision/save" req [] (vision/vision-save req))
  (POST "/admin/vision/delete" req [] (vision/vision-delete req))
  ;; End vision

  ;; Start titulos
  (GET "/admin/titulos"  req [] (titulos/titulos req))
  (POST "/admin/titulos" req [] (titulos/titulos-grid req))
  (GET "/admin/titulos/edit/:id" [id] (titulos/titulos-form id))
  (POST "/admin/titulos/save" req [] (titulos/titulos-save req))
  (POST "/admin/titulos/delete" req [] (titulos/titulos-delete req))
  ;; End titulos

  ;; Start integrantes
  (GET "/admin/integrantes"  req [] (integrantes/integrantes req))
  (POST "/admin/integrantes" req [] (integrantes/integrantes-grid req))
  (GET "/admin/integrantes/edit/:id" [id] (integrantes/integrantes-form id))
  (POST "/admin/integrantes/save" req [] (integrantes/integrantes-save req))
  (POST "/admin/integrantes/delete" req [] (integrantes/integrantes-delete req))
  ;; End integrantes

  ;; Start contactos
  (GET "/admin/contactos"  req [] (contactos/contactos req))
  (POST "/admin/contactos" req [] (contactos/contactos-grid req))
  (GET "/admin/contactos/edit/:id" [id] (contactos/contactos-form id))
  (POST "/admin/contactos/save" req [] (contactos/contactos-save req))
  (POST "/admin/contactos/delete" req [] (contactos/contactos-delete req))
  ;; End contactos

  ;; Start patrocinadores
  (GET "/admin/patrocinadores"  req [] (patrocinadores/patrocinadores req))
  (POST "/admin/patrocinadores" req [] (patrocinadores/patrocinadores-grid req))
  (GET "/admin/patrocinadores/edit/:id" [id] (patrocinadores/patrocinadores-form id))
  (POST "/admin/patrocinadores/save" req [] (patrocinadores/patrocinadores-save req))
  (POST "/admin/patrocinadores/delete" req [] (patrocinadores/patrocinadores-delete req))
  ;; End patrocinadores

  ;; Start veterinarias
  (GET "/admin/veterinarias"  req [] (veterinarias/veterinarias req))
  (POST "/admin/veterinarias" req [] (veterinarias/veterinarias-grid req))
  (GET "/admin/veterinarias/edit/:id" [id] (veterinarias/veterinarias-form id))
  (POST "/admin/veterinarias/save" req [] (veterinarias/veterinarias-save req))
  (POST "/admin/veterinarias/delete" req [] (veterinarias/veterinarias-delete req))
  ;; End veterinarias

  ;; Start voluntarios
  (GET "/admin/voluntarios"  req [] (voluntarios/voluntarios req))
  (POST "/admin/voluntarios" req [] (voluntarios/voluntarios-grid req))
  (GET "/admin/voluntarios/edit/:id" [id] (voluntarios/voluntarios-form id))
  (POST "/admin/voluntarios/save" req [] (voluntarios/voluntarios-save req))
  (POST "/admin/voluntarios/delete" req [] (voluntarios/voluntarios-delete req))
  ;; End voluntarios
  )
