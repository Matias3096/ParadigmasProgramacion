package segundaParteTP.vehiculos;

import segundaParteTP.componentes.Chasis;
import segundaParteTP.componentes.Motor;
import segundaParteTP.componentes.Rueda;

public class Auto implements Vehiculo,  Producto {
    private String fabricante;
    private double precio;

    private Motor motor;  //asociacion
    private Chasis chasis;   //composicion
    private Rueda[] ruedas;  //agregacion ( arreglo)

    public Auto(String fabricante, double precio,
                Motor motor, Rueda[] ruedas) {

        this.fabricante = fabricante;
        this.precio = precio;
        this.motor = motor;
        this.ruedas = ruedas;

        //Composicion: creado dentro
        this.chasis = new Chasis("CH-AUTO" + Math.random());


    }

    @Override
    public String getFabricante() {
        return fabricante;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void verDatos() {
        System.out.println("\n *** AUTO ***");
        System.out.println("Fabricante: " + fabricante);
        System.out.println("Precio: $" + precio);
        System.out.println("Motor: N°" + motor.getNumeroMotor());
        System.out.println("Chasis: " + chasis.getNumeroChasis());

        System.out.println("Ruedas: ");
        for  (Rueda r : ruedas) {
            System.out.println(" - " + r.getMarca());
        }

    }
}
