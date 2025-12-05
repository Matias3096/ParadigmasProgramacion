package Main;

import Propietario.Proyecto;
import Servidores.ServidorWindows;
import Servidores.RegistroVirtuales;

public class Main {
    
   public static void main(String[] args) {
        
        //Se instancian de 4 proyectos
        Proyecto P1=new Proyecto(1,"Proyecto1","Cliente1");
        Proyecto P2=new Proyecto(2,"Proyecto2","Cliente1");
        Proyecto P3=new Proyecto(3,"Proyecto3","Cliente2");
        Proyecto P4=new Proyecto(4,"Proyecto4","Cliente2");

        //Se instancian  3 servidores windows
        ServidorWindows SW1=new ServidorWindows(1,"Wondows 7",90000);
        ServidorWindows SW2=new ServidorWindows(2,"Windows 2008",70000);
        ServidorWindows SW3=new ServidorWindows(3,"Windows 10",60000);

        //Se asocian proyectos con servidores virtuales windows
        SW1.Registrar(P1);
        SW1.Registrar(P2);
        SW2.Registrar(P1);
        SW2.Registrar(P2);
        SW3.Registrar(P1);

        //Muestra los servidores registrados en los proyecto P1 y P2
        P1.Registrados();
        P2.Registrados();
        
        //Muestra la cantidad de servidores registrados en en proyecto P2
        System.out.println("Servidores registrados en el proyecto "+P1.getNombre()+": "+P1.getCantidadRegistrados());

        //Muestra los proyectos de un servidor windows
        SW1.MostrarProyectos();

        //Muestra un mensaje acorde a si pertenece o no SW1 al proyecto P1.
        if (RegistroVirtuales.EstaRegistrado(SW1, P1)) 
          System.out.println("El servidor "+SW1.getVersion()+" esta registrado en el proyecto "+P1.getNombre()+"."); 
        else 
          System.out.println("El servidor "+SW1.getVersion()+" NO esta registrado en el proyecto "+P1.getNombre()+"."); 

        //Muestra el error que se produce al intentar registrar un servidor windows en mas de dos proyectos
        SW1.Registrar(P3);        
   
    }
    
}
