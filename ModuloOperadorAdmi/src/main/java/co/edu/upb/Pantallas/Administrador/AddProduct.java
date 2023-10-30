package co.edu.upb.Pantallas.Administrador;

import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.Pantallas.Operador.AddCliente;
import co.edu.upb.Pantallas.Operador.AddPedido;
import co.edu.upb.Pantallas.Operador.EditClient;
import co.edu.upb.Pantallas.Operador.MenuOperador;
import co.edu.upb.domain.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
/**
 * Clase de interfaz grafica añadir prdducto
 *@author ChristianRodriguez
 */
public class AddProduct extends JFrame {
    public AddProduct() {
        initOperator();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("src/main/java/co/edu/upb/images/logo (Pequeño).jpg").getImage());
    }

    public void initOperator(){
        setTitle("Add Producto");
        setBounds(0, 0, 1500, 1000);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0,0,1500,1000);
        panelFondo.setBackground(new Color(64,93,128));
        setContentPane(panelFondo);
        setLayout(null);

        JLabel label = new JLabel("Añadir Producto");
        label.setFont(new Font("Times News Roman", 1, 50));
        label.setForeground(Color.WHITE);
        label.setBounds(50, 50, 600, 100);
        panelFondo.add(label);

        JPanel panelInfo = new JPanel();
        panelInfo.setBounds(900,125,500,600);
        panelInfo.setBackground(new Color(110,149,0));
        panelInfo.setLayout(null);
        panelFondo.add(panelInfo);

        JLabel labelNombreProduct = new JLabel("Nombre Producto: ");
        labelNombreProduct.setBounds(5,10,300,50);
        labelNombreProduct.setFont(new Font("Arial", 1, 25));
        labelNombreProduct.setForeground(Color.WHITE);
        panelInfo.add(labelNombreProduct);
        JTextField fieldNombre = new JTextField();
        fieldNombre.setBounds(30,70,400,50);
        fieldNombre.setFont(new Font("Arial", 0, 20));
        fieldNombre.setBackground(new Color(185, 180, 180));
        panelInfo.add(fieldNombre);

        JLabel labelPrecio = new JLabel("Precio Producto: ");
        labelPrecio.setBounds(5,120,300,50);
        labelPrecio.setFont(new Font("Arial", 1, 25));
        labelPrecio.setForeground(Color.WHITE);
        panelInfo.add(labelPrecio);
        JTextField fieldPrecio = new JTextField();
        fieldPrecio.setBounds(30,180,400,50);
        fieldPrecio.setFont(new Font("Arial", 0, 20));
        fieldPrecio.setBackground(new Color(185, 180, 180));
        panelInfo.add(fieldPrecio);

        JLabel cantLabel = new JLabel("Cant Producto: ");
        cantLabel.setBounds(5,230,300,50);
        cantLabel.setFont(new Font("Arial", 1, 25));
        cantLabel.setForeground(Color.WHITE);
        panelInfo.add(cantLabel);
        JTextField fieldCant = new JTextField();
        fieldCant.setBounds(30,290,400,50);
        fieldCant.setFont(new Font("Arial", 0, 20));
        fieldCant.setBackground(new Color(185, 180, 180));
        panelInfo.add(fieldCant);

        JLabel tipoLabel = new JLabel("Tipo de cocción Producto: ");
        tipoLabel.setBounds(5,340,350,50);
        tipoLabel.setFont(new Font("Arial", 1, 25));
        tipoLabel.setForeground(Color.WHITE);
        panelInfo.add(tipoLabel);
        JTextField tipoField = new JTextField();
        tipoField.setBounds(30,400,400,50);
        tipoField.setFont(new Font("Arial", 0, 20));
        tipoField.setBackground(new Color(185, 180, 180));
        panelInfo.add(tipoField);

        JPanel panelPaneles = new JPanel();
        panelPaneles.setBounds(50,200,700,450);
        panelPaneles.setBackground(new Color(110,149,0));
        panelPaneles.setLayout(null);
        panelFondo.add(panelPaneles);

        JButton botAddToPanel = new JButton();
        botAddToPanel.setText("Actualizar");
        botAddToPanel.setBackground(new Color(153, 2, 68));
        botAddToPanel.setBounds(150,500,200,50);
        botAddToPanel.setFont(new Font("Times News Roman", 1, 20));
        botAddToPanel.setForeground(Color.WHITE);
        botAddToPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = fieldNombre.getText();
                String precio = fieldPrecio.getText();
                String cant = fieldCant.getText();
                String tipo = tipoField.getText();

                Menu menu = new Menu(nombre,Integer.parseInt(cant),Integer.parseInt(tipo),Double.valueOf(precio));
                try {
                    if(ModeloLogin.clienteOperador.addProducto(menu)){
                        JOptionPane.showMessageDialog(null,  "Se ingreso el nuevo Producto");
                        //actualizar paneles
                        setVisible(false);
                        MenuAdmin men = new MenuAdmin();
                        men.setVisible(true);
                    }
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panelInfo.add(botAddToPanel);

        JButton botRegresar = new JButton("Regresate:)");
        botRegresar.setBackground(new Color(153, 2, 68));
        botRegresar.setForeground(Color.WHITE);
        botRegresar.setFont(new Font("Times New Roman", 1, 30));
        botRegresar.setBounds(100, 700, 200, 100);
        botRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MenuAdmin men = new MenuAdmin();
                men.setVisible(true);
            }
        });
        panelFondo.add(botRegresar);
    }

    }

