package primeraParte.miembros;

import primeraParte.asignaturas.Curso;

public class Profesor extends Persona {

    private Curso cursoDictado;

    public Profesor () {
        super();
    }

    public Profesor(String nombre){
        super(nombre);
    }

    public void dicta(Curso c){
        this.cursoDictado = c;
        c.setProfesor(this);
    }
    public Curso getCursoDictado() {
        return cursoDictado;
    }

    public void mostrarCursoQueDicta() {
        if (cursoDictado == null)
            System.out.println(nombre + "no dicta ningun curso actualmente.");
        else
            System.out.println(nombre + " dicta el curso: " + cursoDictado.getTitulo());

    }

}
