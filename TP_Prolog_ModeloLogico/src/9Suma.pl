suma(0, []).
suma(S, [H|T]) :-
    suma(S1, T),
    S is H + S1.
