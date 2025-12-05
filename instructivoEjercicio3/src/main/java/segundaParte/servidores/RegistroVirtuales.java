package segundaParte.servidores;

import segundaParte.propietario.Proyecto;

public class RegistroVirtuales {
    private ServidorWindows servidor;
    private Proyecto proyecto;

    //El constructor registra automaticamente el nuevo vinculo en el Hashtable del proyecto
    public RegistroVirtuales(ServidorWindows servidor, Proyecto proyecto) {
        this.servidor = servidor;
        this.proyecto = proyecto;

        //Asociar en el proyecto: clave-> codigo del servidor, valor-> este registro
        proyecto.getRegistros().put(servidor.getCodigo(), this);
    }

    public ServidorWindows getServidor() {
        return servidor;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    // metodo que responde si un proyecto esta registrado en un ServidorWindows
    public static boolean EstaRegistrado(ServidorWindows s, Proyecto p) {
        return p.getRegistros().containsKey(s.getCodigo());
    }

}
