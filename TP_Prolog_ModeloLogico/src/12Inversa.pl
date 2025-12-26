inversa([], []).
inversa([H|T], R) :-
    inversa(T, RT),
    concat(RT, [H], R).
