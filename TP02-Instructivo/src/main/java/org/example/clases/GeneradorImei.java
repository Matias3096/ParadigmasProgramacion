package org.example.clases;

import java.util.Random;

public class GeneradorImei {
    private static final Random rnd = new Random();

    private GeneradorImei() {}

    public static String generarIMEI() {
        StringBuilder sb = new StringBuilder(15);
        for (int i = 0; i < 15; i++) {
            sb.append(rnd.nextInt(10));
        }
        return sb.toString();
    }
}
