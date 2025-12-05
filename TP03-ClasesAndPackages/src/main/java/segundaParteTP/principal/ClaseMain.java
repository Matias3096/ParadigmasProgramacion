package segundaParteTP.principal;

import segundaParteTP.componentes.Motor;
import segundaParteTP.componentes.Rueda;
import segundaParteTP.vehiculos.Auto;
import segundaParteTP.vehiculos.Camion;

public class ClaseMain {
    public static void main(String[] args) {
        Fabrica f = new Fabrica();

        //componentes comunes
        Motor m1 = new Motor("MOT-001");
        Motor m2 = new Motor("MOT-002");

        Rueda[] ruedasAuto ={
                new Rueda("Pirelli"),
                new Rueda("Pirelli"),
                new Rueda("Pirelli"),
                new Rueda("Pirelli")
        };

        Rueda [] ruedasCamion = {
                new Rueda("Good Year"),
                new Rueda("Good Year"),
                new Rueda("Good Year"),
                new Rueda("Good Year"),
                new Rueda("Good Year"),
                new Rueda("Good Year")
        };

        //Crear vehiculos usando sobrecarga
        Auto a = f.crear("Toyota",18000,m1,ruedasAuto);
        Camion c = f.crear("Scania",2000,m2,ruedasCamion, true);

        //mostrar datos
        a.verDatos();
        c.verDatos();
    }
}
