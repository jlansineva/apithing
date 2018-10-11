(ns apithing.state)

(defonce state (atom { :descriptions []}))

(defn update-descriptions [description]
  (swap! state #(assoc % :descriptions (conj (:descriptions %) description)))
    {:result :success})

(defn get-descriptions [] (:descriptions @state)) 

(defn get-latest-description [] (last (:descriptions @state)))

(defn pop-description []
    (let [latest (get-latest-description)]
        (swap! state #(assoc % :descriptions (butlast (:descriptions %))))
        latest))