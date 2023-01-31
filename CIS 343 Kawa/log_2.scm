(define (log_2 x)
    (if (= x 1)
        0
        (+ 1 (log_2 (truncate-quotient x 2)))
    )
)

(display (format "Log_2 of ~a is ~a\n" 83 (log_2 83)))