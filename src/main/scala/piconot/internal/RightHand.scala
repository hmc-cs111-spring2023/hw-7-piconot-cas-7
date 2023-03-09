package piconot.internal


object RightBot extends Picotext("resources/maze.txt") {
    // State 0: moving north
    0 empty e next(e, 1)
    0 empty "n wall e" next(n, 0)
    0 wall n_e next(x, 3)

    1 empty s next(s, 3)
    1 empty "e wall s" next(e, 1)
    1 wall e_s next(x, 2)

    2 empty n next(n, 0)
    2 empty "w wall n" next(w, 2)
    2 wall n_w next(x, 1)

    3 empty w next(w, 2)
    3 empty "s wall w" next(s, 3)
    3 wall w_s next(x, 0)

    run
}