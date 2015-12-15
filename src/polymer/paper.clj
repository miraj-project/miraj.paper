(ns polymer.paper
;;  (:refer-clojure :exclude [map meta time])
  (:require [miraj.markup :refer [make-resource-fns]]))

(alter-meta! *ns* (fn [m] (assoc m :co-ns true)))

   ;; 'behaviors		:behaviors 	"paper-behaviors/paper-behaviors"
   ;; [polymer.paper.behaviors :refer :all]
   ;; [polymer.paper.behavior :refer [button checked-element inky-focus ripple]]

;; [polymer.paper :refer [input textarea]]

;; paper-dialog-common.css
;; paper-dialog-shared-styles.html

;; [polymer.paper :as paper :refer :all] => 'elements :elements "paper-elements/paper-elements"

;; [polymer.paper.item    :as item    :refer [behavior body shared-styles icon]]
;; [polymer.paper.menu    :as menu    :refer [button button-animations shared-styles submenu]]
;; [polymer.paper.spinner :as spinner :refer [behavior lite styles]]
;; [polymer.paper.styles  :as styles  :refer :all]
;; [polymer.paper.styles  :as styles  :refer [color default-theme demo-pages shadow typography]]

;; paper-tabs-icons.html - iron-iconset-svg

(def polymer-paper-tags
  ; fn-tag,  elt-tag,  elt-uri
  [['badge		:paper-badge	 	"paper-badge/paper-badge.html"
    "<paper-badge> docstring"]
   ['button		:paper-button		"paper-button/paper-button.html"
    "<paper-button> docstring"]
   ['card		:paper-card		"paper-card/paper-card.html"
	"paper-card/paper-card.html docstring"]
   ['checkbox		:paper-checkbox		"paper-checkbox/paper-checkbox.html"
	"paper-checkbox/paper-checkbox.html docstring"]
   ['dialog		:paper-dialog		"paper-dialog/paper-dialog.html"
	"paper-dialog/paper-dialog.html docstring"]
   ['dialog-behavior	:paper-dialog-behavior	"paper-dialog-behavior/paper-dialog-behavior.html"
	"paper-dialog-behavior/paper-dialog-behavior.html docstring"]
   ['dialog-scrollable	:paper-dialog-scrollable "paper-dialog-scrollable/paper-dialog-scrollable.html"
	"paper-dialog-scrollable/paper-dialog-scrollable.html docstring"]
   ['drawer-panel	:paper-drawer-panel	"paper-drawer-panel/paper-drawer-panel.html"
	"paper-drawer-panel/paper-drawer-panel.html docstring"]
   ['dropdown-menu	:paper-dropdown-menu	"paper-dropdown-menu/paper-dropdown-menu.html"
	"paper-dropdown-menu/paper-dropdown-menu.html docstring"]
   ['fab		:paper-fab		"paper-fab/paper-fab.html"
	"paper-fab/paper-fab.html docstring"]
   ['header-panel	:paper-header-panel	"paper-header-panel/paper-header-panel.html"
	"paper-header-panel/paper-header-panel.html docstring"]
   ['icon-button	:paper-icon-button	"paper-icon-button/paper-icon-button.html"
	"paper-icon-button/paper-icon-button.html docstring"]
   ['input		:paper-input		"paper-input/paper-input.html"
	"paper-input/paper-input.html docstring"]
   ['textarea		:paper-textarea		"paper-input/paper-textarea.html"
	"paper-input/paper-textarea.html docstring"]
   ['item		:paper-item		"paper-item/paper-item.html"
	"paper-item/paper-item.html docstring"]
   ['listbox		:paper-listbox		"paper-listbox/paper-listbox.html"
	"paper-listbox/paper-listbox.html docstring"]
   ['material		:paper-material		"paper-material/paper-material.html"
	"paper-material/paper-material.html docstring"]
   ['menu		:paper-menu		"paper-menu/paper-menu.html"
	"paper-menu/paper-menu.html docstring"]
   ['menu-shared-styles	:paper-menu-shared-styles "paper-menu/paper-menu-shared-styles.html.html"
	"paper-menu/paper-menu-shared-styles.html.html docstring"]
   ['submenu		:paper-submenu		"paper-menu/paper-submenu.html"
	"paper-menu/paper-submenu.html docstring"]
   ['menu-button	:paper-menu-button	"paper-menu-button/paper-menu-button.html"
	"paper-menu-button/paper-menu-button.html docstring"]
   ['menu-button-animations :paper-menu-button-animations "paper-menu-button/paper-menu-button-animations.html"
	"paper-menu-button/paper-menu-button-animations.html docstring"]
   ['progress		:paper-progress		"paper-progress/paper-progress.html"
	"paper-progress/paper-progress.html docstring"]
   ['radio-button	:paper-radio-button	"paper-radio-button/paper-radio-button.html"
	"paper-radio-button/paper-radio-button.html docstring"]
   ['radio-group	:paper-radio-group	"paper-radio-group/paper-radio-group.html"
	"paper-radio-group/paper-radio-group.html docstring"]
   ['ripple		:paper-ripple		"paper-ripple/paper-ripple.html"
	"paper-ripple/paper-ripple.html docstring"]
   ['scroll-header-panel :paper-scroll-header-panel "paper-scroll-header-panel/paper-scroll-header-panel.html"
	"paper-scroll-header-panel/paper-scroll-header-panel.html docstring"]
   ['slider		:paper-slider		"paper-slider/paper-slider.html"
	"paper-slider/paper-slider.html docstring"]
   ['spinner		:paper-spinner		"paper-spinner/paper-spinner.html"
	"paper-spinner/paper-spinner.html docstring"]

   ['tab		:paper-tab		"paper-tabs/paper-tab.html"
	"paper-tabs/paper-tab.html docstring"]
   ['tabs		:paper-tabs		"paper-tabs/paper-tabs.html"
	"paper-tabs/paper-tabs.html docstring"]
   ['toast		:paper-toast		"paper-toast/paper-toast.html"
	"paper-toast/paper-toast.html docstring"]
   ['toggle-button	:paper-toggle-button	"paper-toggle-button/paper-toggle-button.html"
	"paper-toggle-button/paper-toggle-button.html docstring"]
   ['toolbar		:paper-toolbar		"paper-toolbar/paper-toolbar.html"
	"paper-toolbar/paper-toolbar.html docstring"]
   ['tooltip		:paper-tooltip		"paper-tooltip/paper-tooltip"
    "paper-tooltip/paper-tooltip"]])

(make-resource-fns :html polymer-paper-tags)
