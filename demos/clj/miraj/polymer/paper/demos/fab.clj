(ns miraj.polymer.paper.demos.fab
  (:require [miraj.core :refer [defpage]]
            [miraj.html :as h]))

(defpage
  "Miraj Polymer Paper Fab Demo."

  ;; html metadata first
  {::h/title "Miraj Polymer Paper Fab Demo"
   ::h/description "This page demonstrates a Miraj Polymer paper-fab."}

  (:require [miraj.polymer.iron :as iron :refer [demo-snippet]]
            [miraj.polymer.paper :as paper :refer [fab icon-button]])

  (:styles [[miraj.polymer.iron.icons iron]
            [miraj.polymer.paper.styles color]
            ])

  (:body :!unresolved
         (h/div :.vertical-section-container.centered
                (h/h1 "Miraj Polymer " (h/span "<paper-fab>") " Demo")

                (h/div "The original demo is at "
                       (h/a {:href "https://www.webcomponents.org/element/PolymerElements/paper-fab"}
                            "webcomponents.org" ))

                (h/h3 "FABs can be enabled or disabled")
                (iron/demo-snippet
                 :.centered-demo
                 (h/template
                  (h/style "
          paper-fab.label {
            font-size: 20px;
          }
        ")
                  (paper/fab :!mini {:icon "favorite" :title "heart"})
                  (paper/fab :!mini!disabled {:icon "reply" :title "reply"})
                  (paper/fab :.label!mini {:label "😻" :title "heart eyes cat"})))

                (h/h3 "FABs can be made smaller using the " (h/i "mini") " attribute")
                (iron/demo-snippet
                 :.centered-demo
                 (h/template
                  (paper/fab :!mini {:icon "favorite" :title "heart"})
                  (paper/fab :!mini!disabled {:icon "reply" :title "reply"})
                  (paper/fab :!mini.label {:label "😻" :title "heart eyes cat"})))

                (h/h3 "FABs can hide the ripple effect using the " (h/i "noink") " attribute")
                (iron/demo-snippet
                 :.centered-demo
                 (h/template
                  (paper/fab :!noink {:icon "favorite" :title "heart"})))

                (h/h3 "FABs can be styled using custom properties")
                (iron/demo-snippet
                 :.centered-demo
                 (h/template
                  (h/style {:is "custom-style"} "
          paper-fab.blue {
            --paper-fab-background: var(--paper-light-blue-500);
            --paper-fab-keyboard-focus-background: var(--paper-light-blue-900);
          }
          paper-fab.orange {
            --paper-fab-background: var(--paper-orange-500);
            --paper-fab-keyboard-focus-background: var(--paper-orange-900);
          }
        ")

                  (paper/fab {:icon "favorite" :title "heart"} :.blue)
                  (paper/fab {:icon "favorite" :title "heart"} :.orange))))))
