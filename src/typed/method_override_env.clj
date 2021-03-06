(in-ns 'typed.core)

; Should only override a method with a more specific type
; eg. 

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Method Override Env

(defonce METHOD-OVERRIDE-ENV (atom {}))
(set-validator! METHOD-OVERRIDE-ENV (hash-c? (every-pred namespace symbol?)
                                             (some-fn Poly? FnIntersection?)))

(defn add-method-override [sym t]
  (swap! METHOD-OVERRIDE-ENV assoc sym t)
  nil)
