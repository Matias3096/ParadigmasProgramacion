package primeraParte.miembros;

import primeraParte.asignaturas.Curso;
import primeraParte.asignaturas.ErrorInscripcion;
import primeraParte.asignaturas.Inscripcion;

public class Estudiante  extends Persona {

    public Estudiante() {
        super();
    }
    public Estudiante(String nombre) {
        super(nombre);
    }

    public void inscribir(Curso c) throws ErrorInscripcion {
        int cantidad = Inscripcion.contarInscripcionesDe(this);

        if (cantidad >= 3) {
            throw new ErrorInscripcion("El alumno " + nombre +
                    "ya tiene 3 cursos. No puede inscribirse en mas.");
        }
        Inscripcion ins = new Inscripcion(this, c);
        c.agregarInscripcion(ins);
    }

}
