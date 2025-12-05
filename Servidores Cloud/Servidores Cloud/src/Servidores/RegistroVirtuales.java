package Servidores;

import Propietario.*;
import java.util.Enumeration;

public class RegistroVirtuales {
    
    private ServidorWindows Servidor;
    private Proyecto Proy;

    //Al instancear un objeto "RegistroVirtuales" se establece la asociación entre ServidorWindows y Proyecto 
    public  RegistroVirtuales(ServidorWindows Servidor,Proyecto Proy) throws ErrorAlRegistrar //El constructor maneja la excepción "ErrorAlRegistrar"
    {
     // Si se intenta registrar más de dos proyectos al mismo servidor virtual se dispará una excepción  
     if (Servidor.getCantRegistros()>=2) 
         throw new ErrorAlRegistrar("El servidor Nº "+Servidor.getCodigo()+" ya alcanzó la cantidad máxima de registros.");            
     
     this.Servidor=Servidor; //"this" apunta al objeto activo por lo que this.Servidor hace referencia al atributo de "RegistroVirtuales", no al parametro "Servidor" del constructor
     this.Proy=Proy;

     //Agrega un "RegistroVirtuales" al contenedor Hastable de la clase "Proyecto"
     this.Proy.put(this.Servidor.getCodigo(),this); //Al colocar this referenciamos el objeto "RegistroVirtuales" activo, el cual es agreado al Hashtable.
    }
    
    // El método "EstaRegistrado" es un método de clase,  recibe como argumento un “ServidorWindows” y un “Proyecto” 
    // retorna true o false acorde a si está registrado o no el proyecto en el servidor.
    static public boolean EstaRegistrado(ServidorWindows estudiante,Proyecto Proy){

        Enumeration enumeration = Proy.elements(); //Es necesario instanciar la enumeración para poder recorrer los elementos
        RegistroVirtuales i1;
        ServidorWindows e1;

        while ( enumeration.hasMoreElements() ) {
          i1=(RegistroVirtuales) enumeration. nextElement();
          e1=i1.getServidorWindows();
          if  (e1.getCodigo().equals(estudiante.getCodigo()))
              return true;
        }
        return false;           

    }

    //Métodos get y set necesarios para esta clase.
    public ServidorWindows getServidorWindows() {
        return Servidor;
    }
    public Proyecto getProyecto() {
        return Proy;
    }

    
}
