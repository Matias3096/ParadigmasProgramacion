package org.example;

import org.example.clases.Bateria;
import org.example.clases.Celular;
import org.example.clases.GeneradorAleatorio;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /* PRUEBAS AL INICIO, para ver si todo funciona
        System.out.println("PRUEBA DEL MODELO CELULAR (TP 02)");

        //creando un celular, necesita la cantidad de circuitos del modulo( composicion)
        Celular cel1 = new Celular("Samsung A54", 12);
        System.out.println("Celular creado: " + cel1);

        //Intentar encender SIN bateria
        System.out.println("\n Intentando encender sin bateria...");
        cel1.encender(); //debe avisar que NO se puede encender


        //Crear una bateria fuera del celular, AGREGACION
        Bateria bat1 = new Bateria(5000,4.8f);  //Es necesario hacerlo con integer o float?
        System.out.println("Bateria creada: " + bat1);

        //Insertar bateria en un celular
        cel1.insertarBateria(bat1);

        //Encender celular ( ahora si puede)
        System.out.println("\n Encendiendo celular...");
        cel1.encender();

        //Mostrar estado del celular
        System.out.println("\n Estado actual: ");
        System.out.println(cel1);

        //Apagar el celular
        System.out.println("Apagando celular...");
        cel1.apagar();

        //Extraer bateria
        System.out.println("\nExtrayendo bateria");
        cel1.extraerBateria();

        //Intentar encender nuevamente (fallara)
        System.out.println("\n Intentando encender nuevamente sin bateria...");
        cel1.encender();

        System.out.println("PRUEBA FINALIZADA");

         */


        //Ahora con la automatizacion

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("SISTEMA CELULARES TP2");
            System.out.println("1. Modo manual");
            System.out.println("2. Modo automatico");
            System.out.println("0. Salir");
            System.out.println("Seleccione: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> modoManual();
                case 2 -> modoAutomatico();
            }
        } while (opcion != 0);

        System.out.println("\n Programa finalizado");
    }

    //Modo manual
    private static void modoManual() {
        Scanner sc = new Scanner(System.in);

        Celular celular = null;
        Bateria bateria = null;

        int opcion;
        do {
            System.out.println("\n===== MODO MANUAL =====");
            System.out.println("1. Crear Celular");
            System.out.println("2. Crear Batería");
            System.out.println("3. Insertar batería al celular");
            System.out.println("4. Extraer batería");
            System.out.println("5. Encender celular");
            System.out.println("6. Apagar celular");
            System.out.println("7. Mostrar estado");
            System.out.println("8. Volver");
            System.out.print("Seleccione: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    sc.nextLine();
                    System.out.println("Modelo del celular:");
                    String modelo = sc.nextLine();

                    System.out.println("Cantidad de circuitos del modulo: ");
                    int cant = sc.nextInt();

                    celular = new Celular(modelo, cant);
                    System.out.println("Celular creado correctamente");
                }
                case 2 -> {
                    if (celular == null) {
                        System.out.println("Primero debe crear un celular");
                        break;
                    }
                    System.out.print("Amperaje de la batería: ");
                    int amp = sc.nextInt();

                    System.out.print("Voltaje de la batería: ");
                    float volt = sc.nextFloat();

                    bateria = new Bateria(amp, volt);
                    System.out.println("Batería creada: " + bateria);
                }
                case 3 -> {
                    if (celular == null) {
                        System.out.println("Primero cree un celular.");
                        break;
                    }
                    if (bateria == null) {
                        System.out.println("Cree una batería primero.");
                        break;
                    }

                    celular.insertarBateria(bateria);
                    System.out.println("Batería insertada correctamente.");
                }
                case 4 -> {
                    if (celular == null) {
                        System.out.println("No hay celular creado.");
                        break;
                    }
                    celular.extraerBateria();
                    System.out.println("Batería extraída.");
                }
                case 5 -> {
                    if (celular == null) {
                        System.out.println("Cree un celular primero.");
                        break;
                    }
                    celular.encender();

                }
                case 6 -> {
                    if (celular == null) {
                        System.out.println("Cree un celular primero.");
                        break;
                    }
                    celular.apagar();

                }
                case 7 -> {
                    if (celular == null) {
                        System.out.println("No hay celular creado.");
                        break;
                    }
                    System.out.println("\nEstado actual:");
                    System.out.println(celular);
                }

            }
        } while (opcion != 8);
    }

    //Modo automatico
    private static void modoAutomatico() {

            System.out.println("\n===== MODO AUTOMÁTICO =====");

            // 1 — Crear celular aleatorio
            Celular celular = GeneradorAleatorio.nextCelular();
            System.out.println("Celular generado: " + celular);

            // 2 — Intentar encender sin batería
            System.out.println("\nIntentando encender sin batería...");
            celular.encender();

            // 3 — Crear batería aleatoria
            Bateria bat = GeneradorAleatorio.nextBateria();
            System.out.println("Batería generada: " + bat);

            // 4 — Insertar batería
            celular.insertarBateria(bat);

            // 5 — Encender correctamente
            System.out.println("\nEncendiendo celular...");
            celular.encender();

            // 6 — Mostrar estado
            System.out.println("\nEstado actual:");
            System.out.println(celular);

            // 7 — Apagar
            System.out.println("\nApagando...");
            celular.apagar();

            // 8 — Extraer batería
            System.out.println("\nExtrayendo bateria...");
            celular.extraerBateria();

            // 9 — Intentar encender otra vez
            System.out.println("\nIntentando encender sin bateria otra vez...");
            celular.encender();

            System.out.println("\nProceso automático finalizado.");
        }
    }