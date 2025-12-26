concat([], L, L).
concat([H|T], L, [H|R]) :-
    concat(T,L,R).

rotada(L, 0, L).
rotada([H|T], N, R) :-
    N > 0,
    N1 is N-1,
    concat(T, [H], L1),
    rotada(L1, N1, R).

