package org.primeraParte.asignaturas;

import org.primeraParte.miembros.Estudiante;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Inscripcion {
    public Estudiante estudiante;
    public Curso curso;
    private LocalDateTime fecha;

    public Inscripcion (Estudiante estudiante, Curso curso) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.fecha = LocalDateTime.now();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
    public Curso getCurso() {
        return curso;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }

    public String verFechaFormateada (){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return fecha.format(f);
    }

    @Override
    public String toString(){
        return String.format("%s incripto en %s el %s",
                estudiante.getNombreCompleto(),
                curso.getNombre(),
                verFechaFormateada());
    }

    //Metodo de clase pedido: recibe nombre de estudiante y un curso
    // devuelve true si esta inscripto en ese curso (por nombre)

    public static boolean estaInscripto (String nombreEstudiante, Curso curso) {
        for (Inscripcion i : curso.values()) {
            if (i.getEstudiante().getNombre().equalsIgnoreCase(nombreEstudiante)) {
                return true;
            }
        }
        return false;
    }
}
