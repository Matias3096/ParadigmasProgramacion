package org.example.Almacen;

import org.example.Componentes.Carroceria;
import org.example.Componentes.Motor;

public class Vehiculo {

    private static int contadorId=0;

    private int id;
    private int peso;
    private float precio;

    private Motor motor;
    private Carroceria carroceria;

    public Vehiculo(int peso, float precio, Motor motor, Carroceria carroceria) {
        contadorId++;
        this.id = contadorId;
        this.peso = peso;
        this.precio = precio;
        this.motor = motor;
        this.carroceria = carroceria;
    }

    public int getId() {
        return id;
    }
    public int getPeso() {
        return peso;
    }
    public float getPrecio() {
        return precio;
    }
    public Motor getMotor() {
        return motor;
    }
    public Carroceria getCarroceria() {
        return carroceria;
    }

    public float calcularPrecio() {
        float total = precio;
        if (motor != null) total += motor.getPrecio();
        if (carroceria != null) total += carroceria.getPrecio();
        return total;
    }

    @Override
    public String toString() {
        return "[V#" + id + "] peso: " + peso + "kg base: $" + precio;
    }

    //Seralizacion simple para archivo, devuelve una sola linea representando el vehiculo y sus componentes
    public String toText() {
        StringBuilder sb = new StringBuilder();
        sb.append("VEHICULO;").append(id).append(";").append(peso).append(";").append(precio).append(";");
        sb.append(motor.toText()).append(";");
        sb.append(carroceria.toText());
        return sb.toString();
    }

    //Reconstruccion desde linea de texto (devuelve vehiculo) simple parser
    public static Vehiculo fromText(String line) {
        String[] parts = line.split(";");

        if (parts.length < 13) return null; //chequeo basico
        int peso = Integer.parseInt(parts[2]);
        float precio = Float.parseFloat(parts[3]);

        //encontrar indices motor
        int idxMotor = 4;
        Motor motor = Motor.fromText(parts,idxMotor);

        //carroceria
        int idxCar = idxMotor + 5;
        Carroceria car =  Carroceria.fromText(parts,idxCar);
        return new Vehiculo(peso,precio,motor,car);
    }

}
