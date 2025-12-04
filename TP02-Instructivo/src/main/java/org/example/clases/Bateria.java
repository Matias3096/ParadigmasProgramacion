package org.example.clases;


/*
Bateria:
    Atributos privados: amperaje, voltaje y numeroSerie.
    El numeroSerie se genera automaticamente

Relacion con celular:
    Es agregacion, la bateria NO pertenece permanentemente al celular
    Se puede extraer o cambiar
 */

public class Bateria {

    private final String numeroSerie;
    private final int amperaje;
    private final float voltaje;

    public Bateria(int amperaje, float voltaje) {
        this.amperaje = amperaje;
        this.voltaje = voltaje;
        this.numeroSerie = GeneradorSerial.generarSerial();
    }
    public String getNumeroSerie() {
        return numeroSerie;
    }

    public int getAmperaje() {
        return amperaje;
    }
    public float getVoltaje() {
        return voltaje;
    }

    @Override
    public String toString() {
        return "| Bateria: Serie =' " + numeroSerie + " ', "
                + "mAh: " + amperaje +
                " , " +  voltaje +
                " V |";

    }
}
