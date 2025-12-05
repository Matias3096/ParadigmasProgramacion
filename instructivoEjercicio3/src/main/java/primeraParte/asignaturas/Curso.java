package primeraParte.asignaturas;

import primeraParte.miembros.Estudiante;
import primeraParte.miembros.Profesor;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Curso extends Hashtable<Integer, Inscripcion> {

    private String titulo;
    private Profesor profesor;

    private static List<Curso> todosLosCursos = new ArrayList<>();

    public Curso (){
        super();
        todosLosCursos.add(this);
    }

    public Curso(String titulo) {
        super();
        this.titulo = titulo;
        todosLosCursos.add(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Profesor getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void agregarInscripcion(Inscripcion ins){
        Estudiante e = ins.getAlumno();
        this.put(e.getLegajo(), ins);
        System.out.println("Inscripcion exitosa: " +
                e.getNombre() + "->" + titulo);
    }

    public void inscriptos() {
        if (this.isEmpty()) {
            System.out.println("No hay inscriptos en " + titulo);
            return;
        }

        System.out.println("Inscriptos en " + titulo + ":");
        for (Inscripcion ins : this.values()) {
            System.out.println(" - " + ins.getAlumno().getNombre() +
                    "(Legajo " + ins.getAlumno().getLegajo() + ")");
        }
    }

    public int getCantidadInscriptos() {
        return this.size();
    }

    public static List<Curso> getTodosLosCursos() {
        return todosLosCursos;
    }

    public Hashtable<Integer, Inscripcion> getInscriptos() {
        return this;
    }


}
