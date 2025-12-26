insertarEn(E, L, 1, [E|L]).
insertarEn(E, [H|T], P, [H|R]) :-
    P > 1,
    P1 is P - 1,
    insertarEn(E, T, P1, R).

