par(0).
par(N) :-
    N > 0,
    N2 is N-2,
    par(N2).
