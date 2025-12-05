package org.primeraParte;

import org.primeraParte.asignaturas.Curso;
import org.primeraParte.asignaturas.ErrorInscripcion;
import org.primeraParte.asignaturas.Inscripcion;
import org.primeraParte.miembros.Estudiante;
import org.primeraParte.miembros.Profesor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //crear estudiantes
        Estudiante e1 = new Estudiante("Ana","Gomez");
        Estudiante e2 = new Estudiante("Juan","Peretti");
        Estudiante e3 = new Estudiante("Maria","Del Sol");

        //crear profesor
        Profesor p1 = new Profesor("Juan","Videla");

        //Crear cursos
        Curso cJava = new Curso("Programacion en java");
        Curso cAlgebra = new Curso("Algebra y gemotria");
        Curso cFisica = new Curso("Fisica");

        //Asociar profesor a un curso
        p1.dicta(cJava);

        //Inscribir estudiantes
        try {
            cJava.inscribir(e1);
            cAlgebra.inscribir(e1);
            cFisica.inscribir(e1);

            //Cuarto curso, deberia lanzar error
            Curso cExtra = new Curso("Sistemas Operativos");
            cExtra.inscribir(e1);
        }catch (ErrorInscripcion ex){
            System.out.println("Error: "+ex.getMessage());
        }

        //inscribir otros estudiantes
        try {
            cJava.inscribir(e2);
            cAlgebra.inscribir(e3);
        } catch (ErrorInscripcion ex) {
            System.out.println("Error: "+ex.getMessage());
        }

        //Mostrar inscriptos por curso

        System.out.println("** Inscriptos en programacion Java **");
        for (String s : cJava.inscriptos()){
            System.out.println(" - " + s);
        }

        System.out.println("Cantidad total: " + cJava.cantidadInscriptos());

        //Mostrar cursos por estudiante
        System.out.println("\n Cursos de " + e1.getNombreCompleto() + " : " + e1.mostrarNombresCursos());
        System.out.println("\n Cursos de " + e2.getNombreCompleto() + " : " + e2.mostrarNombresCursos());


        //Mostrar curso que dicta profesor
        System.out.println("\nProfesor:  " + p1.getNombreCompleto() + "dicta: "
        + p1.mostrarNombreCursoQueDicta());

        //probar metodo estatico
        boolean esta = Inscripcion.estaInscripto("Ana",cJava);
        System.out.println("\n ¿Ana esta incripta en Java? " + (esta ? "Si" : "No"));
    }
}