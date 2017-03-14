(def +project+ 'miraj.polymer/paper)
(def +version+ "1.2.3-SNAPSHOT")

(set-env!
 ;; :asset-paths #{"resources"}
 :resource-paths #{"dev-resources" "demos/clj"}
 :source-paths #{"edn"}

 :checkouts '[[miraj/core "0.1.0-SNAPSHOT"]
              [miraj/co-dom "0.1.0-SNAPSHOT"]
              [miraj/boot-miraj "0.1.0-SNAPSHOT"]]

 :dependencies   '[[org.clojure/clojure RELEASE :scope "provided"]

                   ;; for demos and testing
                   [org.clojure/clojurescript "1.9.473"]
                   [hipo "0.5.2"]
                   [adzerk/boot-cljs "2.0.0-OUTPUTFIX" :scope "test"]
                   [adzerk/boot-cljs-repl   "0.3.3"] ;; latest release
                   [adzerk/boot-reload "0.5.1" :scope "test"] ;; cljs
                   [samestep/boot-refresh "0.1.0" :scope "test"] ;; clj reloading
                   [com.cemerick/piggieback "0.2.1"  :scope "test"]
                   [weasel                  "0.7.0"  :scope "test"]
                   [org.clojure/tools.nrepl "0.2.12" :scope "test"]

                   [miraj/co-dom "0.1.0-SNAPSHOT" :scope "test"]
                   [miraj/core "0.1.0-SNAPSHOT"]
                   [miraj.polymer/iron "1.2.3-SNAPSHOT"]
                   [pandeiro/boot-http "0.7.3" :scope "test"]

                   [boot/boot "RELEASE" :scope "test"]
                   [miraj/boot-miraj "0.1.0-SNAPSHOT" :scope "test"]
                   [adzerk/boot-test "1.0.7" :scope "test"]
                   ])

(require '[miraj.boot-miraj :as miraj]
         '[adzerk.boot-cljs      :refer [cljs]]
         '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
         '[adzerk.boot-reload :refer [reload]]
         '[adzerk.boot-test :refer [test]]
         '[samestep.boot-refresh :refer [refresh]]
         '[pandeiro.boot-http :as http :refer :all]
         '[boot.task.built-in :as boot :refer :all])

(task-options!
 boot/aot {:namespace #{'miraj.NSException}}
 ;; miraj/compile {:components true :verbose true}
 boot/repl {:port 8080}
 boot/pom  {:project     +project+
            :version     +version+
            :description "Miraj Polymer Paper element functions"
            :url "https://github.com/mobileink/miraj-project/paper"
            :scm         {:url "https://github.com/miraj-project/miraj.core.git"}
            :license     {"EPL" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build
  "build a component library"
  []
  (comp ;;(miraj/compile :library true :verbose true)
   (miraj/compile :libraries true :debug true :keep true)
   (miraj/compile :styles    true :debug true :keep true)
   #_(boot/target)))

(deftask demos
  "build component demos"
  []
;;  (set-env! :source-paths #(conj % "demos/clj"))
  (comp
   ;;(build)
   (miraj/compile :pages true :debug true :keep true)
   (miraj/link    :pages true :debug true) ;; :keep true)
   (miraj/demo-page :debug true)
   ;; (cljs)
   ;; (boot/sift :to-resource #{#".*\.cljs\.edn"}) ;; keep main.cljs.edn, produced by (cljs)
   #_(boot/target   :no-clean   true)))

;; plain repl won't do, the target dir will not be on the classpath
(deftask dev
  "repl"
  []
  (set-env! :asset-paths #(conj % "dev-resources"))
  (comp (miraj/compile :libraries true :debug true)
        (miraj/compile :style true :verbose true)
        (target)
        (boot/repl)))

(deftask install-local
  "Build and install component libraries"
  []
  (comp (build)
        (target)
        (boot/pom)
        (boot/jar)
        (boot/target :no-clean true)
        (boot/install)))

(deftask monitor
  "monitor the source only, not test"
  []
  (set-env! :asset-paths #(conj % "dev-resources"))
  (comp (boot/watch)
        (boot/notify :audible true)
        (demos)))

        ;; (boot/pom)
        ;; (boot/jar)
        ;; (boot/install)))

;; (deftask dev
;;   "watch etc."
;;   []
;;   (set-env! :source-paths #(conj % "src/test/clj"))
;;   (comp (serve)
;;         (watch)
;;         (notify :audible true)
;;         ;; (refresh)
;;         (miraj/compile :libraries true :debug true)
;;         (miraj/compile :pages true :debug true :keep true)
;;         (target)))

(deftask run-demos
  "compile, link, serve demos"
  []
  (comp
   (build)
   (serve) ;; :dir "target") we can't use target since required components are on cp, not in target
   (watch) ;; :verbose true)
   ;; (cljs-repl)
   (notify :audible true)
   ;; (reload) ;; this is not for dev
   (demos)
   ;;(refresh)
   ;; (miraj.boot-miraj/compile :keep true :debug true :pages true)
   ;; (miraj.boot-miraj/link    :debug true :pages true)
   ;; (target) ;; :no-clean true)
   ;; (cljs)
   ;; (target :no-clean true)
   #_(wait)))
