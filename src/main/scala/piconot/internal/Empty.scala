package piconot.internal

object EmptyBot extends Picotext("resources/empty.txt") {
    0 empty n next(n, 0)
    0 wall n next(x, 1)

    1 empty w next(w, 1)
    1 wall w next(x, 2)

    // Fill to South East corner

    2 empty s next(s, 2)
    2 empty e next(e, 3)

    3 empty n next(n, 3)
    3 wall n next(x, 2)

    run
}