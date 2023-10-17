package co.edu.upb.Pantallas.Domicilio;

import javax.swing.*;
import java.awt.*;

public class RestauranteFactura extends JFrame {
    public RestauranteFactura() {
        setTitle("Factura del Restaurante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        // Encabezado de la factura
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel headerLabel = new JLabel("Restaurante EL Pingü");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        // Detalles de la factura (puede usar una tabla JTable aquí)
        JPanel detailsPanel = new JPanel(new BorderLayout());
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JTextArea detailsTextArea = new JTextArea();
        detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsTextArea.setText("Producto 1: $10.00\nProducto 2: $15.00\nTotal: $25.00");
        detailsTextArea.setEditable(false);
        detailsPanel.add(detailsTextArea, BorderLayout.CENTER);

        // Botón de imprimir factura (opcional)
        JButton printButton = new JButton("Imprimir Factura");
        printButton.setFont(new Font("Arial", Font.PLAIN, 16));

        // Agrega componentes a la ventana
        add(headerPanel, BorderLayout.NORTH);
        add(detailsPanel, BorderLayout.CENTER);
        add(printButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RestauranteFactura factura = new RestauranteFactura();
            factura.setVisible(true);
        });
    }
}
