package org.example.clases;


/*
Unidad Modular representa el corazon o nucleo del celular

Motivo de existencia:
Es parte esencial: un celular no existe sin su UnidadModular
Implementamos como clase independiente para poder abstraer su complejidad:
    Cantidad de circuitos
    reinicios
    diagnosticos

En el modelo: relacion de COMPOSICION - la UnidadModular se crea dentro del celular.
 */
public class UnidadModular {

    //Atributo simple para ejemplificar: cantidad de circuitos
    private int cantidadCircuitos;

    public UnidadModular( int  cantidadCircuitos ) {
        this.cantidadCircuitos = cantidadCircuitos;
    }

    public int getCantidadCircuitos() {
        return cantidadCircuitos;
    }

    public String diagnostico() {
        return "Unidad Modular OK - Circuitos: " + cantidadCircuitos;
    }
}
