package org.example.clases;

/*
Escritura se crea cada vez que un lote se registra.
Guarda solo los datos legales necesarios
 */
public class Escritura {

    private static int contador = 1; //Variable de clase pedida
    private int numero;
    private String domicilio;
    private int superficie;

    public Escritura(Lote lote) {
        this.numero = contador++;
        this.domicilio = lote.getDomicilio();
        this.superficie = lote.getSuperficie();
    }

    @Override
    public String toString() {
        return "| Escritura # " + numero +
                " | " + domicilio +
                " | Superficie: " + superficie + "m2";
    }
}
