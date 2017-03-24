(ns miraj.polymer.paper.demos.dialog
  (:require [miraj.core :refer [defpage]]
            [miraj.html :as h]))

(defpage
  "Miraj Polymer Paper Dialog Demo."

  ;; html metadata first
  {::h/title "Miraj Polymer Paper Dialog Demo"
   ::h/description "This page demonstrates a Miraj Polymer paper-dialog."}

  (:require [miraj.polymer.paper :as paper :refer [button dropdown-menu menu item
                                                   dialog dialog-scrollable]]
            [miraj.polymer.iron :as iron :refer [demo-snippet pages]])

  ;; (:extensions [miraj.polymer.neon :as neon :refer [animations]])

  (:styles [;; [miraj.polymer.iron.styles demo]
            [miraj.polymer.paper.styles color demo-pages]
            ])

  (:body :.centered!unresolved
         (h/h1 "Miraj Polymer " (h/span "<paper-dialog>") " Demo")

         (h/div "The original demo is at "
                (h/a {:href "https://www.webcomponents.org/element/PolymerElements/paper-dialog"}
                     "webcomponents.org" ))

         (h/h3 "Dialog layouts")
         (iron/demo-snippet
          (h/template
           (paper/button :!raised {:onclick "dialog.open()"} "plain dialog")
           (paper/button :!raised {:onclick "modal.open()"} "modal dialog")
           (paper/button :!raised {:onclick "scrolling.open()"} "scrolling dialog")
           (paper/button :!raised {:onclick "actions.open()"} "dialog with actions")
           (paper/button :!raised {:onclick "dropdownDialog.open()"} "dialog with dropdown")
           (paper/button :!raised {:onclick "nested.open()"} "dialog with nested dialog")

           (paper/dialog :#dialog
                         (h/h2 "Dialog Title")
                         (h/p "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
          irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."))

      (paper/dialog :#scrolling
        (h/h2 "Scrolling")
        (paper/dialog-scrollable
          (h/p "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
            irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
          (h/p "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
            irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
          (h/p "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
            irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
          (h/p "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
            irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
          (h/p "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
            irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
          (h/p "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
            irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
          (h/p "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
            irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
          (h/p "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
            irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."))

        (h/div :.buttons
          (paper/button :!dialog-dismiss "Cancel")
          (paper/button :!dialog-confirm!autofocus "OK")))

      (paper/dialog :#actions
        (h/h2 "Dialog Title")
        (h/p "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
          irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
        (h/div :.buttons
          (paper/button "More Info...")
          (paper/button :!dialog-dismiss "Decline")
          (paper/button :!dialog-confirm!autofocus "Accept")))

      (paper/dialog :#modal!modal
        (h/p "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")
        (h/div :.buttons
          (paper/button :!dialog-confirm!autofocus "Tap me to close")))

      (paper/dialog :#dropdownDialog
        (h/h2 "Dialog Title")
        (paper/dropdown-menu {:label "Value"}
          (paper/menu :.dropdown-content
            (paper/item "1")
            (paper/item "2")
            (paper/item "3")
            (paper/item "4")
            (paper/item "5")
            (paper/item "6")
            (paper/item "7")
            (paper/item "8")
            (paper/item "9")
            (paper/item "10"))))

      (paper/dialog :#nested
        (h/h2 "Dialog Title")
        (h/p "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
          irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
        (h/div :.buttons
          (paper/button {:onclick "innerDialog.open()"} "Open nested dialog")))

      (paper/dialog :#innerDialog
        (h/h2 "Dialog Title")
        (h/p "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))))

         (h/h3 "Styling and positioning")
         (iron/demo-snippet
          (h/template
           (h/style {:is "custom-style"} "
        paper-dialog.colored {
          border: 2px solid;
          border-color: var(--paper-green-500);
          background-color: var(--paper-light-green-50);
          color: var(--paper-green-500);
        }

        paper-dialog.size-position {
          position: fixed;
          top: 16px;
          right: 16px;
          width: 300px;
          height: 300px;
          overflow: auto;
        }
      ")
      (paper/button :!raised {:onclick "colors.open()"} "colors")
      (paper/button :!raised {:onclick "position.open()"} "size &amp; position")

      (paper/dialog :#colors.colored
        (h/h2 "Custom Colors")
        (h/p "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
          dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."))

      (paper/dialog :#position.size-position
        (h/h2 "Custom Size &amp; Position")
        (h/p "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
          dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."))))

         (h/h3 "Position with " (h/code "positionTarget"))
         (iron/demo-snippet
          (h/template
           (h/style {:is "custom-style"} "
        #alignedDialog {
          margin: 0;
        }
      ")
      (paper/button :!raised {:onclick "openBy(this)"} "Open")
      (paper/button :!raised {:onclick "openBy(this)"} "Open")
      (paper/button :!raised {:onclick "openBy(this)"} "Open")

      (paper/dialog :#alignedDialog!no-overlap {:horizontal-align "left"
                                                :vertical-align "top"}
        (h/h2 "Aligned dialog")
        (paper/dialog-scrollable
          " Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
          dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."))

      (h/script "
        function openBy(element) {
          alignedDialog.positionTarget = element;
          alignedDialog.open();
        }
      ")))

         (h/h3 "Transitions with neon-animation")
         (iron/demo-snippet
          (h/template
           (paper/button :!raised {:onclick "animated.open()"} "open")
           (paper/dialog :#animated!with-backdrop {:entry-animation "scale-up-animation"
                                                   :exit-animation "fade-out-animation"}
                         (h/h2 "Dialog Title")
                         (h/p "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
          irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."))))))
