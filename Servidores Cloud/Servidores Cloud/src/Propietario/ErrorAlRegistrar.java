package Propietario;

public class ErrorAlRegistrar extends Exception {
    //Esta clase implementa una nueva "Exception" que al ser instanceada en el constructor de la clase “RegistroVirtuales” muestra un mensaje de error.

    public ErrorAlRegistrar(String s){
        super("No es posible realizar el registro. " + s);

    }
    
}
