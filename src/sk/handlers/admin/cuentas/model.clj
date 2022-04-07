(ns sk.handlers.admin.cuentas.model
  (:require [sk.models.crud :refer [Query db]]))

(defn get-rows [tabla]
  (Query db [(str "select * from " tabla)]))

(comment
  (get-rows "cuentas"))