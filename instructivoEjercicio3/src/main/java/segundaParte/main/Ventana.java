package segundaParte.main;
import segundaParte.propietario.Proyecto;
import segundaParte.servidores.RegistroVirtuales;
import segundaParte.servidores.ServidorWindows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Ventana extends JFrame {

    // Contenedores locales, igual que el modelo del profesor
    private ArrayList<Proyecto> proyectos;
    private ArrayList<ServidorWindows> servidores;

    // Componentes de la interfaz
    private JTextField txtProyectoNombre;
    private JTextField txtProyectoCliente;
    private JButton btnAltaProyecto;

    private JTextField txtServidorVersion;
    private JTextField txtServidorEspacio;
    private JButton btnAltaServidor;

    private JTextField txtRegCodigoProyecto;
    private JTextField txtRegCodigoServidor;
    private JButton btnRegistrar;

    private JTextField txtMostrarCodigoProyecto;
    private JButton btnMostrar;
    private JTextArea areaListado;

    public Ventana() {
        super("Registro de Servidores – IntelliJ Edition");

        proyectos = new ArrayList<>();
        servidores = new ArrayList<>();

        setLayout(new GridLayout(1, 3));

        // Panel de proyectos
        JPanel panelProyecto = new JPanel(new GridLayout(6, 1));
        panelProyecto.setBorder(BorderFactory.createTitledBorder("Proyecto"));

        txtProyectoNombre = new JTextField();
        txtProyectoCliente = new JTextField();
        btnAltaProyecto = new JButton("Dar de Alta");

        panelProyecto.add(new JLabel("Nombre:"));
        panelProyecto.add(txtProyectoNombre);
        panelProyecto.add(new JLabel("Cliente:"));
        panelProyecto.add(txtProyectoCliente);
        panelProyecto.add(btnAltaProyecto);


        // Acción alta proyecto
        btnAltaProyecto.addActionListener(e -> {
            Proyecto p = new Proyecto(txtProyectoNombre.getText(), txtProyectoCliente.getText());
            proyectos.add(p);
            JOptionPane.showMessageDialog(this, "Proyecto creado con código: " + p.getCodigo());
        });


        // Panel Servidor Windows
        JPanel panelServidor = new JPanel(new GridLayout(6, 1));
        panelServidor.setBorder(BorderFactory.createTitledBorder("Servidor Windows"));

        txtServidorVersion = new JTextField();
        txtServidorEspacio = new JTextField();
        btnAltaServidor = new JButton("Dar de Alta");

        panelServidor.add(new JLabel("Versión:"));
        panelServidor.add(txtServidorVersion);
        panelServidor.add(new JLabel("Espacio Libre (MB):"));
        panelServidor.add(txtServidorEspacio);
        panelServidor.add(btnAltaServidor);

        // Acción alta servidor
        btnAltaServidor.addActionListener(e -> {
            try {
                ServidorWindows sw = new ServidorWindows("RAM", "DISCO", "CPU",
                        Integer.parseInt(txtServidorVersion.getText()),
                        Double.parseDouble(txtServidorEspacio.getText()));
                servidores.add(sw);
                JOptionPane.showMessageDialog(this,
                        "Servidor creado con código: " + sw.getCodigo());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        // Panel Registro
        JPanel panelRegistro = new JPanel(new GridLayout(12, 1));
        panelRegistro.setBorder(BorderFactory.createTitledBorder("Registrar"));

        txtRegCodigoProyecto = new JTextField();
        txtRegCodigoServidor = new JTextField();
        btnRegistrar = new JButton("Registrar Servidor al Proyecto");

        panelRegistro.add(new JLabel("Código Proyecto:"));
        panelRegistro.add(txtRegCodigoProyecto);
        panelRegistro.add(new JLabel("Código Servidor:"));
        panelRegistro.add(txtRegCodigoServidor);
        panelRegistro.add(btnRegistrar);

        // Acción Registrar
        btnRegistrar.addActionListener(e -> {
            try {
                int codP = Integer.parseInt(txtRegCodigoProyecto.getText());
                int codS = Integer.parseInt(txtRegCodigoServidor.getText());

                Proyecto encontrado = null;
                ServidorWindows swEncontrado = null;

                for (Proyecto p : proyectos)
                    if (p.getCodigo() == codP) encontrado = p;

                for (ServidorWindows s : servidores)
                    if (s.getCodigo() == codS) swEncontrado = s;

                if (encontrado == null || swEncontrado == null) {
                    JOptionPane.showMessageDialog(this, "Proyecto o Servidor inexistente");
                    return;
                }

                swEncontrado.Registrar(encontrado);
                JOptionPane.showMessageDialog(this, "Registrado con éxito");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Error al registrar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        // Área de listado
        txtMostrarCodigoProyecto = new JTextField();
        btnMostrar = new JButton("Mostrar Registros");
        areaListado = new JTextArea();
        areaListado.setEditable(false);

        panelRegistro.add(new JLabel("Mostrar registros de Proyecto Código:"));
        panelRegistro.add(txtMostrarCodigoProyecto);
        panelRegistro.add(btnMostrar);
        panelRegistro.add(new JScrollPane(areaListado));

        btnMostrar.addActionListener(e -> {
            try {
                int cod = Integer.parseInt(txtMostrarCodigoProyecto.getText());
                Proyecto encontrado = null;

                for (Proyecto p : proyectos)
                    if (p.getCodigo() == cod) encontrado = p;

                if (encontrado == null) {
                    JOptionPane.showMessageDialog(this, "Proyecto no encontrado");
                    return;
                }

                areaListado.setText("");
                for (RegistroVirtuales rv : encontrado.getRegistros().values()) {
                    areaListado.append("Servidor código: " + rv.getServidor().getCodigo() + "\n");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        add(panelProyecto);
        add(panelServidor);
        add(panelRegistro);

        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
