(define (f_to_c f) (* (/ 5 9) (- f 32)))
(display (f_to_c 75))
(display "\n")

(define (quadratic x1 y1 x2 y2)
    (let (
        (subX (- x1 x2))
        (subY (- y1 y2))
    )
    (sqrt (+ (* subX subX) (* subY subY)))
    )
)
(display (quadratic 5 10 15 20))
(display "\n")