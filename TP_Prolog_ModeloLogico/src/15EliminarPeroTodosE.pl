eliminar([], _, []).
eliminar([E|T], E, R) :-
    eliminar(T, E, R).
eliminar([H|T], E, [H|R]) :-
    H \= E,
    eliminar(T, E, R).

