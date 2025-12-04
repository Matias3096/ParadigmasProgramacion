package org.example.clases;

/*
Celular:
    Hereda de dispositivo
    Implementa metodos encender() y apagar()

Composicion:
    Contiene UnidadModular creada SIEMPRE dentro del constructor
    El celular NO funciona sin una UM

Agregacion:
    La bateria se inserta desde afuera con insertarBateria(b)
    No se genera dentro del constructor
 */

public class Celular extends Dispositivo {

    private final String modelo;
    private final UnidadModular um;     //Composicion
    private Bateria bateria;        //Agregacion


    public Celular(String modelo, int cantidadCircuitos) {
        this.modelo = modelo;

        //COMPOSICION: la UM se crea dentro del constructor del celular
        this.um = new UnidadModular(cantidadCircuitos);
    }

    //AGREGACION: insertamos un objeto bateria externo
    public void insertarBateria (Bateria b) {
        this. bateria = b;
        System.out.println("Bateria insertada: " + b);
    }

    public Bateria extraerBateria() {
        Bateria retirada = bateria;
        bateria = null;
        return retirada;
    }

    @Override
    public void encender() {
        if (bateria == null) {
            System.out.println("Bateria no encontrada, no se puede encender");
            return;
        }

        encendido = true;
        System.out.println("Celular " + modelo + "encendido. ");
        System.out.println("Diagnostico: " + um.diagnostico());
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Celular " + modelo + "apagado. ");
    }

    @Override
    public String toString() {
        return "Celular { " +
                "modelo=( " + modelo + " )" +
                ", UM = " + um.getCantidadCircuitos() + "circuitos " +
                ", bateria: " + (bateria != null ? bateria.getNumeroSerie(): "sin bateria ")
                + ", encendido =" + encendido + "} ";

    }


}
