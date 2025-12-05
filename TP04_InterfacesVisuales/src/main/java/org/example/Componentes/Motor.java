package org.example.Componentes;

public class Motor extends Componente {

    public static final String TIPO_NAFTA = "Nafta";
    public static final String TIPO_DIESEL = "Diesel";
    public static final String TIPO_ELECTRICO = "Electrico";

    public int cantCilindros;
    public int cilindrada; //en cc

    public Motor (float precio, int cantCilindros, int cilindrada) {
        super(precio);
        this.cantCilindros = cantCilindros;
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Motor[ num:  " + numero + ", precio: $" + precio + ",cant cil: " + cantCilindros + ", cc: " + cilindrada + "]";
    }

    public String toText(){
        return "MOTOR: " + numero + ";" +  precio + " ; " + cantCilindros + " ; " + cilindrada;
    }

    public static Motor fromText(String [] parts, int startIndex){

        float precio = Float.parseFloat(parts[startIndex + 2]);
        int cant = Integer.parseInt(parts[startIndex + 3]);
        int cc = Integer.parseInt(parts[startIndex + 4]);
        return new Motor(precio, cant, cc);

    }
}
