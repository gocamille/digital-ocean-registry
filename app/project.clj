(defproject app "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [duct/core "0.8.0"]
                 [duct/module.logging "0.5.0"]
                 [duct/module.web "0.7.3"]
                 [environ "1.2.0"]]
  :plugins [[duct/lein-duct "0.12.3"]
            [lein-environ "1.2.0"]]
  ;;; Jar Output
  ;; Name of the jar file produced. Will be placed inside :target-path.
  ;; Including %s will splice the project version into the filename.
  :jar-name "api-qonvo-%s.jar"
  ;; As above, but for uberjar.
  :uberjar-name "api-qonvo-standalone.jar"
  :main ^:skip-aot app.main
  :resource-paths ["resources" "target/resources"]
  :prep-tasks     ["javac" "compile" ["run" ":duct/compiler"]]
  :middleware     [lein-duct.plugin/middleware]
  :profiles
  {:dev  [:project/dev :profiles/dev]
   :repl {:prep-tasks   ^:replace ["javac" "compile"]
          :repl-options {:init-ns user}}
   :uberjar {:omit-source true
             :env {:production true}
             :aot :all}
   :profiles/dev {}
   :project/dev  {:source-paths   ["dev/src"]
                  :resource-paths ["dev/resources"]
                  :dependencies   [[integrant/repl "0.3.2"]
                                   [hawk "0.2.11"]
                                   [eftest "0.5.9"]
                                   [kerodon "0.9.1"]]}})
