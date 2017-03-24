(ns miraj.polymer.paper.demos.card
  (:require [miraj.core :refer [defpage]]
            [miraj.html :as h]))

(defpage index
  "Polymer Paper Card Demo."

  ;; html metadata first
  {::h/title "Miraj Polymer Paper Card Demo"
   ::h/description "This page demonstrates a Miraj Polymer paper-card."}

  (:require [miraj.polymer.iron :as iron :refer [collapse icon demo-snippet]]
            [miraj.polymer.paper :as paper :refer [card]])

  (:styles [[miraj.polymer.iron.icons communication hardware iron social]
            [miraj.polymer.iron.styles demo flex-mixins]
            [miraj.polymer.paper.styles color typography]
            ])

  ;; for boot-reload
;;  (:js [{:src "/main.js"}])

  (:body ;; FIXME: {:unresolved ""}
   (h/body {:unresolved ""}
           (h/h1 "Miraj Polymer " (h/span "<paper-card>") " Demo")

           (h/div "The original demo is at "
                  (h/a {:href "https://www.webcomponents.org/element/PolymerElements/paper-card"}
                       "webcomponents.org" ))

           (h/div {:class "vertical-section-container centered"}

                  (h/h3 "A paper-card with a simple heading, header image, body content, and actions")
                  (iron/demo-snippet
                   (h/template
                    (paper/card {:heading "Emmental" :image "http://placehold.it/350x150/FFC107/000000"
                                 :alt "Emmental"}
                                (h/div ::.card-content
                                       "Emmentaler or Emmental is a yellow, medium-hard cheese that originated in the area around Emmental, Switzerland. It is one of the cheeses of Switzerland, and is sometimes known as Swiss cheese.")
                                (h/div ::.card-actions
                                       (paper/button "Share")
                                       (paper/button "Explore!")))))

                  (h/h3 "Paper-cards can contain advanced content")
                  (iron/demo-snippet
                   (h/template
                    (h/style {:is "custom-style"} "
            .cafe-header { @apply(--paper-font-headline); }
            .cafe-light { color: var(--paper-grey-600); }
            .cafe-location {
              float: right;
              font-size: 15px;
              vertical-align: middle;
            }
            .cafe-reserve { color: var(--google-blue-500); }
            iron-icon.star {
              --iron-icon-width: 16px;
              --iron-icon-height: 16px;
              color: var(--paper-amber-500);
            }
            iron-icon.star:last-of-type { color: var(--paper-grey-500); }
          ")
                    (paper/card {:image "/images/donuts.png" :alt "Donuts"}
                                (h/div ::.card-content
                                       (h/div ::.cafe-header "Cafe Basilico"
                                              (h/div ::.cafe-location.cafe-light
                                                     (iron/icon {:icon "communication:location-on"})
                                                     (h/span "250ft")))
                                       (h/div ::.cafe-rating
                                              (iron/icon ::.star {:icon "star"})
                                              (iron/icon ::.star {:icon "star"})
                                              (iron/icon ::.star {:icon "star"})
                                              (iron/icon ::.star {:icon "star"})
                                              (iron/icon ::.star {:icon "star"}))
                                       (h/p "$・Italian, Cafe")
                                       (h/p ::.cafe-light "Small plates, salads &amp; sandwiches in an intimate setting with 12 indoor seats plus patio seating."))
                                (h/div ::.card-actions
                                       (h/p "Tonight's availability")
                                       (h/div ::.horizontal.justified
                                              (paper/icon-button {:icon "icons:event"})
                                              (paper/button "5:30PM")
                                              (paper/button "7:30PM")
                                              (paper/button "9:00PM"))
                                       (paper/button ::.cafe-reserve "Reserve")))))
                  )))

  (:css :custom ;; :include "demo-pages-shared-styles"
        "
  demo-snippet {
      --demo-snippet-demo: {
        background: var(--paper-grey-200);
        padding: 8px;
      };
      --demo-snippet-code: {
        max-height: 300px;
      };
    }
    paper-card {
      width: 100%;
    }
    .horizontal {
      @apply(--layout-horizontal);
    }
    .justified {
      @apply(--layout-justified);
    }
    .amber {
      background: var(--paper-amber-900);
    }
    .lime {
      background: var(--paper-lime-500);
    }
    .cyan {
      background: var(--paper-cyan-500);
    }
    .dark {
      background: var(--paper-blue-grey-500);
    }
    paper-card.dark, paper-card.amber, paper-card.lime, paper-card.cyan {
      color: white;
      --paper-card-header-color: white;
    }
    paper-checkbox {
      display: block;
      margin-bottom: 4px;
      --paper-checkbox-label-color: white;
      --paper-checkbox-unchecked-color: white;
    }
    paper-icon-button {
      color: var(--paper-grey-600);
    }
    paper-icon-button.white {
      color: white !important;
    }"))

(println "CARD META:" (-> index var meta))


