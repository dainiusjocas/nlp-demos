(ns my-castra.api
  (:require [castra.core :refer [defrpc *session*]]
            [timewords.core :refer [parse]]
            [metadata-detector.core :refer [detect]])
  (:import (lt.tokenmill.metadatadetector MetadataDetector DocumentMetadata)))

(defrpc get-state []
  (swap! *session* update-in [:id] #(or % (rand-int 100)))
  {:random (rand-int 100) :session (:id @*session*)})


(defrpc get-dstring []
  {:dstring (str "dstring" (rand-int 10))})

(defrpc parse-timewords [timeword]
  (prn ">>>>>>>OOOOOOOOOOOOOOOOOOOOOOOOOOOO")
  (prn timeword)
  {:timewords-output (parse timeword)})

(defrpc detect-metadata []
  (prn "AAA>>>>>>><<<<<<<<")
  (let [metadataDetector (MetadataDetector.)
        html (slurp "http://www.finsmes.com/2017/06/max-raises-e20m-in-funding.html")
        md (.detect metadataDetector "url" html)]
    (println (.getTitle md) (.getPublishDate md))
    {:metadata-output {:title (.getTitle md)
                       :published (.getPublishDate md)}}))
