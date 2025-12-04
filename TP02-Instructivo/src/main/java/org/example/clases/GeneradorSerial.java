package org.example.clases;

import java.util.Random;

/*
Generador de numeros de serie para baterias.
Justificacion:
    Los numeros de serie los genera el sistema/fabrica
 */
public class GeneradorSerial {
    private static final Random rnd = new Random();

    public static String generarSerial() {
        return "SR-" + (100000 + rnd.nextInt(90000));
    }
}
