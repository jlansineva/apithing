(ns apithing.core-test
  (:require [midje.sweet   :refer :all]
            [apithing.core :refer :all]))

(def valid-api-description {
  :basepath "localhost"
  :api "event"
  :tests [:xss :inject]
  :methods [:get :post]
})

(def invalid-api-description {
  :basepath "localhost"
  :api "event"
  :tests [:xss :inject]
})

(facts 
  (facts "About api descriptions"
    (facts "About description validation"
      (fact "A valid api description item is returned as is"
        (validate valid-api-description) => valid-api-description)
      (fact "Invalid api description item returns a nil"
        (validate invalid-api-description) => nil))
    (facts "About describe"
      (fact "An api description item is created for new entries"
        (describe {:basepath "localhost" :api "event" :tests [:xss :inject]}) => (contains {:result :success})))
    (future-fact "API description is stored")
    (future-fact "API description is can be read")
    (future-fact "API description loaded from .edn file"))
  (fact "FIXME, I fail."
    (+ 1 1) => 1))
