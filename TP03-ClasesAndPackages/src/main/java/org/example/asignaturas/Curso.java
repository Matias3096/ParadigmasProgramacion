package org.example.asignaturas;

import org.example.miembros.Estudiante;
import org.example.miembros.Profesor;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Curso extends Hashtable<Integer, Inscripcion> {
    private String nombre;
    private Profesor profesor; // profesor que dicta curso

    public Curso(String nombre) {
        super();
        this.nombre = nombre;
        this.profesor = null;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Profesor getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    /*
    Inscribe a un estudiante en este curso.
    Reglas:
        Si el estudiante ya tiene 3 inscripciones (segun su objeto estudiante), lanza ErrorInscripcion.
        Si ya esta inscripto en este curso, no lo agrega de nuevo.
        Si puede inscribirse, crea la inscripcion, la agrega al Hashtable usando legajo como clave,
        y añade la inscripcion tambien en el objeto estudiante
     */

    public void inscribir(Estudiante e) throws  ErrorInscripcion {
        //Validacion: maximo 3 cursos por estudiante
        if (e.cantidadInscripciones() >= 3) {
            throw new ErrorInscripcion("El estudiante " + e.getNombreCompleto() + "Ya esta inscripto en 3 cursos.");
        }
        //Si ya esta inscripto en este curso segun legajo, no duplicamos
        if (this.containsKey(e.getLegajo())) {
            //Ya inscripto, podemos decidir no hacer nada o lanzar esxcepcion. Elegimos no duplicar
            return;
        }
        //Crear inscripcion y guardar
        Inscripcion insc = new Inscripcion(e, this);
        this.put(e.getLegajo(), insc);
        e.agregarInscripcion(insc);
    }
    //Devuelve la lista de inscriptos como strings(nombre completo + legajo)
    public List<String> inscriptos() {
        List<String> lista = new ArrayList<>();
        for (Inscripcion i : this.values()) {
            lista.add(i.getEstudiante().getNombreCompleto() + "(legajo: " + i.getEstudiante().getLegajo() + ")");
        }
        return lista;
    }

    //Metodo pedido: devuelve cantidad de inscriptos
    public int cantidadInscriptos() {

        return this.size();
    }
}
