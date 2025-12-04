package org.example.clases;

import java.util.Random;

/**
 * GeneradorAleatorio: Utilidad para crear datos y objetos de forma
 * coherente con el modelo del TP02 (Celular, Bateria).
 *
 * Reglas aplicadas:
 * - No intenta modificar el IMEI del celular: el IMEI se genera
 *   dentro del constructor de Celular (según diseño).
 * - No usa valores por defecto "invisibles": los rangos están explícitos.
 * - Cumple single responsibility: sólo genera datos/objetos.
 */
public final class GeneradorAleatorio {

    private static final Random rnd = new Random();

    private GeneradorAleatorio() {}

    // Modelos realistas para usar en pruebas
    private static final String[] MODELOS = {
            "Samsung A54", "Samsung S22", "Motorola G32",
            "iPhone 12", "Xiaomi Redmi Note 11", "Poco X5", "Huawei P30"
    };

    /**
     * Devuelve un modelo aleatorio.
     */
    public static String nextModelo() {
        return MODELOS[rnd.nextInt(MODELOS.length)];
    }

    /**
     * Cantidad de circuitos de la UnidadModular.
     * Rango razonable y explícito: 5..50
     */
    public static int nextCantidadCircuitos() {
        return rnd.nextInt(46) + 5; // 5..50
    }

    /**
     * Genera una batería con valores realistas.
     * - amperaje: 3000..6000 mAh
     * - voltaje: 3.7 .. 4.5 V (float)
     *
     * Retorna la instancia Bateria lista para insertar (agregación).
     */
    public static Bateria nextBateria() {
        int amperaje = rnd.nextInt(3001) + 3000;             // 3000..6000
        float voltaje = 3.7f + rnd.nextFloat() * 0.8f;       // 3.7 .. 4.5
        return new Bateria(amperaje, voltaje);
    }

    /**
     * Crea un Celular "vacío" (sin batería).
     * - El constructor de Celular debe encargarse de crear la UnidadModular
     *   y autogenerar el IMEI, según diseño del TP.
     *
     * NOTA: No inserta batería; la agregación se simula separadamente si se desea.
     */
    public static Celular nextCelular() {
        String modelo = nextModelo();
        int circuitos = nextCantidadCircuitos();
        return new Celular(modelo, circuitos); // IMEI se genera dentro del constructor de Celular
    }

    /**
     * Convenience: genera y devuelve tanto celular como batería instaurada (opcional).
     * NO se usa por defecto en el menú automático, pero puede servir en tests.
     */
    public static Celular nextCelularConBateria() {
        Celular c = nextCelular();
        Bateria b = nextBateria();
        c.insertarBateria(b);
        return c;
    }
}
