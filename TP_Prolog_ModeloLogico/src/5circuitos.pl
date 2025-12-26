and(0, 0, 0).
and(0, 1, 0).
and(1, 0, 0).
and(1, 1, 1).

or(0, 0, 0).
or(0, 1, 1).
or(1, 0, 1).
or(1, 1, 1).

not(0, 1).
not(1, 0).

circuito(Q1, Q2, S):-
    and(Q1, Q2, X),
    not(X, S).

