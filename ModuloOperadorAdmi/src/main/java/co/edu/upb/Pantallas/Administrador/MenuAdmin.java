package co.edu.upb.Pantallas.Administrador;

import co.edu.upb.Pantallas.Operador.AddCliente;
import co.edu.upb.Pantallas.Operador.AddPedido;
import co.edu.upb.Pantallas.Operador.EditClient;
import co.edu.upb.Pantallas.Operador.EditPedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmin extends JFrame {
    public static void main(String[] args) {
        MenuAdmin men = new MenuAdmin();
    }
    public MenuAdmin() {
        initOperator();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\logo (Pequeño).jpg").getImage());
    }

    public void initOperator(){
        setTitle("Inicio Operador");
        setBounds(0, 0, 1500, 1000);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0,0,1500,1000);
        panelFondo.setBackground(new Color(64,93,128));
        setContentPane(panelFondo);
        setLayout(null);

        JLabel label = new JLabel("Bienvenido Admin");
        label.setFont(new Font("Times News Roman", 1, 50));
        label.setForeground(Color.WHITE);
        label.setBounds(500, 50, 600, 100);
        panelFondo.add(label);

        JButton botonRap1 = new JButton("Add Clientes");
        botonRap1.setFont(new Font("Arial", 1, 20));
        botonRap1.setBounds(400, 200, 300, 150);
        botonRap1.setForeground(Color.WHITE);
        botonRap1.setBackground(new Color(110,149,0));
        botonRap1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddCliente pedi = new AddCliente();
                pedi.setVisible(true);
            }
        });
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(botonRap1);

        JButton botonRap2 = new JButton("Add Pedidos");
        botonRap2.setFont(new Font("Arial",1, 20));
        botonRap2.setBounds(750, 200, 300, 150);
        botonRap2.setForeground(Color.WHITE);
        botonRap2.setBackground((new Color(110,149,0)));
        botonRap2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddPedido pedi = new AddPedido();
                pedi.setVisible(true);
            }
        });
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(botonRap2);

        JButton botonRap3 = new JButton("Update Clientes");
        botonRap3.setFont(new Font("Arial",1, 20));
        botonRap3.setForeground(Color.WHITE);
        botonRap3.setBounds(400, 400, 300, 150);
        botonRap3.setBackground((new Color(110,149,0)));
        botonRap3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                EditClient pedi = new EditClient();
                pedi.setVisible(true);
            }
        });
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(botonRap3);

        JButton botonRap4 = new JButton("Update Pedido");
        botonRap4.setFont(new Font("Arial", 1, 20));
        botonRap4.setBounds(750, 400, 300, 150);
        botonRap4.setForeground(Color.WHITE);
        botonRap4.setBackground((new Color(110,149,0)));
        botonRap4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                EditPedido edit = new EditPedido();
                edit.setVisible(true);
            }
        });
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(botonRap4);

        JButton butonAddUser = new JButton("Add User");
        butonAddUser.setFont(new Font("Arial", 1, 20));
        butonAddUser.setForeground(Color.WHITE);
        butonAddUser.setBounds(50, 200, 300, 150);
        butonAddUser.setBackground((new Color(110,149,0)));
        butonAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AñadirUsuario adUser = new AñadirUsuario();
                adUser.setVisible(true);
            }
        });;
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(butonAddUser);

        JButton butonEditUser = new JButton("Edit User");
        butonEditUser.setFont(new Font("Arial", 1, 20));
        butonEditUser.setForeground(Color.WHITE);
        butonEditUser.setBounds(50, 400, 300, 150);
        butonEditUser.setBackground((new Color(110,149,0)));
        butonEditUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                EditarUsuario editarUsuario = new EditarUsuario();
                editarUsuario.setVisible(true);
            }
        });
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(butonEditUser);

        JButton butonAddProduct = new JButton("Add Producto");
        butonAddProduct.setFont(new Font("Arial", 1, 20));
        butonAddProduct.setForeground(Color.WHITE);
        butonAddProduct.setBounds(1100, 200, 300, 150);
        butonAddProduct.setBackground((new Color(110,149,0)));
        butonAddProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddProduct adPring = new AddProduct();
                adPring.setVisible(true);
            }
        });
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(butonAddProduct);

        JButton butonEditProduct = new JButton("Edit Producto");
        butonEditProduct.setFont(new Font("Arial", 1, 20));
        butonEditProduct.setForeground(Color.WHITE);
        butonEditProduct.setBounds(1100, 400, 300, 150);
        butonEditProduct.setBackground((new Color(110,149,0)));
        butonEditProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                EditProduct pro = new EditProduct();
                pro.setVisible(true);
            }
        });
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(butonEditProduct);

        JButton butonAdminDB = new JButton("Admin DB");
        butonAdminDB.setFont(new Font("Arial", 1, 20));
        butonAdminDB.setForeground(Color.WHITE);
        butonAdminDB.setBounds(575, 600, 300, 150);
        butonAdminDB.setBackground((new Color(110,149,0)));
        butonAdminDB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminDb admiDb = new AdminDb();
                admiDb.setVisible(true);
            }
        });
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(butonAdminDB);
    }
}
