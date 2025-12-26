sintoma(juan, fiebre).
sintoma(juan, tos).
sintoma(ana, dolorCabeza).

enfermedad(gripe, fiebre).
enfermedad(gripe, tos).
enfermedad(migraña, dolorCabeza).

diagnistico(P, S, E) :-
    sintoma(P, S),
    enfermedad(E, S).
