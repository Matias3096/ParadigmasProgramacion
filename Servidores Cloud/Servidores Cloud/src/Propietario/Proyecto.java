package Propietario;

import java.util.Hashtable;
import Servidores.*;
import java.util.Enumeration;

// La clase proyecto implementa un contenedor HasTable usando como clave un Integer que representa el código del proyecto y solo acepta objetos "RegistroVirtuales" producto de la parametrización
public class Proyecto extends Hashtable <Integer, RegistroVirtuales>{
    
    private Integer Codigo;  //"Integer" hace referencia a la declaración de "Integer" del paquete "java.lang"
    private String Nombre;     
    private String NombreCliente; 

    public Proyecto(int Codigo, String Nombre, String NombreCliente)
    {
      this.Codigo=Codigo; //"this" apunta al objeto activo por lo que "this.Codigo" hace referencia al atributo de "Proyecto", no al parametro "Codigo" del constructor
      this.Nombre=Nombre;
      this.NombreCliente=NombreCliente;
    }   

    //El método "Registrados" muestra en pantalla la lista de proyectos registrados a un servidor virtual.
    public void  Registrados()
    {
        Enumeration enum1 = elements(); //Se usa el objeto enum1 para reccorre los elmentos de un Hashtable retornado por elements. 
                                        //"elements()" retorna los elemenos del Proyecto, es decir del hastable, instanciado.

        RegistroVirtuales i1;

        System.out.println("Registrados en el proyecto "+Nombre+" ("+getCantidadRegistrados()+"):"); 

        //Se recorren los elementos de la enumeración, extrayendo en cada iteración el objeto "RegistroVirtuales" cointenido en el hastable
        while (  enum1.hasMoreElements() ) {
            i1=(RegistroVirtuales) enum1.nextElement();
            System.out.println(" "+i1.getServidorWindows().getVersion());
        }   

    }
    //El método "getCantidadRegistrados" devuelve la cantidad de virtuales en las que se registró de un “Proyecto”
    public int getCantidadRegistrados()
    { 
        int CantidadRegistrados=0;
        Enumeration enum1 = elements(); ///Se usa el objeto enum1 para reccorrer los elmentos del Hashtable.

        while (  enum1.hasMoreElements() ) {

            enum1.nextElement();
            CantidadRegistrados++;

        }   
        return CantidadRegistrados;
    }

    //Métodos get y set necesarios para esta clase.
    public String getNombre() {
        return Nombre;
    }
    public Integer getCodigo() {
        return Codigo;
    }
   
}
