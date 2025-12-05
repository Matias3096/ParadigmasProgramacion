package org.primeraParte.asignaturas;

/*
excepcion personalizada que se lanza cuando se intenta inscribir a un estudiante
que ya tiene 3 o mas incripciones
 */

public class ErrorInscripcion extends Exception {
    public ErrorInscripcion (String mensaje){
        super(mensaje);
    }

}
