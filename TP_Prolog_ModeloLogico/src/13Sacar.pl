sacar(1, [_|T], T).
sacar(P, [H|T], [H|R]):-
    P>1,
    P1 is P - 1,
    sacar(P1, T, R).

