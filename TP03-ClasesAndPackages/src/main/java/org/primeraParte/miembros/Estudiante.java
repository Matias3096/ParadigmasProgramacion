package org.primeraParte.miembros;

import org.primeraParte.asignaturas.Inscripcion;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona{
    //guardamos localmente las inscripciones del estudiante para poder controlar el limite de 3.
    private List<Inscripcion> inscripciones;

    public Estudiante( String nombre, String apellido) {
        super(nombre, apellido); //Persona genera el legajo automaticamente
        this.inscripciones = new ArrayList<>();
    }
    //Añade una inscripcion a la lista del estudiante
    public void agregarInscripcion(Inscripcion i) {
        inscripciones.add(i);
    }

    //elimina una inscripcion ( por ejemplo si se diera de baja)
    public void quitarInscripcion(Inscripcion i){
        inscripciones.remove(i);
    }

    //devuelve cuantos cursos tiene el estudiante
    public int cantidadInscripciones() {
        return inscripciones.size();
    }

    //Metodo pedido: mostrar el nombre ( o nombres) de los cursos en que esta inscripto
    public List<String> mostrarNombresCursos(){
        List<String> nombres = new ArrayList<>();
        for (Inscripcion i : inscripciones) {
            nombres.add(i.getCurso().getNombre());
        }
        return nombres;
    }

    @Override
    public String toString() {

        return super.toString() + " - " + cantidadInscripciones() + "inscripciones";
    }
}
