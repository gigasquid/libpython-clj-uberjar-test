(ns libpython-clj-uberjar-test.core
  (:require [libpython-clj.require :refer [require-python]]))

(require-python '[numpy :as numpy])

(defn -main
  [& args]
  (println "Hi")
  (println (numpy/linspace 0 2 50))
  (System/exit 0))
