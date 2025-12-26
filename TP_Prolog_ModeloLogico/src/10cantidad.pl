cantidad([], 0).
cantidad([_|T], N) :-
    cantidad(T, N1),
    N is N1 +1.

