(ns test-pagespace
  (:require [miraj.co-dom :as x]
            [miraj.core :as miraj]
            [miraj.compiler :as wc]
            [miraj.html :as h]
            [miraj.polymer.iron :as iron :refer [icons]]
            [miraj.polymer.iron.icons :as icons :refer [communication maps notification places social]]
            [miraj.polymer.paper :as paper]
            [miraj.polymer.paper.styles :as pstyles :refer [color]]
            ;; :verbose
            :reload))

;(remove-ns 'test-pagespace)

(miraj/defpage index
  "Hello webpage using style modules."
  {:title "Miraj Test Webpage"
   :description "This page demonstrates usage of Paper elements and styles."}

  ;; (:import :uri [[bower_components.iron-icons communication-icons]])
;           :modules :custom)

  (:css :custom "h1 {background-color: var(--paper-teal-600);}
span {background-color: var(--paper-teal-100);}")
  (:css :custom "paper-badge {color: blue;
    --paper-badge-background: var(--paper-light-blue-300);
  }
")

  (:body
   (h/h1 "Hello, Miraj!")

   (pstyles/color)

   (h/div {:style "background-color:#FFCCBC;"}
    (h/span (paper/icon-button {:id "number" :icon "communication:email" :alt "inbox"}))
    (h/span {:id "foo"} "i am a badged span."
            (paper/badge {:for "foo" :label "4"})))

   (h/div
    (h/p "here's a para, followed by a spinner")
    (paper/spinner {:active nil}))

   (h/div
    (h/h3 "Here are some icons:")
    (h/div
     (icons/social)
     (paper/icon-button {:id "ac-button" :icon "places:ac-unit" :alt "ac"})
     (paper/icon-button {:id "train-button" :icon "maps:train" :alt "train"})
     (paper/icon-button {:id "notif-button" :icon "notification:phone-missed" :alt "phone missed"})
     (paper/icon-button {:id "group-button" :icon "social:group" :alt "grooup"})))

   (h/div
   (paper/card {:heading "Paper component testing."}
               (h/div {:class "card-content"} "This is a paper-card")
               (h/div {:class "card-actions"}
                      (paper/button ::.green {:raised nil} "I am a paper-button"))))))

(binding [*compile-path* "target"]
  (miraj.compiler/compile-webpage-var  (var test-pagespace/index) true true))

(do
  (require '[miraj.co-dom :as x]
           '[miraj.compiler :as wc]
           '[miraj.core :as miraj] :reload)

  (->> (var index)
       miraj/normalize
       miraj/optimize
       (x/pprint :html)))

(-> pstyles/color var meta :miraj/miraj)


