package org.example.clases;

import java.io.Serializable;

public class Escritura implements Serializable {  //Para tp2 debe ser serializable
    private static final long serialVersionUID = 1L;
    private static int contador = 1;

    private Integer numero;
    private int superficie;
    protected String domicilio;

    //private Lote lote;
    //private Registro registro;  Dan error de exception

    //Constructor
    public Escritura(Lote lote) {
        this.numero = contador++;
        this.domicilio = lote.getDomicilio();
        this.superficie = lote.getSuperficie();
    }


    @Override
    public String toString() {
        return "Escritura # " + numero +
        "| Domicilio: " + domicilio +
        "| Superficie: " + superficie + "m2";
    }

}
