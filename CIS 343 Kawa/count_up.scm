(define (count-up x y)
    (display (format "~a\n" x))
    (if (= x y)
        (newline)
        (count-up (+ x 1) y)
    )
)

(count-up 10 20)