(ns miraj.polymer.paper.demos.badge
  (:require [miraj.core :refer [defpage]]
            [miraj.html :as h]))

(defpage index
  "Miraj Polymer Paper Badge Demo."

  ;; html metadata first
  {::h/title "Miraj Polymer Paper Badge Demo"
   ::h/description "This page demonstrates a Miraj Polymer paper-badge."}

  (:require [miraj.polymer.iron :as iron :refer [demo-snippet]]
            [miraj.polymer.paper :as paper :refer [badge icon-button]])

  (:styles [[miraj.polymer.iron.icons communication iron social]
            [miraj.polymer.iron.styles demo]
            [miraj.polymer.paper.styles color]
            ])

  ;; for boot-reload
  ;; (:js [{:src "/main.js"}])

  (:css :custom "
    .vertical-section-container {
      max-width: 550px;
    }
    .blue {  --paper-badge-background: var(--paper-light-blue-300); }
    paper-icon-button, test-button {
      padding: 3px;
      border-radius: 3px;
      margin-left: a30px;
      margin-right: 30px;
    }")

  (:body ;; FIXME: {:unresolved ""}
   (h/body :!unresolved
           (h/h1 "Miraj Polymer " (h/span "<paper-badge>") " Demo")

           (h/div "The original demo is at "
                  (h/a {:href "https://www.webcomponents.org/element/PolymerElements/paper-badge"}
                       "webcomponents.org" ))

           (h/div :.vertical-section-container.centered
                  (h/h3 "Badges can be applied to specific elements")
                  (iron/demo-snippet :.centered-demo
                                     (h/template
                                      (paper/icon-button :#number {:icon "communication:email" :alt "inbox"})
                                      (paper/badge {:for "number" :label "4"})

                                      (paper/icon-button :#icon {:icon "account-box" :alt "person"})
                                      (paper/badge {:icon "social:mood" :for "icon" :label "happy"})))
                  ))))
