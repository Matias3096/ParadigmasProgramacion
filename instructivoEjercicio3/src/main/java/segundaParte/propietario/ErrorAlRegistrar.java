package segundaParte.propietario;


/*
Excepcion simple perdida en el TP. Se lanza cuando un servidor intenta registrar mas de 2 proyectos.
 */
public class ErrorAlRegistrar extends Exception {
    public ErrorAlRegistrar(String msg) {
        super(msg);
    }
}
