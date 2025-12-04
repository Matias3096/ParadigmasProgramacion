package org.example.clases;

import org.example.Exceptions.ErrorLote;

public class Lote {
    private int idPadron;
    protected String domicilio;
    protected float avaluoXmtr;
    private int superficie;
    private Registro inscripto; // para el alta
    private Edificio construccion;  //TP2 consigna

    private static int contadorPadron=1;

    public Lote( String domicilio, float avaluoXmtr, int superfice) {
        this.idPadron = contadorPadron++;
        this.domicilio = domicilio;
        this.avaluoXmtr = avaluoXmtr;
        this.superficie = superfice;
    }
    //Metodo valuar
    public float valuar() {
        return superficie * avaluoXmtr;
    }

    //Get y set
    public int getIdPadron() {
        return idPadron;
    }
    void setInscripto(Registro r){
            this.inscripto = r;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public int getSuperficie() {
        return superficie;
    }

    @Override
    public String toString() {
        return "Lote # "+ idPadron +
                "| Domicilio: " + domicilio +
                "| Superficie: " + superficie +
                "| Avaluo x m2: $"  + avaluoXmtr;
    }

    //Tp2
    public void asignarEdificio(Edificio e) throws ErrorLote {
        if (this.construccion != null)
            throw  new ErrorLote("El lote ya tiene un edificio asignado.");
        this.construccion = e;
    }

}
