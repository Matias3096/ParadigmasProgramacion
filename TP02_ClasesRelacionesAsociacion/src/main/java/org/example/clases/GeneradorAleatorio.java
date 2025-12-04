package org.example.clases;

import java.util.Random;
import java.util.Scanner;

public class GeneradorAleatorio {
    private static Random aleatorio = new Random();

    //Contador interno para IDs (evita repetirlos)
    private static int contadorId = 1;

    //Lista de nombres de calles reales (Se pueden agregar mas)
    private static final String[] CALLES = {
            "San Martín", "Belgrano", "Almafuerte", "Mitre", "Sarmiento",
            "Alem", "Roman Cano", "Muñoz ", "Pellegrini", "Gonzalez"
    };

    //Devuelve un entero dentro del rango [min,max]
    private static int randomEnRango(int min, int max) {
        return aleatorio.nextInt((max - min) + 1) + min;
    }

    //Genera un domicilio como "Belgrano 532"
    private static String generarDomicilio(){
        String calle = CALLES[aleatorio.nextInt(CALLES.length)];
        int numero = randomEnRango(100,999);
        return calle + "-" + numero;
    }

    //Valor del m2 depende la zona. Baratas = 15000, medias = 25000, caras = 45000
    private static int generarValorM2(){
        int tipoZona = aleatorio.nextInt(3); //0,1,2

        return switch (tipoZona){
            case 0 -> randomEnRango(12000,19999);
            case 1 -> randomEnRango(20000,34999);
            default -> randomEnRango(35000,50000);
        };
    }
    //Genera una superficie realista
    private static int generarSuperficie(){
        return randomEnRango(150,600); //en m2
    }

    //Fabrica un objeto Lote completo y aleatorio
    public static Lote nextLote(){
        int id = contadorId++;
        String domicilio =  generarDomicilio();
        int superficie = generarSuperficie();
        int valorM2 = generarValorM2();

        return new Lote(id, domicilio, superficie, valorM2);
    }
}
