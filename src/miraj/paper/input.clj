(ns polymer.paper.input
  (:require [miraj.markup :refer [make-resource-fns]]))

(alter-meta! *ns* (fn [m] (assoc m :co-ns true)))

;; example:
;; [polymer.paper :refer [input textarea]]
;; [polymer.paper.input :refer :all]
;; [polymer.paper.input :refer [addon-behavior behavior char-counter container error]]

(def polymer-paper-input-tags
  ; [fn-tag,  elt-tag,  elt-uri, docstring]
  [['addon-behavior	:paper-input-addon-behavior	"paper-input/paper-input-addon-behavior.html"
    "<paper-input-container> is a container for a <label>, an <input
    is=\"iron-input\"> or <iron-autogrow-textarea> and optional add-on
    elements such as an error message or character counter, used to
    implement Material Design text fields."]
   ['behavior		:paper-input-behavior		"paper-input/paper-input-behavior.html"
    "<paper-input-behavior> docstring"]
   ['char-counter	:paper-input-char-counter	"paper-input/paper-input-char-counter.html"
    "<paper-input-char-counter> docstring"]
   ['container		:paper-input-container		"paper-input/paper-input-container.html"
    "<paper-input-container> docstring"]
   ['error		:paper-input-error		"paper-input/paper-input-error.html"
    "<paper-input-error> docstring"]])

(make-resource-fns :html polymer-paper-input-tags)
