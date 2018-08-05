(ns testinator-test
  (:require [clojure.test :refer :all]
            [testinator :refer :all]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]
            [orchestra.spec.test :as orchestra]))

(s/fdef well-defined-func
  :args (s/cat :first number?
               :second number?)
  :ret string?)

(defn well-defined-func
  "Returns string representation of the added two input
   values a value."
  [x y]
  (str (+ x y)))

(defspectest `well-defined-func)
