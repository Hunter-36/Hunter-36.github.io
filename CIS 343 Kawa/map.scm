












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
(newline)

(display (my-select '(1 4 5 -9 -8 -5 3 4 3 -1)))
(newline)

(display (my-select2 (lambda (x) (< x 0)) '(1 34 -3 -2 -4 4 5 -3 -2 -1 10 8)))
(newline)

;(display (my-select2 (lambda (x) (< (str-length x) 4)) '(1 34 -3 -2 -4 4 5 -3 -2 -1 10 8)))
;(newline)

(display 
    (map (lambda (x)
        (cond ((> x 100) 100)
            ((< x 0) 0)
            (else x)
        ))
    '(2 3 104 99 106 -8 1 4)
    )
)


(display (bound high low lst)
    (map (lambda (x)
        (cond ((> x high) high)
            ((< x low) low)
            (else x)
        ))
    lst
    )
)
(newline)

; sum = 0
; for (int i = 0; i < array.length; i++) {
;    if (array[i] > max) {
;       sum += array[i]
;    }
; }

; for (int i = 0; i < array.length; i++) {
;    if (array[i] > max) {
;       max = array[i]
;    }
; }

(require 'list-lib)
(display
    (fold (lambda (item partial) (+ item partial) 0 '(1 2 3 4 5 6)))
)
(newline)

