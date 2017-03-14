(ns miraj.polymer.paper.demos.button
  (:require [miraj.core :as miraj]
            [miraj.html :as h]
            [miraj.polymer.paper :as paper :refer [button]]
            [miraj.polymer.paper.styles :as pstyles :refer [color]]
            [miraj.polymer.iron :as iron :refer [icon]]
            [miraj.polymer.iron.icons :as icons :refer [device]]))

(miraj/defpage ^{:miraj/demonstrates miraj.polymer.paper/button} index
  "Miraj Polymer Paper Button Demo."

  ;; html metadata first
  {:html/title "Miraj Polymer Paper Button Demo"
   :html/description "This page demonstrates a Miraj Polymer paper-button."}

  ;; for boot-reload
  ;; (:js [{:src "/main.js"}])

  (:body
   (h/h1 "Miraj Polymer " (h/span "<paper-button>") " Demo")

   (h/div "The original demo is at "
          (h/a {:href "https://www.webcomponents.org/element/PolymerElements/paper-button"}
               "webcomponents.org" ))

   (h/h2 "Buttons can be flat, raised, toggleable, or disabled")
   (h/div
    (paper/button "Link")
    (paper/button {:raised ""} "raised")
    (paper/button {:toggles "" :raised ""} "toggles")
    (paper/button {:disabled ""} "disabled"))

   (h/h2 "Buttons can have icons")
   (h/div
    (paper/button (iron/icon {:icon "check"}) "link")
    (paper/button {:raised ""} (iron/icon {:icon "file-download"}) "raised")
    (paper/button {:toggles "" :raised ""} (iron/icon {:icon "favorite"}) "toggles")
    (paper/button {:disabled ""} (iron/icon {:icon "block"}) "disabled"))

   (h/h2 "Buttons can hide the ripple effect using the " (h/i "noink") " attribute")
   (h/div
    (paper/button {:noink ""} "link")
    (paper/button {:raised "" :noink ""} "raised")
    (paper/button {:toggles "" :raised "" :noink ""} "toggles")
    (paper/button {:disabled "" :noink ""} "disabled"))

   (h/h2 "Buttons can be styled using custom properties")
   (h/div
    (paper/button {:class "custom pink"} "link")
    (paper/button {:raised "" :class "custom indigo"} "raised")
    (paper/button {:toggles "" :raised "" :class "custom green"} "toggles")
    (paper/button {:disabled "" :class "custom disabled"} "disabled"))

   #_(h/div
      (greeter/hello-world))
   )

  (:css :custom "
  paper-button.custom {
    --paper-button-ink-color: var(--paper-pink-a200);
    /* These could also be individually defined for each of the
      specific css classes, but we'll just do it once as an example */
    --paper-button-flat-keyboard-focus: {
      background-color: var(--paper-pink-a200);
      color: white !important;
    };
    --paper-button-raised-keyboard-focus: {
      background-color: var(--paper-pink-a200) !important;
      color: white !important;
    };
  }
  paper-button.custom:hover {
    background-color: var(--paper-indigo-100);
  }
  paper-button.pink {
    color: var(--paper-pink-a200);

  }
  paper-button.indigo {
    background-color: var(--paper-indigo-500);
    color: white;
    --paper-button-raised-keyboard-focus: {
      background-color: var(--paper-pink-a200) !important;
      color: white !important;
    };
  }
  paper-button.green {
    background-color: var(--paper-green-500);
    color: white;
  }
  paper-button.green[active] {
    background-color: var(--paper-red-500);
  }
  paper-button.disabled {
    color: white;
  }"))

;; (stencil.loader/set-cache (clojure.core.cache/ttl-cache-factory {} :ttl 0))

;; (binding [*compile-path* "tmp"]
;;   ;;miraj/*miraj-sym* (str (gensym "miraj"))]
;;   (wc/compile-page-nss #{(-> *ns* ns-name) 'work.pages.hello} true true))

;; (binding [*compile-path* "tmp"]
;;   (wc/link-pages #{(-> *ns* ns-name) 'work.pages.hello} true))

