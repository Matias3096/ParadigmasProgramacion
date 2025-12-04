package org.example.clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Registro {
    private float coefAvaluoEdificio;
    private String municipio;
    protected float tasa;

    //Arreglo dinamico pero llamado exactamente inmueble
    private List<Lote> inmueble; // rol inmueble 1..n
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
        if (l == null) throw new IllegalArgumentException("Lote nulo");
        inmueble.add(l);
        Escritura e = new Escritura(l);
        escrituras.add(e);
    }

    //Delega la valuacion al lote
    public float valuar(Lote l) {

        return l.valuar();
    }

    //Muestra los lotes registrados
    public void emitirBoletos() {
        System.out.println("=== BOLETOS (" + inmueble.size() + ") ===");
        for (Lote l : inmueble) System.out.println(l);
    }

    //Muestra las escrituras generadas
    public void mostrarEscrituras() {
        System.out.println("=== ESCRITURAS (" + escrituras.size() + ") ===");
        for (Escritura e : escrituras) System.out.println(e);
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


    //Guardar escrituras, persistencia, guarda el ArrayList<Escritura> en archivo
    public void guardar() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("escrituras.dat"))){
            out.writeObject(escrituras);
            System.out.println("escrituras guardadas en 'escrituras.dat'");
        } catch (IOException ex) {
            System.err.println("Error guardando escrituras: " + ex.getMessage());
        }
    }

    //Recuperar Escrituras
    @SuppressWarnings("unchecked")
    public void recuperar () {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("escrituras.dat"))) {
            List<Escritura> rec = (List<Escritura>) in.readObject();
            escrituras.clear();
            escrituras.addAll(rec);
            System.out.println("Escrituras recuperadas desde 'escrituras.dat'.");
        } catch (FileNotFoundException e) {
            System.err.println("Archivo de escrituras no encontrado.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error recuperando escrituras: " + e.getMessage());
        }
    }
}


