package org.example.clases;

import org.example.Exceptions.ErrorLote;

public class Lote {
    private int idPadron;
    protected String domicilio;
    protected float avaluoXmtr;
    private int superficie;
    //private Registro inscripto; // para el alta
    private Edificio construccion;  //TP2 consigna

    private static int contadorPadron=1;

    public Lote(Integer idPadron, String domicilio, float avaluoXmtr, int superficie) {
        if (idPadron == null) throw new IllegalArgumentException("idPadron nulo");
        if (superficie <= 0) throw new IllegalArgumentException("superficie debe ser > 0");
        this.idPadron = idPadron;
        this.domicilio = domicilio;
        this.avaluoXmtr = avaluoXmtr;
        this.superficie = superficie;
        this.construccion = null;
    }

    //Metodo valuar
    public float valuar() {
        if (construccion != null) {
            return construccion.valuar();
        }
        return superficie * avaluoXmtr;
    }

    //Get y set
    public int getIdPadron() {
        return idPadron;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public int getSuperficie() {
        return superficie;
    }

    public float getAvaluoxmt() { return avaluoXmtr; }

    public Edificio getConstruccion() { return construccion; }
    @Override
    public String toString() {
        return "Lote # "+ idPadron +
                "| Domicilio: " + domicilio +
                "| Superficie: " + superficie +
                "| Avaluo x m2: $"  + avaluoXmtr +
                (construccion != null ? " | Construcción: " + construccion.getClass().getSimpleName() : "");
    }

    //Tp2
    public void asignarEdificio(Edificio e) throws ErrorLote {
        if (this.construccion != null)
            throw  new ErrorLote("El lote ya tiene un edificio asignado.");
        this.construccion = e;
    }

}
