(ns core
  (:require [miraj.core :as miraj]
            [miraj.html :as h]))

(miraj/defpage ^{:base "/"} index
  "Miraj Polymer Paper Library Demo."

  ;; html metadata first
  {:html/title "Miraj Polymer Paper Library Demo"
   :html/description "This page demonstrates the Miraj Polymer Paper Library."}

  ;; (:require [miraj.polymer.iron :as iron :refer [demo-snippet]]
  ;;           [miraj.polymer.paper :as paper :refer [badge icon-button]])

  ;; (:styles [[miraj.polymer.iron.icons communication iron social]
  ;;           [miraj.polymer.iron.styles demo-helpers]
  ;;           [miraj.polymer.paper.styles color]
  ;;           ])

  ;; for boot-reload
  ;; (:js [{:src "main.js"}])

  (:body ;; FIXME: {:unresolved ""}
   (h/h1 "Miraj Polymer Paper Components Demos")

   (h/ul
    (h/li (h/a {:href "/miraj/polymer/paper/demos/badge"} "Badge"))
          )))
