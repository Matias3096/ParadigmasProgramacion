package org.example.clases;

import java.util.ArrayList;

public class PH extends Edificio {
    private byte cantPisos;
    private ArrayList<Departamento> unidades;

    public PH (float avaluoXmtr, byte cantPisos){
        super (avaluoXmtr);
        this.cantPisos = cantPisos;
        unidades = new ArrayList<>();
    }
    public void agregarDepartamento (Departamento d){
        unidades.add (d);
    }

    @Override
    public float valuar(){
        float total = 0;
        for (Departamento d : unidades)
            total += d.valuar();
        return total;
    }
}
