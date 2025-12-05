package UI;

import org.example.Almacen.Inventario;
import org.example.Almacen.Vehiculo;
import org.example.Componentes.Carroceria;
import org.example.Componentes.Motor;
import org.example.Dispositivos.Impresora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InterfazPrincipal extends JFrame {
    // Paneles y componentes visuales
    private JTextArea areaSalida;
    private JTextField tfMarcaInventario;

    // Campos Motor
    private JTextField tfPrecioMotor;
    private JTextField tfCantCil;
    private JTextField tfCilindrada;

    // Campos Carroceria
    private JTextField tfPrecioCarro;
    private JTextField tfDescCarro;
    private JTextField tfColorCarro;

    // Campos Vehiculo
    private JTextField tfPesoVeh;
    private JTextField tfPrecioVeh;

    // Radio buttons
    private JRadioButton rbMotor;
    private JRadioButton rbCarro;
    private JRadioButton rbVeh;

    private JButton btnCrearInventario;
    private JButton btnCrear;
    private JButton btnMostrar;
    private JButton btnListarInventario;

    // Lista de objetos creados (mostrará Motores, Carrocerias y Vehiculos)
    private DefaultListModel<Object> listModel;
    private JList<Object> listaObjetos;

    // Para seleccionar componentes al crear un Vehículo
    private JComboBox<Motor> comboMotores;
    private JComboBox<Carroceria> comboCarrocerias;

    // Datos del modelo
    private ArrayList<Motor> motores;            // componentes creados
    private ArrayList<Carroceria> carrocerias;   // componentes creados
    private Inventario inventario;               // inventario activo (por marca)

    public InterfazPrincipal() {
        super("TP04 - Interfaces Visuales - Interfaz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        init();
    }

    private void init() {
        motores = new ArrayList<>();
        carrocerias = new ArrayList<>();
        inventario = null;

        Container c = getContentPane();
        c.setLayout(new BorderLayout(8, 8));

        // ----- LEFT: controles -----
        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        // Inventario (marca)
        JPanel pInv = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pInv.add(new JLabel("Marca inventario:"));
        tfMarcaInventario = new JTextField(10);
        pInv.add(tfMarcaInventario);
        btnCrearInventario = new JButton("Crear/Cargar Inventario");
        pInv.add(btnCrearInventario);
        panelLeft.add(pInv);

        // Radios
        rbMotor = new JRadioButton("Motor");
        rbCarro = new JRadioButton("Carrocería");
        rbVeh = new JRadioButton("Vehículo");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMotor);
        bg.add(rbCarro);
        bg.add(rbVeh);

        JPanel pRad = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pRad.add(new JLabel("Crear:"));
        pRad.add(rbMotor);
        pRad.add(rbCarro);
        pRad.add(rbVeh);
        panelLeft.add(pRad);

        // --- Campos Motor
        tfPrecioMotor = new JTextField(8);
        tfCantCil = new JTextField(6);
        tfCilindrada = new JTextField(6);
        JPanel pMotor = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pMotor.setBorder(BorderFactory.createTitledBorder("Motor"));
        pMotor.add(new JLabel("Precio:"));
        pMotor.add(tfPrecioMotor);
        pMotor.add(new JLabel("Cilindros:"));
        pMotor.add(tfCantCil);
        pMotor.add(new JLabel("Cilindrada (cc):"));
        pMotor.add(tfCilindrada);
        panelLeft.add(pMotor);

        // --- Campos Carroceria
        tfPrecioCarro = new JTextField(8);
        tfDescCarro = new JTextField(10);
        tfColorCarro = new JTextField(8);
        JPanel pCarro = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pCarro.setBorder(BorderFactory.createTitledBorder("Carrocería"));
        pCarro.add(new JLabel("Precio:"));
        pCarro.add(tfPrecioCarro);
        pCarro.add(new JLabel("Descripción:"));
        pCarro.add(tfDescCarro);
        pCarro.add(new JLabel("Color:"));
        pCarro.add(tfColorCarro);
        panelLeft.add(pCarro);

        // --- Campos Vehiculo
        tfPesoVeh = new JTextField(6);
        tfPrecioVeh = new JTextField(8);
        comboMotores = new JComboBox<>();
        comboCarrocerias = new JComboBox<>();
        JPanel pVeh = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pVeh.setBorder(BorderFactory.createTitledBorder("Vehículo"));
        pVeh.add(new JLabel("Peso (kg):"));
        pVeh.add(tfPesoVeh);
        pVeh.add(new JLabel("Precio base:"));
        pVeh.add(tfPrecioVeh);
        pVeh.add(new JLabel("Motor:"));
        pVeh.add(comboMotores);
        pVeh.add(new JLabel("Carrocería:"));
        pVeh.add(comboCarrocerias);
        panelLeft.add(pVeh);

        // Botones crear/mostrar/listar inventario
        JPanel pBtns = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnCrear = new JButton("Crear");
        btnCrear.setEnabled(false);
        btnMostrar = new JButton("Mostrar detalle");
        btnMostrar.setEnabled(false);
        btnListarInventario = new JButton("Listar Inventario");
        btnListarInventario.setEnabled(false);
        pBtns.add(btnCrear);
        pBtns.add(btnMostrar);
        pBtns.add(btnListarInventario);
        panelLeft.add(pBtns);

        // Inicialmente todos los campos inhabilitados
        setCamposMotorEnabled(false);
        setCamposCarroEnabled(false);
        setCamposVehEnabled(false);

        // ----- CENTER: area de salida -----
        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        JScrollPane spArea = new JScrollPane(areaSalida);

        // ----- RIGHT: lista de objetos -----
        JPanel panelRight = new JPanel(new BorderLayout());
        panelRight.setBorder(BorderFactory.createTitledBorder("Objetos creados"));
        listModel = new DefaultListModel<>();
        listaObjetos = new JList<>(listModel);
        JScrollPane spList = new JScrollPane(listaObjetos);
        panelRight.add(spList, BorderLayout.CENTER);

        // Añadir a layout principal
        c.add(panelLeft, BorderLayout.WEST);
        c.add(spArea, BorderLayout.CENTER);
        c.add(panelRight, BorderLayout.EAST);

        // --- Listeners ---

        // Radios habilitan campos correspondientes
        rbMotor.addActionListener(e -> {
            boolean sel = rbMotor.isSelected();
            setCamposMotorEnabled(sel);
            setCamposCarroEnabled(false);
            setCamposVehEnabled(false);
            btnCrear.setEnabled(sel && inventario != null); // Inventario no es estrictamente necesario para crear componentes,
            // pero para mantener consistencia requerimos crear inventario primero (puedes quitar esta restricción si querés)
        });

        rbCarro.addActionListener(e -> {
            boolean sel = rbCarro.isSelected();
            setCamposCarroEnabled(sel);
            setCamposMotorEnabled(false);
            setCamposVehEnabled(false);
            btnCrear.setEnabled(sel && inventario != null);
        });

        rbVeh.addActionListener(e -> {
            boolean sel = rbVeh.isSelected();
            setCamposVehEnabled(sel);
            setCamposMotorEnabled(false);
            setCamposCarroEnabled(false);
            btnCrear.setEnabled(sel && inventario != null);
        });

        // Botón crear/cargar inventario
        btnCrearInventario.addActionListener(e -> {
            String marca = tfMarcaInventario.getText().trim();
            if (marca.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese la marca del inventario (ej: Toyota).");
                return;
            }
            inventario = new Inventario(marca);
            inventario.cargarDesdeArchivo();

            // Después de cargar, agregar vehículos cargados a la lista visual
            listModel.clear();
            for (Vehiculo v : inventario.getVehiculos()) {
                listModel.addElement(v);
            }

            appendSalida("Inventario creado/cargado para marca: " + marca);
            btnCrear.setEnabled(true);
            btnListarInventario.setEnabled(true);
        });

        // Botón crear objeto según radio seleccionado
        btnCrear.addActionListener(e -> {
            if (rbMotor.isSelected()) {
                crearMotor();
            } else if (rbCarro.isSelected()) {
                crearCarroceria();
            } else if (rbVeh.isSelected()) {
                crearVehiculo();
            }
        });

        // Habilitar Mostrar si hay selección
        listaObjetos.addListSelectionListener(e -> {
            btnMostrar.setEnabled(!listaObjetos.isSelectionEmpty());
        });

        btnMostrar.addActionListener(e -> {
            Object sel = listaObjetos.getSelectedValue();
            if (sel == null) return;
            mostrarDetalleObjeto(sel);
        });

        btnListarInventario.addActionListener(e -> {
            if (inventario == null) {
                appendSalida("No hay inventario cargado.");
                return;
            }
            Impresora imp = new Impresora(areaSalida);
            inventario.listar(imp);
        });
    }

    // Habilita/inhabilita campos Motor
    private void setCamposMotorEnabled(boolean en) {
        tfPrecioMotor.setEnabled(en);
        tfCantCil.setEnabled(en);
        tfCilindrada.setEnabled(en);
    }

    private void setCamposCarroEnabled(boolean en) {
        tfPrecioCarro.setEnabled(en);
        tfDescCarro.setEnabled(en);
        tfColorCarro.setEnabled(en);
    }

    private void setCamposVehEnabled(boolean en) {
        tfPesoVeh.setEnabled(en);
        tfPrecioVeh.setEnabled(en);
        comboMotores.setEnabled(en);
        comboCarrocerias.setEnabled(en);
    }

    // Crear Motor desde campos
    private void crearMotor() {
        try {
            float precio = Float.parseFloat(tfPrecioMotor.getText().trim());
            int cil = Integer.parseInt(tfCantCil.getText().trim());
            int cc = Integer.parseInt(tfCilindrada.getText().trim());
            Motor m = new Motor(precio, cil, cc);
            motores.add(m);
            listModel.addElement(m);

            // Añadir al combo si se usará para vehículos
            comboMotores.addItem(m);

            appendSalida("Motor creado: " + m.toString());

            // Limpiar e inhabilitar campos
            tfPrecioMotor.setText("");
            tfCantCil.setText("");
            tfCilindrada.setText("");
            rbMotor.setSelected(false);
            setCamposMotorEnabled(false);
            btnCrear.setEnabled(inventario != null);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Precio, cilindros y cilindrada deben ser números.");
        }
    }

    // Crear Carroceria
    private void crearCarroceria() {
        try {
            float precio = Float.parseFloat(tfPrecioCarro.getText().trim());
            String desc = tfDescCarro.getText().trim();
            String color = tfColorCarro.getText().trim();
            Carroceria c = new Carroceria(precio, desc, color);
            carrocerias.add(c);
            listModel.addElement(c);
            comboCarrocerias.addItem(c);

            appendSalida("Carrocería creada: " + c.toString());

            tfPrecioCarro.setText("");
            tfDescCarro.setText("");
            tfColorCarro.setText("");
            rbCarro.setSelected(false);
            setCamposCarroEnabled(false);
            btnCrear.setEnabled(inventario != null);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Precio debe ser un número.");
        }
    }

    // Crear Vehiculo usando motor y carroceria seleccionados
    private void crearVehiculo() {
        try {
            if (comboMotores.getItemCount() == 0 || comboCarrocerias.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Primero debe crear al menos un Motor y una Carrocería para asociarlos al Vehículo.");
                return;
            }
            int peso = Integer.parseInt(tfPesoVeh.getText().trim());
            float precio = Float.parseFloat(tfPrecioVeh.getText().trim());
            Motor mSel = (Motor) comboMotores.getSelectedItem();
            Carroceria cSel = (Carroceria) comboCarrocerias.getSelectedItem();

            if (mSel == null || cSel == null) {
                JOptionPane.showMessageDialog(this, "Seleccione un Motor y una Carrocería válidos.");
                return;
            }

            Vehiculo v = new Vehiculo(peso, precio, mSel, cSel);
            if (inventario == null) {
                JOptionPane.showMessageDialog(this, "Antes de crear Vehículos, cree o cargue un Inventario (marca).");
                return;
            }
            inventario.agregar(v);
            listModel.addElement(v);

            appendSalida("Vehículo creado y agregado al inventario: " + v.toString());

            tfPesoVeh.setText("");
            tfPrecioVeh.setText("");
            rbVeh.setSelected(false);
            setCamposVehEnabled(false);
            btnCrear.setEnabled(inventario != null);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Peso y precio deben ser números.");
        }
    }

    // Mostrar detalle de un objeto seleccionado
    private void mostrarDetalleObjeto(Object obj) {
        if (obj instanceof Motor) {
            Motor m = (Motor) obj;
            StringBuilder sb = new StringBuilder();
            sb.append("=== Motor ===\n");
            sb.append("Número: ").append(m.getNumero()).append("\n");
            sb.append("Precio: ").append(m.getPrecio()).append("\n");
            sb.append("Cilindros: ").append(m.cantCilindros).append("\n");
            sb.append("Cilindrada: ").append(m.cilindrada).append("\n");
            appendSalida(sb.toString());
        } else if (obj instanceof Carroceria) {
            Carroceria c = (Carroceria) obj;
            StringBuilder sb = new StringBuilder();
            sb.append("=== Carrocería ===\n");
            sb.append("Número: ").append(c.getNumero()).append("\n");
            sb.append("Precio: ").append(c.getPrecio()).append("\n");
            sb.append("Descripción: ").append(c.descripcion).append("\n");
            sb.append("Color: ").append(c.color).append("\n");
            appendSalida(sb.toString());
        } else if (obj instanceof Vehiculo) {
            Vehiculo v = (Vehiculo) obj;
            StringBuilder sb = new StringBuilder();
            sb.append("=== Vehículo ===\n");
            sb.append("ID: ").append(v.getId()).append("\n");
            sb.append("Peso: ").append(v.getPeso()).append(" kg\n");
            sb.append("Precio base: ").append(v.getPrecio()).append("\n");
            sb.append("Precio total (incluye componentes): ").append(v.calcularPrecio()).append("\n");
            sb.append("Motor: ").append(v.getMotor().toString()).append("\n");
            sb.append("Carrocería: ").append(v.getCarroceria().toString()).append("\n");
            appendSalida(sb.toString());
        } else {
            appendSalida("Tipo de objeto desconocido: " + obj.toString());
        }
    }

    // Helper para escribir en el área
    private void appendSalida(String texto) {
        areaSalida.append(texto + "\n");
    }
}
