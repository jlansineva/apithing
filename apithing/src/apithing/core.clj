(ns apithing.core
  (:gen-class)
  (:require [apithing.state :as state]))

(defn- has-key? [item key]
  (when (contains? item key) item))

(defn validate [description]
  (some-> description
    (has-key? :basepath)
    (has-key? :tests)     
    (has-key? :api)       
    (has-key? :methods)   
      ))

(defn describe [parameters]
  (when (not (nil? (validate parameters)))
    (state/update-descriptions parameters)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
