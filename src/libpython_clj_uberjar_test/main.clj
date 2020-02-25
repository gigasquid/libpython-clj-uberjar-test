(ns libpython-clj-uberjar-test.main
  (:gen-class :main true))

;;This is the main entry point for the demo.
;;It's a good example of a shim-class, and
;;requires some arcane features to get things
;;working.
(defn -main [& args]
  ;;clojure.set isn't imported by default, causing errors when
  ;;aot-compiling in some places.  May not be necessary here tho,
  ;;left in just in case.
  (require 'clojure.set)
  (binding [*ns* *ns*]
    ;;rather than :require it in the ns-decl, we load it
    ;;at runtime.
    (require 'libpython-clj-uberjar-test.core)
    (in-ns 'libpython-clj-uberjar-test.core)
    ;;if we don't use resolve, then we get compile-time aot
    ;;dependency on marathon.core.  This allows us to shim the
    ;;class.
    ((resolve 'libpython-clj-uberjar-test.core/-main))))
