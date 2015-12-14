(ns polymer.paper
;;  (:refer-clojure :exclude [map meta time])
  (:require [miraj.markup :refer [make-tag-fns]]))

(println "loading polymer.paper")

(alter-meta! *ns* (fn [m] (assoc m :co-ns true)))

(defonce polymer-paper-tags
  ["badge"
   "behaviors"
   "button"
   "card"
   "checkbox"
   "dialog"
   "dialog-behavior"
   "dialog-scrollable"
   "drawer-panel"
   "dropdown-menu"
   "elements"
   "fab"
   "header-panel"
   "icon-button"
   "input"
   "input-addon-behavior"
   "input-behavior"
   "input-char-counter"
   "input-container"
   "input-error"
   "input"
   "textarea"
   "item"
   "linear-progress"
   "listbox"
   "material"
   "menu"
   "menu-button"
   "progress"
   "radio-button"
   "radio-group"
   "ripple"
   "scroll-header-panel"
   "slider"
   "spinner"
   "styles"
   "tabs"
   "toast"
   "toggle-button"
   "toolbar"
   "tooltip"])

(make-tag-fns "paper-" polymer-paper-tags nil)

