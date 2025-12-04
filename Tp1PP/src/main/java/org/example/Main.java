package org.example;

import org.example.Exceptions.ErrorLote;
import org.example.clases.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

        System.out.println("======Sistema provincial de registro de lotes======");

        System.out.println("Ingrese el nombre del municipio");
        String municipio = sc.nextLine();

        Registro registro = new Registro(municipio);

        System.out.println("¿Cuantos lotes desea registrar?");
        int cantidad = sc.nextInt();

        System.out.println("===GENERANDO LOTES===");
        for (int i = 0 ; i < cantidad ; i++){
            Lote lote = GeneradorAleatorio.nextLote();//Crea un lote aleatorio
            registro.registrar(lote); //Registra lote y crea una escritura

            //tp2
            //Asignar un edificio aleatorio
            try {
                asignarEdificioAleatorio(lote);
            } catch (ErrorLote e) {
                System.out.println("Error al asignar edificio: " + e.getMessage());
            }
        }

        System.out.println("=====Lotes Registrados=====");
        registro.emitirBoletos(); //Muestra solamente los lotes como lo pide el tp

        System.out.println("=====Escrituras generadas=====");
        registro.mostrarEscrituras();//Metodo opcional de ayuda visual




        // PERSISTENCIA DE TP2
        System.out.println("\n GUARDANDO ESCRITURAS....................");
        registro.guardar();

        System.out.println("RECUPERANDO ESCRITURAS...................");
        registro.recuperar();

        System.out.println("ESCRITURAS RECUPERADAS.....................");
        registro.mostrarEscrituras();
        sc.close();


    }


    //Metodo auxiliar: asigna un edificio aleatorio a un lote, para tp2

    private static void asignarEdificioAleatorio (Lote lote) throws ErrorLote {
        int r = (int) (Math.random() * 3);  //O= casa, 1 = Ph, 2= Departamento

        switch (r) {
            case 0 -> {
                Casa casa = new Casa(12000, true, lote.getSuperficie());
                lote.asignarEdificio(casa);
                System.out.println("Se asigno una casa al lote" + lote.getIdPadron());
            }
            case 1 -> {
                PH ph = new PH(90000,(byte) 2 );

                //Agregar departamentos al PH
                Departamento d1 = new Departamento(95000, (byte) 1, 'A', 40);
                Departamento d2 = new Departamento(95000, (byte) 2, 'B', 30);

                ph.agregarDepartamento(d1);
                ph.agregarDepartamento(d2);
            }
            case 2 -> {
                Departamento dpto = new  Departamento(110000, (byte) 3, 'C', lote.getSuperficie());
                lote.asignarEdificio(dpto);
                System.out.println("Se asigno un Departamento al lote: " + lote.getIdPadron());
            }
        }
    }


}