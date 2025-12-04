package org.example.clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Registro {
    private float coefAvaluoEdificio;
    private String municipio;
    protected float tasa;

    //Arreglo dinamico pero llamado exactamente inmueble
    private List<Lote> inmueble;
    private List<Escritura> escrituras;
    private static int contadorEscritura = 1;


    //Constructor
    public Registro(String municipio) {
        this.municipio = municipio;
        this.inmueble = new ArrayList<>();
        this.escrituras = new ArrayList<>();
    }

    //Alta sin limite de tamaño
    public void registrar(Lote l) {
       inmueble.add(l);

       Escritura e = new Escritura(l);  //Crea escritura fuera del add
       escrituras.add(e);               //Escritura recibe lote mas registro
        l.setInscripto(this);
    }

    public float valuar(Lote l) {
        return l.valuar();
    }

    //Recorre el arreglo dinamico
    public void emitirBoletos() {
        for (Lote l : inmueble)
            System.out.println(l);
    }


    public void mostrarEscrituras() {
        for (Escritura e : escrituras) {
            System.out.println(e);
        }
    }

    //Getters y setters
    public void setTasa(float tasa) {
        this.tasa = tasa;
    }
    public float getTasa() {
        return tasa;
    }
    public void setCoefAvaluoEdificio(float coef) {
        this.coefAvaluoEdificio = coef;
    }
    public float getCoefAvaluoEdificio() {
        return coefAvaluoEdificio;
    }


    //Tp2
    //Guardar escrituras
    public void guardar() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("escrituras.dat"))){
            out.writeObject(escrituras);
            System.out.println("escrituras guardadas");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Recuperar Escrituras
    public void recuperar () {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("escrituras.dat"))){
            this.escrituras = (ArrayList<Escritura>) in.readObject();
            System.out.println("escrituras recuperadas");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


