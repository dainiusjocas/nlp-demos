(ns my-castra.api
  (:require [castra.core :refer [defrpc *session*]]
            [timewords.core :refer [parse]]))

(defrpc get-state []
  (swap! *session* update-in [:id] #(or % (rand-int 100)))
  {:random (rand-int 100) :session (:id @*session*)})


(defrpc get-dstring []
  {:dstring (str "dstring" (rand-int 10))})

(defrpc parse-timewords [timeword]
  (prn ">>>>>>>" *session*)
  (prn timeword)
  {:timewords-output (parse timeword)})
