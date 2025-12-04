package org.example.clases;

/*
Clase abstracta que modeliza un dispositivo generico

Razonamiento:
No sabemos que dispositivo exactamente, por eso es abstracta
Declaramos los comportamientos genericos que TODO dispositivo debe implementar Encender() y Apagar()
La implementacion concreta depende de la subclase
 */
public abstract class Dispositivo {

    //Estado basico comun a cualquier dispositivo: si esta encendido o apagado
    protected boolean encendido = false;

    //Comportamientos abstractos que las subclases deben implementar.
    public abstract void encender();
    public abstract void apagar();

    //Metodo utilitario provisto en la clase base: interrogacion del estado.
    public boolean estaEncendido() {
        return encendido;
    }
}
