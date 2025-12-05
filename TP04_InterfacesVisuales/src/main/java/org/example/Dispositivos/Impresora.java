package org.example.Dispositivos;

import javax.swing.*;

public class Impresora {

    private JTextArea area;  //Si es null usamos consola

    public Impresora() {
        this.area = null;
    }

    public Impresora(JTextArea area) {
        this.area = area;
    }

    public void imprimir(String texto){
        if (area == null) {
            System.out.println(texto);
        } else {
            area.append(texto + "\n");
        }
    }
}
