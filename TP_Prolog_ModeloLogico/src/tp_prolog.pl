% -*- mode: prolog -*-
% src/tp_prolog.pl
% Codigo principal del TP - predicados a implementar
%
%


:-  module(tp_prolog, [
               par/1,
               suma_pares/2,
               potencia/3
]).

/* Predicado: par/1
 *  par(N) es cierto si N es un entero par >=0
 *  implementacion recursiva (sin usar mod).
 */

par(0).
par(N) :-
    integer(N),
    N > 0,
    N2 is N - 2,
    par(N2).

/*
 * Predicado: suma_pares/2
 * suma_pares(N, S) suma todos los numeros pares desde 0 hasta N(incluido si es par=)
 * Ej: suma_pares(4, S). -> S = 6 (0 + 2 + 4)
 */

suma_pares(N, S) :-
    integer(N),
    N >= 0,
    suma_pares_acc(N, 0, S).

% acumulador
 suma_pares_acc(0, Acc, Acc).
 suma_pares_acc(N, Acc, S) :-
    N > 0,
    (    0 is N mod 2 -> Acc2 is Acc + N; Acc2 is Acc),
    N1 is N - 1,
    suma_pares_acc(N1, Acc2, S).

/*
 * predicado: potencia/3
 *potencia(Base, Expo, Res) calcula Base^Expo (expo >= 0)
 */
potencia(_, 0, 1).
potencia(B, E, R) :-
    E > 0,
    E1 is E - 1,
    potencia(B, E1, R1),
    R is B * R1.
