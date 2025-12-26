ordenada([], []).
ordenada([H|T], O) :-
    ordenada(T, O1),
    insOrden(H, O1, O).

