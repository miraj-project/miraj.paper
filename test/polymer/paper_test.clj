(ns ^{:doc "Test resource handling"
      :author "Gregg Reynolds"}
    polymer.paper-test
  ;;  (:refer-clojure :exclude [import require])
  (:require [clojure.java.io :as io]
            [clojure.test :refer :all]
            [miraj.co-dom :refer :all]
            [miraj.polymer.paper :refer :all :as paper]))

;;(pprint (require '[miraj.polymer.paper :as paper :refer [button]]))

(deftest button-test
  (require '[miraj.polymer.paper :as paper :refer [button]]))

(println "ns meta: " (meta (find-ns 'miraj.polymer.paper)))
(def b (paper/button))

(println "b: " b)

(println "meta b: " (meta b))
(println "meta var b: " (meta (var b)))

(println "b, serialized: " (serialize b))

(def c (paper/card (paper/button "hello")))

(println "c: " c)
(println "c serial: " (serialize c))

#_(deftest ^:resources res-1
  (let [e (serialize (require '[miraj.polymer.paper :as paper :refer [button]]))]
    (is (= e
           "<link rel=\"import\" href=\"bower_components/paper-button/paper-button.html\">"))))

#_(deftest ^:resources res-2
  (let [e (serialize (require '[miraj.polymer.paper :as paper :refer [button]]))]
    (is (= e
           "<link rel=\"import\" href=\"bower_components/paper-button/paper-button.html\">"))
    (is (= (serialize (paper/button)) "<paper-button></paper-button>"))))

