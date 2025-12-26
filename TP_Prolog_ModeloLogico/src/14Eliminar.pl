eliminar([E|T], E, T).
eliminar([H|T], E, [H|R]) :-
    H \= E,
    eliminar(T, E, R).

