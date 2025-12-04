package org.example.clases;


public class Casa extends Edificio {
    private boolean plantaAlta;
    private int superficie;

    public Casa (float avaluoXmtr, boolean plantaAlta, int superficie) {
        super(avaluoXmtr);
        if (superficie <= 0) throw new IllegalArgumentException("Superficie debe ser > 0");
        this.plantaAlta = plantaAlta;
        this.superficie = superficie;
    }

    @Override
    public float valuar(){
        return superficie * avaluoXmtr;
    }

    public boolean tienePlantaAlta(){
        return plantaAlta;
    }
    public int getSuperficie(){
        return superficie;
    }
}
