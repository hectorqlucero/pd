(ns sk.handlers.cuentas.model
  (:require [sk.models.crud :refer [Query db]]))

(defn get-rows [tabla]
  (Query db [(str "select * from " tabla)]))

(defn get-pais [id]
  (first (Query db ["SELECT * FROM pais WHERE id = ?" id])))

(comment
  (get-pais 1)
  (get-rows "cuentas"))