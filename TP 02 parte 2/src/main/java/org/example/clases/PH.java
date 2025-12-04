package org.example.clases;

import java.util.ArrayList;
import java.util.List;

public class PH extends Edificio {
    private byte cantPisos;
    private final List<Departamento> unidades;

    public PH (float avaluoXmtr, byte cantPisos){
        super (avaluoXmtr);
        this.cantPisos = cantPisos;
        this.unidades = new ArrayList<>(); //Parametrizado: ArrayList<Departamento>
    }
    public void agregarDepartamento (Departamento d){
        if (d == null) throw new IllegalArgumentException("Departamento nulo.");
        unidades.add (d);
    }

    @Override
    public float valuar(){
        float total = 0;
        for (Departamento d : unidades)
            total += d.valuar();
        return total;
    }

    public List<Departamento> getUnidades(){
        return unidades;
    }

    public  byte getCantPisos(){
        return cantPisos;
    }
}
