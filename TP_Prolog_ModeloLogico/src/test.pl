%src/tests.pl
:- begin_tests(tp_basicos).

:- use_module(tp_prolog).

test(par_positivos) :-
    par(0),
    par(2),
    par(10),
    \+par(3).

test(suma_pares) :-
    suma_pares(0, 0),
    suma_pares(1, 0),
    suma_pares(2, 2),
    suma_pares(4, 6).

test(potencia) :-
    potencia(2,0,1),
    potencia(2,3,8),
    potencia(5,2,25).

:- end_tests(tp_basicos).
