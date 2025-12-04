package org.example.clases;

public abstract class Edificio {   //concepto general de edificio
    protected float avaluoXmtr;


    //Constructor
    public Edificio (float avaluoXmtr) {

        this.avaluoXmtr = avaluoXmtr;
    }

    //Cada subtipo define su propia forma de valuar
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
