package org.example.clases;

public class GestorIds {

    private static int ultimoId = 0;

    public static int generarNuevoId() {
        return ++ultimoId;
    }

    //Para reiniciar si es necesario
    public static void reiniciarContador() {
        ultimoId = 0;
    }
}
