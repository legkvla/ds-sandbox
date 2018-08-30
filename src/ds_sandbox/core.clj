(ns ds-sandbox.core
  (:use clojure.tools.trace)
  )

(def data [[0 1] [1 0] [1 1] [0 0] [1 0] [0 1] [0 1] [0 1]])

(defn txor [tuple]
  (-> (first tuple)
    (+ (second tuple))
    (= 1)
    )
  )

(defn calc []
  (->> (partition-by txor data)
    (filter #(-> % first txor))
    (map #(count %))
    )
  )

  (defn calc2 []
    (map #(count %)
      (filter
        #(-> % first txor)
        (partition-by txor data)
        )
      )
    )
