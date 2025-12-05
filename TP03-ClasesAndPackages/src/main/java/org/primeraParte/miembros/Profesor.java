package org.primeraParte.miembros;

import org.primeraParte.asignaturas.Curso;

public class Profesor extends Persona {

    //Para simplificar asociamos UN curso que dicta (puede extenderse a lista si se desea)
    private Curso cursoQueDicta;

    public Profesor(String nombre, String apellido) {

        super(nombre, apellido);
    }

    //metodo que "vincula" el profesor con un curso
    public void dicta(Curso curso) {
        this.cursoQueDicta = curso;
        curso.setProfesor(this); // tambien establecemos la referencia en el curso
    }

    //metodo pedido: mostrar el nombre del curso que dicta
    public String mostrarNombreCursoQueDicta() {
        if (cursoQueDicta == null) return " No dicta ningun curso";
        return cursoQueDicta.getNombre();
    }

    @Override
    public String toString() {
        return super.toString() + " - Profesor de: " + (cursoQueDicta == null ? "Ninguno" : cursoQueDicta.getNombre());
    }
}
