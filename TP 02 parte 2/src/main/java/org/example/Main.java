package org.example;

import org.example.Exceptions.ErrorLote;
import org.example.clases.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Crear un registro
        Registro reg = new Registro("Junin");

        //Lote
        Lote l1 = new Lote(1001,"Mitre 21",30000,230);

        //Edificio
        //Casa con planta alta
        Casa casa1 = new Casa(20000,true,300);

        //Asignar edificio al lote

        try {
            l1.asignarEdificio(casa1);
        } catch (ErrorLote e) {
            System.out.println("No se pudo asignar edificio" + e.getMessage());
        }

        //Registrar el lote en el registro
        reg.registrar(l1);

        //Mostrar escrituras generadas
        reg.mostrarEscrituras();

        //persistir escrituras
        reg.guardar();

        // recuperarlas
        reg.recuperar();
    }
}