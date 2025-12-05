package primeraParte;

import primeraParte.asignaturas.Curso;
import primeraParte.asignaturas.ErrorInscripcion;
import primeraParte.asignaturas.Inscripcion;
import primeraParte.miembros.Estudiante;
import primeraParte.miembros.Profesor;

public class MainPrimeraParte {

    public static void main(String[] args) {

        //Creando curso

        Curso c1  = new Curso("Matematica");
        Curso c2  = new Curso("Programacion");
        Curso c3 = new Curso("Sintaxis");
        Curso c4  = new Curso("Algebra");

        //Creando profesor
        Profesor prof = new Profesor();

        //Asignando un profesor a un curso
        prof.dicta(c1);

        //Creando estudiantes
        Estudiante e1 = new Estudiante("Juan");
        Estudiante e2 = new Estudiante("Maria");


        try {
            //Inscribiendo estudiantes
            e1.inscribir(c1);
            e1.inscribir(c2);
            e1.inscribir(c3);

            //este debe fallar
            e1.inscribir(c4);
        } catch (ErrorInscripcion ex ){
            System.out.println("ERROR: " + ex.getMessage());
        }

        try {
            e2.inscribir(c1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        c1.inscriptos();

        System.out.println("\n ¿Juan esta en matematica?" +
                Inscripcion.estaInscripto("Juan", c1));

    }
}
