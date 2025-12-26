insOrden(E, [], [E]).
insOrden(E, [H|T], [E,H|T]) :-
    E =< H.
insOrden(E, [H|T], [H|R]) :-
    E > H,
    insOrden(E, T, R).

