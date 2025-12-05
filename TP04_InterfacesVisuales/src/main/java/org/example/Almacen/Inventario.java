package org.example.Almacen;

import org.example.Dispositivos.Impresora;

import java.io.*;
import java.util.ArrayList;

public class Inventario {

    private String marca;
    private ArrayList<Vehiculo> vehiculos;
    private File archivo;

    public Inventario (String marca){
        this.marca = marca;
        this.vehiculos = new ArrayList<>();
        this.archivo = new File("Inventario_" + marca + ".txt");
    }

    public String getMarca() {
        return marca;
    }
    public void agregar(Vehiculo v) {
        vehiculos.add(v);
        guardarAArchivo();
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void listar(Impresora impresora) {
        impresora.imprimir("Listado de inventario para marca: " + marca);
        for (Vehiculo v : vehiculos ) {
            impresora.imprimir(v.toString() + " -> precio final: $ " + v.calcularPrecio());
        }
    }

    //Guardar todos los vehiculos en el archivo(sobrescribe)
    public void guardarAArchivo(){
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo,false))) {
            for (Vehiculo v : vehiculos) {
                pw.println(v.toText());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //cargar desde archivo
    public void cargarDesdeArchivo(){
        if (!archivo.exists()) return;
        vehiculos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = br.readLine()) != null ){
                Vehiculo v = Vehiculo.fromText(linea);
                if (v != null) vehiculos.add(v);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
