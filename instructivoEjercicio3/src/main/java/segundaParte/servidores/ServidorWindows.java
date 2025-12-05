package segundaParte.servidores;

import segundaParte.propietario.ErrorAlRegistrar;
import segundaParte.propietario.Proyecto;

public class ServidorWindows extends ServidorVirtual{
     private Integer version;
     private double espacioLibre;

     /*
     Cada servidor puede tener multiples registros.
     Segun el tp, un servidorWindows SOLO PUEDE registrar hasta 2 proyectos.
     Ese control se hace al registrar

     Imp:
        El servidorWindows NO guarda una lista propia de registros
        Los registros se guardan en cada proyecto( en su Hashtable)

        En el diagrama la multiplicidad de RegistroVirtuales esta del
        lado del proyecto, no del servidor.
        Por eso, el servidorWindows solo ejecuta acciones, pero no almacena nada
      */

    //Constructor vacio como lo pide el diagrama
    public ServidorWindows() {
        super(); //asigna el codigo autogenerado del servidor virtual
    }

    //Constructor completo
    public ServidorWindows(String RAM, String DISCO, String CPU, Integer version, double espacioLibre) {
        super(RAM, DISCO, CPU);
        this.version = version;
        this.espacioLibre = espacioLibre;
    }

    //metodos get/set
    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
    public double getEspacioLibre() {
        return espacioLibre;
    }
    public void setEspacioLibre(double espacioLibre) {
        this.espacioLibre = espacioLibre;
    }
    /*
    Metodo registrar: asocia un proyecto a este servidor windows

    Regla: un servidorWindows NO puede registrar mas de 2 proyectos,
    si lo intenta, lanza ErrorAlRegistrar

    El ServidorWindows no almacena los registros. Lo hace la clase proyecto dentro de su HashTable
     */
    public void Registrar(Proyecto p) throws ErrorAlRegistrar {
        //Si el proyecto ya esta registrado en este servidor-> ERROR
        if (RegistroVirtuales.EstaRegistrado(this, p)) {
            throw new ErrorAlRegistrar("El proyecto ya esta registrado en este servidor. ");
        }

        //Si este servidor ya registro 2 proyectos -> error
        if (p.getCantidadRegistradosPorServidor(this) >= 1 &&
        Proyecto.contarServidoresDeProyecto(this) >=2) {

            throw new ErrorAlRegistrar("No se pueden registrar mas de 2 proyectos en el mismo servidor.");

        }

        //Crea el registro
        new RegistroVirtuales(this, p);
    }

    /*
    Mostrar proyectos muestra en pantalla todos los proyectos registrados para este servidor
    Este metodo NO accede directamente a los registros porque estos estan almacenados dentro de cada proyecto.
    De esta manera recorremos todos los proyectos creados (lista estatica)
     */
    public void MostrarProyectos() {
        System.out.println("\n Proyectos registrados en el Servidor Windows codig: " + this.codigo);

        boolean hay = false;

        for (Proyecto p : Proyecto.getTodosLosProyectos()) {
            if (RegistroVirtuales.EstaRegistrado(this, p)){
                System.out.println(" _ Proyecto: " + p.getNombre() +
                        "(Codigo " + p.getCodigo() + ")");

                hay = true;
            }

            if (!hay) {
                System.out.println("No hay proyectos registrados en este servidor.");
            }
        }
    }

}
