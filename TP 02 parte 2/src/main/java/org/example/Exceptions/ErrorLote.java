package org.example.Exceptions;

/*
Excepcion propia que se lanza cuando se intenta asignar mas de un edificio al lote
 */
public class ErrorLote extends Exception {
    public ErrorLote(String mensaje) {
        super(mensaje);
    }
}
