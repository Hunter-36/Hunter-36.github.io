(define (quadrant x y)
    (if (>= y 0)
        (if (>= x 0) "Quadrant I" "Quadrant II")
        (if (>= x 0) "Quadrant III" "Quadrant IV")
    )
)

(display (quadrant 5 4))
(newline)


(define (quadrant_v2 x y)
    (cond
    ((and (>= y 0) (>= x 0)) "Quadrant I")
    ((and (>= y 0) (< x 0)) "Quadrant II")
    ((and (< y 0) (< x 0)) "Quadrant III")
    ((and (< y 0) (>= x 0)) "Quadrant IV")
    )
)

(display (quadrant -3 7))
(newline)