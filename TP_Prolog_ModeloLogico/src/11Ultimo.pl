ultimo([U], U).
ultimo([_|T], U) :-
    ultimo(T, U).

