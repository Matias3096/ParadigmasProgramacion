package org.example.clases;

public class Departamento extends Edificio {
    private byte piso;
    private char dpto;
    private int superficie;

    public Departamento ( float avaluoXmtr ,byte piso, char dpto, int superficie){
        super(avaluoXmtr);
        if (superficie <= 0 ) throw new IllegalArgumentException("Superficie debe ser > 0.");
        this.piso = piso;
        this.dpto = dpto;
        this.superficie = superficie;
    }

    @Override
    public float valuar(){
        return superficie * avaluoXmtr;
    }

    public byte getPiso() {
        return piso;
    }
    public char  getDpto() {
        return dpto;
    }
    public int getSuperficie() {
        return superficie;
    }
}
