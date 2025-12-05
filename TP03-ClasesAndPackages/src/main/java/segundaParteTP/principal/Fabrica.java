package segundaParteTP.principal;

import segundaParteTP.componentes.Motor;
import segundaParteTP.componentes.Rueda;
import segundaParteTP.vehiculos.Auto;
import segundaParteTP.vehiculos.Camion;

public class Fabrica {

    //Crear auto
    public Auto crear(String fabricante, double precio, Motor motor, Rueda[] ruedas){
        return new Auto(fabricante, precio, motor, ruedas);
    }

    //Crear Camion (SOBRECARGA)
    public Camion crear(String fabricante, double precio, Motor motor, Rueda[] ruedas, boolean esCamion){
        return  new Camion(fabricante, precio, motor, ruedas);
    }
}
