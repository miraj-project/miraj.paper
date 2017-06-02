(ns miraj.polymer.paper.demos.tabs
  (:require [miraj.core :refer [defpage]]
            [miraj.html :as h]))

(defpage
  "Miraj Polymer Paper Tabs Demo."

  ;; html metadata first
  {::h/title "Miraj Polymer Paper Tabs Demo"
   ::h/description "This page demonstrates a Miraj Polymer paper-tabs."}

  (:require [miraj.polymer.iron :as iron :refer [demo-snippet pages]]
            [miraj.polymer.paper :as paper :refer [tab tabs toolbar]])

  (:styles [[miraj.polymer.iron.styles demo flex-mixins]])

  (:body
   :!unresolved
   (h/div
    :.vertical-section-container.centered
    (h/h1 "Miraj Polymer " (h/span "<paper-fab>") " Demo")

    (h/div "The original demo is at "
           (h/a {:href "https://www.webcomponents.org/element/PolymerElements/paper-fab"}
                "webcomponents.org" ))

      (h/h3 "Plain " (h/code "paper-tabs") ".")
      (iron/demo-snippet
        (h/template
          (paper/tabs {:selected "0"}
            (paper/tab "ITEM ONE")
            (paper/tab "ITEM TWO")
            (paper/tab "ITEM THREE"))))

      (h/h3 "The " (h/code "no-bar") " attribute disables the selection bar.")
      (iron/demo-snippet
        (h/template
          ;; (h/style {:is "custom-style"} "
          ;;   paper-tabs[no-bar] paper-tab.iron-selected {
          ;;     color: #ffff8d;
          ;;   }
          ;; ")

          (paper/tabs :#plain-tabs {:selected "0"} :!no-bar
            (paper/tab "ITEM ONE")
            (paper/tab "ITEM TWO")
            (paper/tab "ITEM THREE"))))

      (h/h3 "The " (h/code "no-slide") " attribute prevents the selection bar from
        animating when the selection changes.")
      (iron/demo-snippet
        (h/template
          (paper/tabs {:selected "0"} :!no-slide
            (paper/tab "ITEM ONE")
            (paper/tab "ITEM TWO")
            (paper/tab "ITEM THREE"))))

      (h/h3 "The " (h/code "noink") " attribute disables the ink ripple animation seen
        when the user activates a tab (by clicking, tapping, etc.).")
      (iron/demo-snippet
        (h/template
          (paper/tabs {:selected "0"} :!noink
            (paper/tab "ITEM ONE")
            (paper/tab "ITEM TWO")
            (paper/tab "ITEM THREE"))))

      (h/h3 "The " (h/code "scrollable") " attribute causes the tabs to scroll, rather
        than compress, when there is not enough space. Arrow buttons appear when
        any of the tabs are not completely visible.")
      (iron/demo-snippet
        (h/template
          (paper/tabs {:selected "0"} :!scrollable
            (paper/tab "NUMBER ONE ITEM")
            (paper/tab "ITEM TWO")
            (paper/tab "THE THIRD ITEM")
            (paper/tab "THE ITEM FOUR")
            (paper/tab "FIFTH")
            (paper/tab "THE SIXTH TAB")
            (paper/tab "NUMBER SEVEN")
            (paper/tab "EIGHT")
            (paper/tab "NUMBER NINE")
            (paper/tab "THE TENTH")
            (paper/tab "THE ITEM ELEVEN")
            (paper/tab "TWELFTH ITEM"))))

      (h/h3 "The " (h/code "fit-container") " attribute causes scrollable tabs to
        stretch to fit their container if the tabs don't need to scroll.")
      (iron/demo-snippet
        (h/template
          (paper/tabs {:selected "0"} :!scrollable!fit-container
            (paper/tab "NUMBER ONE ITEM")
            (paper/tab "ITEM TWO")
            (paper/tab "THE THIRD ITEM"))
          (h/br)
          (paper/tabs {:selected "0" :style "width: 50%;"} :!scrollable!fit-container
            (paper/tab "NUMBER ONE ITEM")
            (paper/tab "ITEM TWO")
            (paper/tab "THE THIRD ITEM"))))

      (h/h3 "Tab layout is affected by the writing direction of the surrounding area.")
      (iron/demo-snippet
        (h/template
          (h/div {:dir "rtl"}
            (paper/tabs {:selected "0"}
              (paper/tab "ITEM ONE")
              (paper/tab "ITEM TWO")
              (paper/tab "ITEM THREE"))
            "&nbsp;"
            (paper/tabs {:selected "0"} :!scrollable
              (paper/tab "NUMBER ONE ITEM")
              (paper/tab "ITEM TWO")
              (paper/tab "THE THIRD ITEM")
              (paper/tab "THE ITEM FOUR")
              (paper/tab "FIFTH")
              (paper/tab "THE SIXTH TAB")
              (paper/tab "NUMBER SEVEN")
              (paper/tab "EIGHT")
              (paper/tab "NUMBER NINE")
              (paper/tab "THE TENTH")
              (paper/tab "THE ITEM ELEVEN")
              (paper/tab "TWELFTH ITEM")))))

      (h/h3 "Use the " (h/code "align-bottom") " attribute when your tabs are
        positioned below the content they control. The selection bar will be
        shown at the top of the tabs.")
      (iron/demo-snippet
        (h/template
          (paper/tabs {:selected "0"} :!align-bottom
            (paper/tab "ITEM ONE")
            (paper/tab "ITEM TWO")
            (paper/tab "ITEM THREE"))))

      (h/h3 "Use the " (h/code "link") " attribute when a " (h/code "paper-tab") "
        contains a link. The link will fill the entire tab. " (h/code "paper-tabs") "
        implements its own tabindexing and keyboard focus patterns so an anchor
        placed inside should set " (h/code "tabindex="-1"") ".")
      (iron/demo-snippet
        (h/template
          ;; <style is="custom-style">
          ;;   paper-tab[link] a {
          ;;     /* These mixins (from iron-flex-layout) center the link text. */
          ;;     @apply(--layout-horizontal);
          ;;     @apply(--layout-center-center);
          ;;     color: #fff;
          ;;     text-decoration: none;
          ;;   }
          ;; </style>

          (paper/tabs {:selected "0"}
            (paper/tab :!link (h/a {:href "#item1" :tabindex "-1"} "ITEM ONE"))
            (paper/tab :!link (h/a {:href "#item2" :tabindex "-1"} "ITEM TWO"))
            (paper/tab :!link (h/a {:href "#item3" :tabindex "-1"} "ITEM THREE")))))

      (h/h3 "Tabs can be used in a " (h/code "paper-toolbar") ".")
      (iron/demo-snippet
        (h/template
          ;; <style is="custom-style">
          ;;   paper-toolbar {
          ;;     --paper-toolbar-background: var(--paper-blue-900);
          ;;   }

          ;;   .self-end {
          ;;     /* This mixin (from iron-flex-layout) aligns the tabs to the
          ;;        bottom of the toolbar. */
          ;;     @apply(--layout-self-end);
          ;;   }
          ;; </style>

         (paper/toolbar :.tall
            (paper/tabs {:selected "0"
                         :$width "300px;"}
                        :.bottom.self-end
              (paper/tab "ITEM ONE")
              (paper/tab "ITEM TWO")))))

      (h/h3 "Use " (h/code "autoselect") " to enable automatic tab selection.")
      (iron/demo-snippet
        (h/template
          (paper/tabs {:selected "0"} :!autoselect
            (paper/tab "ITEM ONE")
            (paper/tab "ITEM TWO")
            (paper/tab "ITEM THREE"))))

      (h/h3 "Use " (h/code "autoselect-delay") " to adjust the delay between the last
        keyup event and when the tab is automatically selected (when " (h/code "autoselect") " is true).")
      (iron/demo-snippet
        (h/template
         (h/h4 (h/code "autoselect-delay=\"0\""))
         (paper/tabs :!no-slide!autoselect {:selected "0" :autoselect-delay "0"}
            (paper/tab "ITEM ONE")
            (paper/tab "ITEM TWO")
            (paper/tab "ITEM THREE"))

         (h/h4 (h/code "autoselect-delay=\"1000\""))
         (paper/tabs {:selected "0" :autoselect-delay "1000"} :!autoselect
            (paper/tab "ITEM ONE")
            (paper/tab "ITEM TWO")
            (paper/tab "ITEM THREE"))))

      ;; Nested templates are not supported in IE, meaning they can't be used in a
      ;; demo-snippet. See Polymer/polymer#2495 for more details.
      ;;
      ;; (h/h3 "J. Bound Selection")
      ;; (iron/demo-snippet
      ;;   (h/template
      ;;     (h/template {:is="dom-bind"}
      ;;                 (h/h2 "Current Tab: " (h/span 'selected))
      ;;       (paper/tabs {:selected :selected}
      ;;         (paper/tab "ITEM ONE")
      ;;         (paper/tab "ITEM TWO")
      ;;         (paper/tab "ITEM THREE")))))

      ;; (h/h3 "K. Controlling content")
      ;; (iron/demo-snippet
      ;;   (h/template
      ;;     (h/style {:is "custom-style"} "
      ;;       iron-pages {
      ;;         border: 1px solid #ccc;
      ;;         border-top: none;
      ;;         padding: 8px;
      ;;       }
      ;;     ")

      ;;     (h/template {:is "dom-bind"}
      ;;       (paper/tabs {:selected :selected}
      ;;         (paper/tab "ITEM ONE")
      ;;         (paper/tab "ITEM TWO")
      ;;         (paper/tab "ITEM THREE"))

      ;;       (iron/pages {:selected :selected}
      ;;         (h/div "CONTENT ONE")
      ;;         (h/div "CONTENT TWO")
      ;;         (h/div "CONTENT THREE")))))
      )))
