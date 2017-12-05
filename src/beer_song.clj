(ns beer-song
  (:require [clojure.string :as str]))

(defn verse [number-remaining]
  (cond
    (> number-remaining 2) (str number-remaining " bottles of beer on the wall, "
                                number-remaining " bottles of beer.\n"
                                "Take one down and pass it around, "
                                (- number-remaining 1) " bottles of beer on the wall.\n")
    (= number-remaining 2) (str number-remaining " bottles of beer on the wall, "
                                number-remaining " bottles of beer.\n"
                                "Take one down and pass it around, "
                                (- number-remaining 1) " bottle of beer on the wall.\n")
    (= number-remaining 1) (str number-remaining " bottle of beer on the wall, "
                                number-remaining " bottle of beer.\n"
                                "Take it down and pass it around, "
                                "no more bottles of beer on the wall.\n")
    (= number-remaining 0) (str "No more bottles of beer on the wall, no more bottles of beer.\n"
                                "Go to the store and buy some more, 99 bottles of beer on the wall.\n")))
(defn sing
  ([start] (sing start 0))
  ([start stop]
   (->>
     (range start (dec stop) -1)
     (map verse)
     (str/join "\n"))))
