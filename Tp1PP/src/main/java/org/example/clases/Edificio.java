package org.example.clases;

public abstract class Edificio {
    protected float avaluoXmtr;


    //Constructor
    public Edificio (float avaluoXmtr) {

        this.avaluoXmtr = avaluoXmtr;
    }

    public abstract float valuar();
    public void setAvaluo (float avaluoXmtr){
        this.avaluoXmtr = avaluoXmtr;
    }

    public float getAvaluo(){

        return avaluoXmtr;
    }

    public void demoler(){
        System.out.println("Edificion demolido..");
    }
}
