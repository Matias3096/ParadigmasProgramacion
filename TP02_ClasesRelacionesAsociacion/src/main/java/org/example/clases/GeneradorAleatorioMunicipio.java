package org.example.clases;

import java.util.Random;

public class GeneradorAleatorioMunicipio {

    private static final Random rnd = new Random();

    private static final String[] MUNICIPIOS = {
            "Junín", "Rivadavia", "San Martín", "Godoy Cruz", "Guaymallén",
            "Maipú", "Luján de Cuyo", "San Rafael", "Tunuyán", "Las Heras",
            "Malargüe", "La Paz", "Santa Rosa"
    };

    public static String nextMunicipio() {
        return MUNICIPIOS[rnd.nextInt(MUNICIPIOS.length)];
    }
}
