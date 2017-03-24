(ns miraj.polymer.paper.input
  (:require [miraj.co-dom :as codom]))

(alter-meta! *ns* (fn [m] (assoc m :miraj/miraj {:miraj/elements true
                                                 :miraj/nss '[]
                                                 :miraj/codom ""
                                                 :miraj/assets
                                                 {:miraj/bower
                                                  [

                                                   ]
                                                   :miraj/base ""}})))

(load "input_impl")
