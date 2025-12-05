package org.example.Componentes;


/*
Representa la superclase para motor y carroceria.
Gestiona el numero autogenerado y precio comun
 */

public abstract class Componente {
    private static int contador = 0; //Contador estatico que autogenera numeros

    protected int numero; //id
    protected float precio;

    public Componente(float precio){
        contador++;
        this.numero = contador;
        this.precio = precio;
    }

    public int getNumero() {
        return numero;
    }
    public float getPrecio() {
        return precio;
    }

    //Representacion simple para listas/archivos
    @Override
    public String toString() {
        return "Componente [Numero: " + numero + ", precio: $" + precio + "ARS]";
    }


}
