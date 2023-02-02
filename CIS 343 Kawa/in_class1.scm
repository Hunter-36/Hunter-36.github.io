(define (f_to_c f) 
    (* (/ 5 9) (- f 32))
)
(display (f_to_c 75))
(display "\n")

(define (square x)
    (* x x)
)

(define (dist2 x1 y1 x2 y2)
    (sqrt (+ (square (- x2 x1) ) ) (+ (square (- y2 y1) ) ) )
)

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

(if (eq? (mod x 2) 0) "even" "odd")

(cond 
    ((eq? (mod x 3) 0) "multiple of 3")
    ((eq? (mod x 3) 1) "one off")
    (else "two off")
)

(define (commission sales)
    (if (< sales 10000)
        (* sales .1)
        ((* 0.05 (- sales 10000)))
    )
)

(display (format "Commission on 11000 is ~a\n" (commission 11000)))