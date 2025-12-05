package segundaParte.main;

import segundaParte.propietario.ErrorAlRegistrar;
import segundaParte.propietario.Proyecto;
import segundaParte.servidores.ServidorWindows;

public class MainServidores {
    public static void main(String[] args) {

        //crear servidor
        ServidorWindows sw = new ServidorWindows("8GB","500GB","i5 11th", 10,256.00);

        //Crear proyectos
        Proyecto p1 = new Proyecto("Sistema ventas", "Carrefour");
        Proyecto p2 = new Proyecto("Sistema turnos", "Banco Nacion");
        Proyecto p3 = new Proyecto("Sistema stock", "YPF");

        try {
            sw.Registrar(p1);
            sw.Registrar(p2);

            //este fallara por regla del tp
            sw.Registrar(p3);
        } catch (ErrorAlRegistrar e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        //Mostrar estado final
        sw.MostrarProyectos();
        p1.Registrados();
    }
}
