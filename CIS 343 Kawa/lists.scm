(define (length list)
    (if (null? list)
        0
        (+ 1 (legth ( cdr list)))
    )
)

(display (length '()))
(newline)

(define (count_of lst item)
    (if (null? lst)
        0
        (+ (if (eq? (car lst) item) 1 0) (count_of (cdr lst) item))
    )
)

(define (insert_at lst item x)
    (if (= x 0)
        (cons item lst)
        (cons (car lst) (insert_at (cdr lst) item (- x 1)))
    )
)


(define (reverse lst)
    (if (null? lst)
        lst
        (append (reverse (cdr lst)) (car lst))
    )
)


(define (reverse2 lst)
    )