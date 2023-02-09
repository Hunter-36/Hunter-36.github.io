












(define names '(("George" "Washington") ("John" "Adams")))

(newline)
(display (map (lambda (pair)
    (format "\"~a, ~a\"" (car (cdr pair)) (car pair)))
))
(newline)


(define (my-select) lst
    (if (null? lst)
        '()
        (if (> (car lst) )
            (cons (car lst) (my-select (cdr lst)))
            (my-select (cdr lst))
        )
    )
)

(display (my-select '(1 4 5 -9 -8 -5 3 4 3 -1)))