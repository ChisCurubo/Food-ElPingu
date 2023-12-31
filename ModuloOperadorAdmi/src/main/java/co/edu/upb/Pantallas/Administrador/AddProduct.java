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
        setIconImage(new ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\logo (Pequeño).jpg").getImage());
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

        JLabel labelNombreProducto = new JLabel("Nombre Producto: ");
        labelNombreProducto.setBounds(5,10,300,50);
        labelNombreProducto.setFont(new Font("Arial", 1, 25));
        labelNombreProducto.setForeground(Color.WHITE);
        panelPaneles.add(labelNombreProducto);

        JLabel labelNombreP = new JLabel(" ");
        labelNombreP.setBounds(5,70,300,50);
        labelNombreP.setFont(new Font("Arial", 1, 25));
        labelNombreP.setForeground(Color.WHITE);
        panelPaneles.add(labelNombreP);

        JLabel labelPrecioF = new JLabel("Precio Producto: ");
        labelPrecioF.setBounds(5,120,300,50);
        labelPrecioF.setFont(new Font("Arial", 1, 25));
        labelPrecioF.setForeground(Color.WHITE);
        panelPaneles.add(labelPrecioF);

        JLabel labelPrecioFil = new JLabel(" ");
        labelPrecioFil.setBounds(5,190,300,50);
        labelPrecioFil.setFont(new Font("Arial", 1, 25));
        labelPrecioFil.setForeground(Color.WHITE);
        panelPaneles.add(labelPrecioFil);

        JLabel cantLabel1 = new JLabel("Cant Producto: ");
        cantLabel1.setBounds(5,230,300,50);
        cantLabel1.setFont(new Font("Arial", 1, 25));
        cantLabel1.setForeground(Color.WHITE);
        panelPaneles.add(cantLabel1);

        JLabel cantLabel2 = new JLabel("");
        cantLabel2.setBounds(5,290,300,50);
        cantLabel2.setFont(new Font("Arial", 1, 25));
        cantLabel2.setForeground(Color.WHITE);
        panelPaneles.add(cantLabel2);

        JLabel tipoLabelD = new JLabel("Tipo de cocción Producto: ");
        tipoLabelD.setBounds(5,340,350,50);
        tipoLabelD.setFont(new Font("Arial", 1, 25));
        tipoLabelD.setForeground(Color.WHITE);
        panelPaneles.add(tipoLabelD);

        JLabel tipoLabe = new JLabel(" ");
        tipoLabe.setBounds(5,380,350,50);
        tipoLabe.setFont(new Font("Arial", 1, 25));
        tipoLabe.setForeground(Color.WHITE);
        panelPaneles.add(tipoLabe);



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
                labelPrecioFil.setText(precio);
                labelNombreP.setText(nombre);
                tipoLabe.setText(tipo);
                cantLabel2.setText(cant);

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

