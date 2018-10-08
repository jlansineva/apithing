(ns apithing.attacks.core
    (:require [clj-http.client :as client]))

(defmulti attack!
    (fn [_ options] (:method options)))

(defmethod attack! :inject ([target options] "injecting"))

(defmethod attack! :xss ([target options] "xss"))