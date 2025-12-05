package Servidores;

import java.util.ArrayList;
import Propietario.*;

public class ServidorWindows extends ServidorVirtual {
    
    private String Version;     
    private double EspacioLibre;     
    private ArrayList Registro = new ArrayList(); //Permite establecer la relación entre "ServidorWindows" y "RegistroVirtuales"

    public ServidorWindows(Integer Codigo, String Version,double EspacioLibre) {
      super(Codigo,"8 GB","200 GB","I7 1300Mhz"); //Se instancia la clase eredada "Servidor" 
      this.Version=Version; //"this" apunta al objeto activo por lo que this.Version hace referencia al atributo de "ServidorWindows", no al parametro "Version" del constructor
      this.EspacioLibre=EspacioLibre;
    }

    //Métodos get y set necesarios para esta clase.
    public String getVersion() {
        return Version;
    }
    public Integer getCodigo() {
        return Codigo;
    }

    public int getCantRegistros(){
        return Registro.size();
    }
    
    // El método "Registrar" registra un proyecto en un servidor virtual windows.
    public void Registrar(Proyecto P)  {

        //El constructor de "RegistroVirtuales" maneja excepciones por lo que al ser instanciada se debe manejar ocn una estructura try catch()
        try {  
          //Al crearse un objeto "RegistroVirtuales"  se establece la relación netre un "ServidorWindows" y un Proyecto"
          //Luego el objeto es agregado en el array Registro
          Registro.add( new RegistroVirtuales(this,P) ); 
        }
        catch (ErrorAlRegistrar e) {
          System.out.println(e.getMessage()); 
        }    
    }

    // El método “MostrarProyectos” muestra los proyectos en los que el Servidor Virtual está registrado.
    public void  MostrarProyectos() {    
        System.out.println("El Sistema Operativo version "+Version+" esta registrado en los siguientes Proyectos:");

        for (int i=0;i<Registro.size();i++)  {
            System.out.println(" "+((RegistroVirtuales) Registro.get(i)).getProyecto().getNombre());
        }

    }
}
