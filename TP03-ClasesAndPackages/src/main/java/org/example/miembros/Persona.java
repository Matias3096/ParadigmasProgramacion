package org.example.miembros;

public class Persona {
    protected String nombre;
    protected String apellido;
    protected Integer legajo; // identificador unico( puede ser legajo o dni)

    private static int contadorLegajos = 1000;

    public Persona(String nombre, String apellido, Integer legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = contadorLegajos++;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public Integer getLegajo() {
        return legajo;
    }
    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return String.format("%s (legajo: %s)" , getNombreCompleto(), legajo);
    }
}
