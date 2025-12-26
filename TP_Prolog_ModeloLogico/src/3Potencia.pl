potencia(_,0,1).
potencia(B,E,V):-
    E>0,
    E1 is E-1,
    potencia(B,E1,V1),
    V is B*V1.

