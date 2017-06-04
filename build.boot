(def +project+ 'miraj.polymer/paper)
(def +version+ "1.2.3-SNAPSHOT")

(set-env!
 :resource-paths #{"src/main/clj"} ;; "dev-resources" "demos/clj"}
 :source-paths #{"edn"}

 ;; :checkouts '[[miraj/core "1.0.0-SNAPSHOT"]
 ;;              [miraj/co-dom "1.0.0-SNAPSHOT"]
 ;;              ;;[miraj/boot-miraj "0.1.0-SNAPSHOT"]
 ;;              ]

 :repositories #(conj % ["clojars" {:url "https://clojars.org/repo/"}])

 :dependencies   '[[org.clojure/clojure "1.9.0-alpha17"]
                   [miraj/co-dom "1.0.0-SNAPSHOT"]
                   [miraj.polymer/assets "1.8.1-SNAPSHOT"]

                   ;; ;; for demos and testing
                   ;; [miraj/core "1.0.0-SNAPSHOT"            :scope "test"]
                   ;; [miraj/html "5.1.0-SNAPSHOT"            :scope "test"]
                   ;; [org.clojure/clojurescript "1.9.473" :scope "test"]
                   ;; [hipo "0.5.2"                        :scope "test"]
                   ;; [adzerk/boot-cljs "2.0.0-OUTPUTFIX"  :scope "test"]
                   ;; [adzerk/boot-cljs-repl   "0.3.3"     :scope "test"] ;; latest release
                   ;; [adzerk/boot-reload "0.5.1"          :scope "test"] ;; cljs
                   [samestep/boot-refresh "0.1.0"          :scope "test"] ;; clj reloading
                   ;; [com.cemerick/piggieback "0.2.1"     :scope "test"]
                   ;; [weasel                  "0.7.0"     :scope "test"]
                   ;; ;; [org.clojure/tools.nrepl "0.2.12" :scope "test"]

                   ;; [miraj.polymer/iron "1.2.3-SNAPSHOT"    :scope "test"]

                   [pandeiro/boot-http "0.7.3"             :scope "test"]
                   [miraj/boot-miraj "0.1.0-SNAPSHOT"      :scope "test"]
                   [adzerk/boot-test "1.0.7"               :scope "test"]

                   [org.clojure/tools.namespace "0.2.11"   :scope "test"]

                   ;; [boot/boot "RELEASE" :scope "test"]
                   ])

(require '[miraj.boot-miraj :as mrj]
         '[clojure.tools.namespace.repl :refer [disable-reload!]]
         ;; '[adzerk.boot-cljs      :refer [cljs]]
         ;; '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
         ;; '[adzerk.boot-reload :refer [reload]]
         ;; '[adzerk.boot-test :refer [test]]
         '[samestep.boot-refresh :refer [refresh]]
         '[pandeiro.boot-http :as http :refer :all]
         ;; '[boot.task.built-in :as boot :refer :all]
         )

(task-options!
 repl {:port 8080}
 pom  {:project     +project+
       :version     +version+
       :description "Miraj Polymer Paper element functions"
       :url         "https://github.com/miraj-project/polymer-paper"
       :scm         {:url "https://github.com/miraj-project/polymer-paper.git"}
       :license     {"EPL" "http://www.eclipse.org/legal/epl-v10.html"}}
 push {:repo "clojars"})

(deftask build
  "build a component library"
  []
  (comp
   (mrj/compile :libraries true :debug true :keep true)
   (mrj/compile :styles    true :debug true :keep true)))

(deftask demos
  "build component demos"
  []
  (set-env! :asset-paths #(conj % "dev-resources"))
  (set-env! :source-paths #(conj % "demos/clj"))
  (comp
   ;; (mrj/compile :page 'miraj.polymer.paper.demos.button/index
   ;;                :polyfill :lite :debug true :keep true)
   ;; (mrj/compile :page 'miraj.polymer.paper.demos.dialog
   ;;              :polyfill :lite
   ;;              :assets :polymer
   ;;              ;; :polymer ["neon-animation/neon-animations.html"]
   ;;              :imports ["/miraj/polymer/assets/neon-animation/neon-animations.html"
   ;;                        "dialog_style.html"]
   ;;              ;; :extensions [miraj.polymer.neon :as neon :refer [animations]]
   ;;              :keep true
   ;;              :debug true)
   ;; (mrj/compile :page 'miraj.polymer.paper.demos.fab
   ;;              :polyfill :lite
   ;;              :assets :polymer
   ;;              :imports ["fab_style.html"]
   ;;              :keep true
   ;;              :debug true)
   (mrj/compile :page 'miraj.polymer.paper.demos.tabs
                :polyfill :lite
                :assets :polymer
                :imports ["tabs_style.html"]
                :keep true
                :debug true)
   ;; (mrj/compile :pages true
   ;;              :polyfill :lite
   ;;              :keep true
   ;;              :debug true)
   (mrj/link    :pages true :assets :polymer :debug true)
   (mrj/demo-page :debug true)))

(deftask dev
  "repl"
  []
  (set-env! :asset-paths #(conj % "dev-resources"))
  (comp (mrj/compile :libraries true :debug true)
        (mrj/compile :style true :verbose true)
        (target)
        (repl)))

(deftask install-local
  "Build and install component libraries"
  []
  (comp (build)
        (pom)
        (jar)
        (target)
        (install)))

(deftask deploy
  "deploy to clojars"
  []
  (comp (install-local)
        (push)))

(deftask monitor
  "monitor the source only, not test"
  []
  (set-env! :asset-paths #(conj % "dev-resources"))
  (comp (watch)
        (notify :audible true)
        (demos)))

(deftask run-demos
  "compile, link, serve demos"
  []
  ;; (disable-reload! 'boot.user)
  (comp
   (build)
   (serve :dir "target") ;; :resource-root "resources")
   (watch)
   (notify :audible true)
   (refresh)
   (demos)
   (target)))
