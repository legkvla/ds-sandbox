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
  (->> data
    (map #(conj %2 %1) (range))
    (partition-by txor)
    (filter #(-> % first txor))
    (map (fn [t] [(-> t first (get 2)) (count t)]))
    )
  )
