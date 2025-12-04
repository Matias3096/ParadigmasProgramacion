package org.example.clases;

/*
Lote representa un terreno fisico.
Tiene:
    Un identificador
    un domicilio
    una superficie
    un edificio asociado( relacion simple)
 */
public class Lote {

    private int id;
    private String domicilio;
    private int superficie;
    private Edificio edificio; //ASOCIACION simple (1 -> 1)
    private int valorSuperficie;

    public Lote(int id, String domicilio, int Superficie, int valorSuperficie) {
        this.id = id;
        this.domicilio = domicilio;
        this.superficie = Superficie;
        this.valorSuperficie =  valorSuperficie;
    }

    public void asignarEdificio(Edificio e){
        this.edificio = e;

    }

    //Valuar usa el edificio si existe, sino valua el m2 solo

    public float valuar() {
        if (this.edificio != null) {
            return edificio.valuar();
        }
        //No hay edificio, valorizamos por terreno
        return this.superficie * this.valorSuperficie; // en valor superficie
    }

    @Override
    public String toString() {
        return "Lote # " + id + "| " + domicilio +
                "| Superficie: " + superficie + " m2";
    }

    //Getters importantes
    public int getId() {
        return id;
    }
    public int getSuperficie() {
        return superficie;
    }
    public String getDomicilio() {
        return domicilio;
    }

}
