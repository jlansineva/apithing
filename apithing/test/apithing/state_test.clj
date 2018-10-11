(ns apithing.state-test
    (:require [midje.sweet   :refer :all]
              [apithing.state :refer :all]))

(def valid-api-description {
:basepath "localhost"
:api "event"
:tests [:xss :inject]
:methods [:get :post]
})

(def valid-api-description2 {
    :basepath "localhost2"
    :api "event2"
    :tests [:xss :inject]
    :methods [:get :post]
    })

(facts "About state operations"
    (facts "About descriptions stack"
        (against-background [ (before :contents (update-descriptions valid-api-description)) ]
            (fact "Latest description can be retrieved"
                (get-latest-description) => valid-api-description)
            (fact "Description is stored"
                (do (update-descriptions valid-api-description2) 
                    (get-latest-description)) => valid-api-description2)
            (fact "All descriptions are retrieved"
                (get-descriptions) => (conj [] valid-api-description valid-api-description valid-api-description2))
            (fact "Description is popped"
                (do (pop-description)
                     (get-descriptions)) => (conj [] valid-api-description valid-api-description) ))))
  