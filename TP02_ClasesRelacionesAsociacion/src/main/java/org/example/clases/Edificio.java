package org.example.clases;


/*
Clase abstracta que representa la idea general de un edificio.
No se puede instanciar (abstract), solo sive como 'modelo conceptual'
para que un Lote diga "Tengo un edificio"

La consigna pide una variable estatica con un inicializador static
 */

public abstract class Edificio {

    //variable de clase( de Edificio, NO de cada objeto)
    protected static float coeficienteAvaluo;

    //Inicializador static: se ejecuta una vez cuando la clase se carga
    static {
        coeficienteAvaluo = 1.15f; //valor arbitrario indicado en la consigna
    }

    //Atributos comunes a cualquier edificio
    protected int superficie;  //en m2
    protected float avaluoXm2; //Valor fiscal por metro

    public Edificio (int superficie,  float avaluoXm2) {
        this.superficie = superficie;
        this.avaluoXm2 = avaluoXm2;
    }

    /*
    Al ser abstracta, declaramos un metodo que cada subclase debera implementar.
    Pero en este TP02 NO HAY SUBCLASES, todavia..........
    Lo dejamos definido porque la consigna lo sugiere.
     */
    public abstract float valuar();
}
