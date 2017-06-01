(ns my-castra.rpc
  (:require-macros
    [javelin.core :refer [defc defc=]])
  (:require
   [javelin.core]
   [castra.core :refer [mkremote]]))

(defc state nil)
(defc error nil)
(defc loading [])

(defc= random-number  (get state :random))
(defc= session-number (get state :session))
(defc= dstring        (get state :dstring))
(defc text-input "")

(defc= timewords-input  (get state :timewords-input))
(defc= timewords-output (get state :timewords-output))

(def get-state
  (mkremote 'my-castra.api/get-state state error loading))

(def get-dstring
  (mkremote 'my-castra.api/get-dstring state error loading))

(def parse-timewords
  (mkremote 'my-castra.api/parse-timewords state error loading))
