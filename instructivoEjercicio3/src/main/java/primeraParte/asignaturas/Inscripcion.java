package primeraParte.asignaturas;

import primeraParte.miembros.Estudiante;

import java.util.List;

public class Inscripcion {

    private Estudiante alumno;
    private Curso curso;

    public Inscripcion(Estudiante alumno, Curso curso) {
        this.alumno = alumno;
        this.curso = curso;
    }

    public Estudiante getAlumno() {
        return alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    /*
    Metodo pedido en la consigna:
        Recibe nombres y retorna true/false
     */
    public static boolean estaInscripto(String nombreEstudiante, Curso curso) {
        for (Inscripcion ins : curso.getInscriptos().values()) {
            if (ins.getAlumno().getNombre().equals(nombreEstudiante)) {
                return true;
            }
        }
        return false;
    }

    //Metodo para contar cuantas inscripciones tiene un estudiante

    public static int contarInscripcionesDe(Estudiante e) {
        int total = 0;

        List<Curso> cursos = Curso.getTodosLosCursos();

        for (Curso c : cursos) {
            for (Inscripcion ins : c.getInscriptos().values()) {
                if (ins.getAlumno() == e) {
                    total++;
                }
            }
        }
        return total;
    }
}
