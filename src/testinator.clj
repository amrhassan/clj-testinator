(ns testinator
  (:require [clojure.test :refer :all]
            [clojure.spec.test.alpha :as stest]
            [orchestra.spec.test :as orchestra]))

(defmacro defspectest
  "Runs a generative test for the given symbol according to its spec."
  [sym]
  `(do
     (assert (symbol? ~sym) "Given value is not a symbol (use ` to quote the symbol)")
     (orchestra/instrument ~sym)
     (is (nil? (some :failure (stest/check ~sym))))))