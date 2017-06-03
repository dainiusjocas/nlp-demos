(ns my-castra.header
  (:require [hoplon.core :as hl]))

(enable-console-print!)

(defn header []
  (hl/ul
    (hl/li (hl/a :href "/index.html" "Home"))
    (hl/li (hl/a :href "/timewords.html" "Timewords"))
    (hl/li (hl/a :href "/metadata.html" "Metadata"))))
