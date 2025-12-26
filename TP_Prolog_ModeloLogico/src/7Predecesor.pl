predecesor([H|T], [H,R]) :-
    predecesor_aux(H, T, R).

predecesor_aux(_, [], []).
predecesor_aux(Prev, [H|T], [H|R]) :-
    H >= Prev,
    predecesor_aux(H, T, R).
predecesor_aux(Prev, [H|T], R) :-
    H < Prev,
    predecesor_aux(H, T, R).


