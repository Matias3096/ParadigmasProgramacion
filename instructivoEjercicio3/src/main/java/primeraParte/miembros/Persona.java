package primeraParte.miembros;

public class Persona {
    protected String nombre;
    protected Integer legajo; //Id unico

    private static int contadorLegajos = 1000;

    public Persona() {
        //Constructor vacio como en el diagrama
    }

    public Persona(String nombre) {
        this.nombre = nombre;
        this.legajo = contadorLegajos++; //Se asigna y luego se incrementa
    }

    public String getNombre() {
        return nombre;
    }

    public void  setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getLegajo() {
        return legajo;
    }
    @Override
    public String toString() {
        return String.format("%s (legajo: %s)" , getNombre(), legajo);
    }
}
