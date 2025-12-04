package org.example.clases;

public class Departamento extends Edificio {
    private byte piso;
    private char dpto;
    private int superficie;

    public Departamento ( float avaluoXmtr ,byte piso, char dpto, int superficie){
        super(avaluoXmtr);
        this.piso = piso;
        this.dpto = dpto;
        this.superficie = superficie;
    }

    @Override
    public float valuar(){
        return superficie * avaluoXmtr;
    }
}
