package Bingo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyAppFrame extends JFrame {

    private JTextField numeroFacturaField;
    private JTextField nombreClienteField;
    private JTextField cedulaRUCField;
    private JTextField direccionField;
    private JTextField telefonoField;
    private JTextField fechaField;
    private DefaultTableModel tableModel;

    public MyAppFrame() {
        setTitle("My Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton nuevoClienteButton = new JButton("Nuevo Cliente");
        JButton limpiarButton = new JButton("Limpiar");

        nuevoClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Creando nuevo cliente...");
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreClienteField.setText("");
                cedulaRUCField.setText("");
                direccionField.setText("");
                telefonoField.setText("");
                fechaField.setText("");
            }
        });

        buttonsPanel.add(nuevoClienteButton);
        buttonsPanel.add(limpiarButton);

        JPanel numeroFacturaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        numeroFacturaPanel.add(new JLabel("Número de Factura: "));
        numeroFacturaField = new JTextField(10);
        numeroFacturaPanel.add(numeroFacturaField);

        JPanel clienteFechaPanel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        nombreClienteField = new JTextField(10);
        cedulaRUCField = new JTextField(10);
        direccionField = new JTextField(10);
        telefonoField = new JTextField(10);
        fechaField = new JTextField(10);

        clienteFechaPanel.add(new JLabel("Nombre: "), gbc);
        gbc.gridx = 1;
        clienteFechaPanel.add(nombreClienteField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        clienteFechaPanel.add(new JLabel("Cédula/RUC: "), gbc);
        gbc.gridx = 1;
        clienteFechaPanel.add(cedulaRUCField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        clienteFechaPanel.add(new JLabel("Dirección: "), gbc);
        gbc.gridx = 1;
        clienteFechaPanel.add(direccionField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        clienteFechaPanel.add(new JLabel("Teléfono: "), gbc);
        gbc.gridx = 1;
        clienteFechaPanel.add(telefonoField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        clienteFechaPanel.add(new JLabel("Fecha: "), gbc);
        gbc.gridx = 1;
        clienteFechaPanel.add(fechaField, gbc);

        JTextField ivaField = new JTextField(String.valueOf(new Random().nextInt(50) + 1), 10);
        JTextField totalField = new JTextField(String.valueOf(new Random().nextInt(50) + 1), 10);
        ivaField.setEditable(false);
        totalField.setEditable(false);

        JButton buscarClienteButton = new JButton("Buscar Cliente");
        buscarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarClienteEnTabla(nombreClienteField.getText());
            }
        });

        JButton anadirButton = new JButton("Añadir");
        anadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirProductoAleatorio();
            }
        });

        JButton quitarButton = new JButton("Quitar");
        quitarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitarProductoSeleccionado();
            }
        });

        String[] columnNames = {"Código", "Detalle", "Precio", "Cantidad", "IVA", "Total IVA", "Total"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel calculoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JTextField subtotalField = new JTextField(10);
        subtotalField.setEditable(false);

        JButton realizarPagoButton = new JButton("Realizar Pago");
        realizarPagoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pago Realizado");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(buttonsPanel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(numeroFacturaPanel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(clienteFechaPanel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(buscarClienteButton, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        mainPanel.add(anadirButton, gbc);
        gbc.gridx = 3;
        gbc.gridy = 2;
        mainPanel.add(quitarButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        mainPanel.add(scrollPane, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        mainPanel.add(calculoPanel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        mainPanel.add(subtotalField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        mainPanel.add(realizarPagoButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(new JLabel("IVA: "), gbc);
        gbc.gridx = 1;
        mainPanel.add(ivaField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 8;
        mainPanel.add(new JLabel("Total: "), gbc);
        gbc.gridx = 1;
        mainPanel.add(totalField, gbc);

        add(mainPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void buscarClienteEnTabla(String nombreCliente) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(nombreCliente)) {
                JTable table = new JTable(tableModel);
                table.setRowSelectionInterval(i, i);
                table.scrollRectToVisible(table.getCellRect(i, 0, true));
                return;
            }
        }
        System.out.println("Cliente no encontrado en la tabla.");
    }

    private void añadirProductoAleatorio() {
        Random random = new Random();
        String codigo = String.valueOf(random.nextInt(1000));
        String detalle = "Producto" + codigo;
        double precio = 64.20082026331009;
        int cantidad = random.nextInt(5) + 1;
        double iva = 2.0;
        double totalIva = iva * cantidad;
        double total = precio * cantidad + totalIva;

        Object[] rowData = {codigo, detalle, precio, cantidad, iva, totalIva, total};
        tableModel.addRow(rowData);
    }

    private void quitarProductoSeleccionado() {
        int selectedRow = tableModel.getRowCount();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyAppFrame();
            }
        });
    }
}
