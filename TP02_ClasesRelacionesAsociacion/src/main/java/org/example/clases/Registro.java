package org.example.clases;

/*
Registro administra un conjunto de lotes y sus escrituras.
La consigna fuerza el uso de ARRAY simple para almacenar lotes
 */
public class Registro {

    private String municipio;
    private Lote[] lotes; //arreglo simple
    private Escritura[] escrituras;

    private int indiceLote = 0;
    private int indiceEscritura = 0;

    public Registro (String municipio, int capacidad) {
        this.municipio = municipio;
        this.lotes = new Lote[capacidad];
        this.escrituras = new Escritura[capacidad];
    }

    /*
    registrar() agrega el lote al arreglo y crea automaticamente su Escritura asociada (relacion asociativa)
     */
    public void registrar(Lote l) {
        if (indiceLote >= lotes.length) {
            System.out.println("ERROR: registro lleno. No se pueden agregar mas lotes.");
            return;
        }
        lotes[indiceLote] = l;

        //Crear escritura y agregarla incrementando su indice
        if (indiceEscritura >= escrituras.length) {
            System.out.println("ERROR: buffer de escrituras lleno.");
            return;
        }
        escrituras[indiceEscritura++] = new Escritura(l);
    }
    // Valuar usa el valuar() de Lote -> delegacion
    public float valuar(Lote l) {
        return l.valuar();
    }

    //este metodo recorre lotes registrados (usamos indiceLote)
    public void emitirBoletos() {
        System.out.println("****** BOLETOS ******");
        for(int i = 0; i < indiceLote; i++) {
            System.out.println(lotes[i]);
        }
    }

    //Metodo auxiliar para ver las escrituras generadas
    public void mostrarEscrituras() {
        System.out.println("****** ESCRITURAS ******");
        for (int i = 0; i < indiceEscritura; i++) {
            System.out.println(escrituras[i]);
        }
    }
}
