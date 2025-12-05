package org.example.Componentes;

public class Carroceria extends Componente {

    public static final String TIPO_SEDAN = "Sedan";
    public static final String TIPO_HATCH = "Hatch";
    public static final String TIPO_SUV = "SUV";

    public String descripcion;
    public String color;

    public Carroceria(float precio,String descripcion, String color) {
        super(precio);
        this.descripcion = descripcion;
        this.color = color;
    }

    @Override
    public String toString(){
        return "Carroceria[num: " + numero + ", precio: $" + precio + ", descripcion: " + descripcion + ", color: " + color + "]";
    }

    public String toText(){
        return "CARROCERIA; " + numero + ";" + precio + ";" + descripcion + ";" + color;
    }

    public static Carroceria fromText(String[] parts, int startIndex){

        float precio = Float.parseFloat(parts[startIndex + 2]);
        String descripcion = parts[startIndex + 3];
        String color = parts[startIndex + 4];
        return new Carroceria(precio,descripcion,color);
    }

}
