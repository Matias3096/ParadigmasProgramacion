package segundaParte.propietario;

import segundaParte.servidores.RegistroVirtuales;
import segundaParte.servidores.ServidorWindows;

import java.util.ArrayList;
import java.util.Hashtable;

public class Proyecto {

    private Integer codigo;
    private String nombre;
    private String nombreCliente;

    /*
    Contenedor Hashtable parametrizado. Solo acepta objetos RegistroVirtuales
    Clave = Codigo del servidor windows
     */

    private Hashtable<Integer, RegistroVirtuales> registros;

    /*
    Lista estatica: almacena todos los proyectos creados, se usa para permitir busquedas y recorridos
     */
    private static ArrayList<Proyecto> todos = new ArrayList();

    private static int contadorCodigos = 1;

    public Proyecto() {
        this.codigo = contadorCodigos++;
        this.registros = new Hashtable<>();
        todos.add(this);
    }

    public Proyecto(String nombre, String nombreCliente) {
        this.codigo = contadorCodigos++;
        this.nombre = nombre;
        this.nombreCliente = nombreCliente;
        this.registros = new Hashtable<>();
        todos.add(this);
    }
    public String getNombre() {
        return nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombreCliente(){
        return nombreCliente;
    }
    public Hashtable<Integer, RegistroVirtuales> getRegistros() {
        return registros;
    }

    //para obtener todos los proyectos existentes
    public  static ArrayList<Proyecto> getTodosLosProyectos(){
        return todos;
    }

    //Mostrar en pantalla los servidores donde este proyecto esta registrado
    public void Registrados() {
        System.out.println("\nServidores registrados para el proyecto" + nombre + ": ");

        if(registros.isEmpty()){
            System.out.println("No esta registrado en ningun servidor.");
            return;
        }
        for (RegistroVirtuales reg : registros.values()) {
            System.out.println(" -Servidor Windows codigo: " + reg.getServidor().getCodigo());
        }
    }

    /*
    Retorna cuantos servidores tiene este proyecto
     */
    public int getCantidadRegistrados(){
        return registros.size();
    }

    /*
    Metodo auxiliar usado por ServidorWindows para validar restricciones. Cuenta si este servidor ya tiene registro en este proyecto
     */
    public int getCantidadRegistradosPorServidor(ServidorWindows s) {
        if (registros.containsKey(s.getCodigo())){
            return 1;
        }
        return 0;
    }

    /*
    Metodo estatico auxiliar, que cuenta cuantos servidores tiene un proyecto dado
     */
    public static int contarServidoresDeProyecto(ServidorWindows s) {
        int total = 0;

        for (Proyecto p : todos) {
            if (p.registros.containsKey(s.getCodigo())){
                total++;
            }
        }
        return total;
    }




}

