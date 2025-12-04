package org.example;

import org.example.clases.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        /* Para prueba manual
        //Creamos un registro capaz de guardar 3 lotes
        Registro reg = new Registro("Junin", 3);

        //creamos lotes individuales
        Lote l1 = new Lote(1,"Mitre 123",300,20000);
        Lote l2 = new Lote(2,"Almafuerte 233",230, 22000);

        //Registrarlos crea automaticamente Escrituras
        reg.registrar(l1);
        reg.registrar(l2);

        //Imprimir boletos (los lotes)
        reg.emitirBoletos();

        //Imprimir escrituras
        reg.mostrarEscrituras();

        //Valuacion ejemplo
        System.out.println("Valuacion lote 1:" + reg.valuar(l1));

        */

        // Agregue menu interactivo,



        List<Lote> lotesTemporales = new ArrayList<>(); //Lotes creados pero aun no registrados
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== SISTEMA PROVINCIAL DE REGISTRO ===");
        System.out.println("1. Modo Manual");
        System.out.println("2. Modo Automático (todo aleatorio)");
        System.out.print("Seleccione: ");

        int modo = sc.nextInt();

        if (modo == 1) {
            modoManual();
        } else {
            modoAutomatico();
        }
        sc.close();
    }

        //Modo manual

        private static void modoManual() {
            Scanner sc = new Scanner(System.in);

            Registro registro = null; //todavia no existe
            List<Lote> lotesPendientes = new ArrayList<>();

            //Contador para IDs

            int opcion = 0;

            while (opcion != 7) {
                System.out.println("**** MENU PARA INGRESO DE DATOS MANUAL ***");
                System.out.println("1. Crear Registro");
                System.out.println("2. Crear Lote manualmente");
                System.out.println("3. Crear lotes aleatorio");
                System.out.println("4. Ver lotes pendientes");
                System.out.println("5. Registrar un(1) lote");
                System.out.println("6. Registrar TODOS los lotes pendientes");
                System.out.println("7. Mostrar Escrituras/Emitir boletos");
                System.out.println("8. Salir ");
                System.out.println("Seleccione: ");

                opcion = sc.nextInt();

                switch (opcion) {
                    case 1 -> {
                        sc.nextLine(); //Limpia buffer
                        System.out.println("Municipio");
                        String muni = sc.nextLine();

                        System.out.println("Capacidad del registro: ");
                        int cap = sc.nextInt();
                        registro = new Registro(muni, cap);
                        lotesPendientes.clear();

                        GestorIds.reiniciarContador();  //Se reinicia contador de ids
                        System.out.println("Registro creado correctamente");

                    }

                    case 2 -> {
                        //Crear lote manual, con ID automatico
                        int id = GestorIds.generarNuevoId();
                        sc.nextLine();

                        System.out.println("ID generado automaticamente: " + id);
                        System.out.println("Domicilio: ");
                        String dom = sc.nextLine();
                        System.out.println("Superficie: ");
                        int sup = sc.nextInt();
                        System.out.println("Valor  por m2: ");
                        int val = sc.nextInt();

                        Lote lote = new Lote(id, dom, sup, val);
                        System.out.println("Lote creado: " + lote);
                        lotesPendientes.add(lote);

                        System.out.println("Lote creado y almacenado temporalmente");
                    }
                    case 3 -> {
                        Lote lote = GeneradorAleatorio.nextLote();
                        lotesPendientes.add(lote);

                        System.out.println("Lote aleatorio creado y guardado: " + lote);
                    }

                    case 4 -> {
                        //Mostrar pendientes
                        System.out.println("\n *** LOTES PENDIENTES ***");
                        if (lotesPendientes.isEmpty()) {
                            System.out.println("No hay lotes sin registrar.");
                        } else {
                            for (Lote lote : lotesPendientes) {
                                System.out.println(lote);
                            }
                        }
                    }

                    case 5 -> { //Registrar uno
                        if (registro != null) {
                            System.out.println("Cree un registro primero");
                        } else  if (lotesPendientes.isEmpty()) {
                            System.out.println("No hay lotes pendientes.");
                        } else {
                            Lote l = lotesPendientes.remove(0);
                            registro.registrar(l);
                            System.out.println("Registrado: " + l);
                        }
                    }

                    case 6 -> { //Registrar todos
                         if (registro == null){
                            System.out.println("Cree un registro primero.");
                         } else if (lotesPendientes.isEmpty()) {
                        System.out.println("No hay lotes pendientes.");
                         } else {
                             for  (Lote lote : lotesPendientes) {
                                 registro.registrar(lote);
                             }
                         }
                        lotesPendientes.clear();
                        System.out.println("Todos los lotes fueron registrados");
                    }

                    case 7 -> {
                        if (registro != null) {
                            System.out.println("\n*** Boletos ***");
                            registro.emitirBoletos();

                            System.out.println("\n *** Escrituras ***");
                            registro.mostrarEscrituras();
                        }
                    }
                }

            }
        }

        private static void modoAutomatico(){
            System.out.println("\n**** MODO AUTOMATICO ****");

            //Crear municipio aleatorio
            String municipio = GeneradorAleatorioMunicipio.nextMunicipio();
            System.out.println("Municipio Generado " + municipio);

            //capacidad aleatoria entre 5 y 15
            int capacidad = (int)(Math.random()*11 +5);
            System.out.println("Capacidad asignada:  " + capacidad);

            Registro reg = new Registro(municipio, capacidad);

            //Crear todos los lotes de forma aleatoria
            System.out.println("\n GENERANDO LOTES...........");
            for (int i = 0; i < capacidad; i++) {
                Lote lote = GeneradorAleatorio.nextLote();
                reg.registrar(lote);
            }

            //imprimir resultados
            System.out.println("*********** LOTES ***********");
            reg.emitirBoletos();

            System.out.println("\n ******* ESCRITURAS ********");
            reg.mostrarEscrituras();


            System.out.println("Proceso finalizado correctamente");
        }

        }

