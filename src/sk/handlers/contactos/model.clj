(ns sk.handlers.contactos.model
  (:require [sk.models.crud :refer [Query db]]))

(defn get-rows [tabla]
  (Query db [(str "select * from " tabla)]))

(defn get-titulo [id]
  (:descripcion (first (Query db ["select descripcion from titulos where id = ?" id]))))

(comment
  (get-titulo 1)
  (get-rows "contactos"))