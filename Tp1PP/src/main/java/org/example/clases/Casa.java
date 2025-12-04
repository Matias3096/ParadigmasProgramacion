package org.example.clases;


public class Casa extends Edificio {
    private boolean plantaAlta;
    private int superficie;

    public Casa (float avaluoXmtr, boolean plantaAlta, int superficie) {
        super(avaluoXmtr);
        this.plantaAlta = plantaAlta;
        this.superficie = superficie;
    }

    @Override
    public float valuar(){
        return superficie * avaluoXmtr;
    }

}
