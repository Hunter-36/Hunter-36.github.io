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



(define (quadrant x y)
    (if (>= y 0)
        (if (>= x 0) "Quadrant I" "Quadrant II")
        (if (>= x 0) "Quadrant III" "Quadrant IV")
    )
)

(display (quadrant 5 4))
(newline)


(define (quadrant x y)
    (cond
    ((and (>= y 0) (>= x 0)) "Quadrant I")
    ((and (>= y 0) (< x 0)) "Quadrant II")
    ((and (< y 0) (< x 0)) "Quadrant III")
    ((and (< y 0) (>= x 0)) "Quadrant IV")
    )
)


(define (log_2 x)
    (if (= x 1)
        0
        (+ 1 (log_2 (truncate-quotient x 2)))
    )
)

(display (format "Log_2 of ~a is ~a\n" 83.7 (log_2 83.7)))


(define (count-up x y)
    (display (format "~a\n" x))
    (if (= x y)
        (newline)
        (count-up (+ x 1) y)
    )
)

(count-up 10 20)


(define (draw_row)
    (display "*")
    (if (= w 1)
        (newline)
        (draw_row (- w 1))
    )
)

(define (rectangle w h)
    (draw_row w)
    (if (= height)
    ()
    (rectangle w (- height 1))
    )
)

(rectangle 10 5)