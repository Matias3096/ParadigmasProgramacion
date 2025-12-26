rotarIzq(L, 0, L).
rotarIzq([H|T], N, R) :-
    N > 0,
    N1 is N - 1,
    append(T, [H], L1),
    rotarIzq(L1, N1, R).

