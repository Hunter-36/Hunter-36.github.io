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