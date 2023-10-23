package co.edu.upb.Pantallas.Operador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Administra el acceso del usuario operador
 *@author ChristianRodriguez
 */
public class MenuOperador extends JFrame {
    public static void main(String[] args) {
        MenuOperador men = new MenuOperador();
    }
    public MenuOperador() {
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

        JLabel label = new JLabel("Bienvenido Operador");
        label.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 50));
        label.setForeground(Color.WHITE);
        label.setBounds(500, 50, 500, 100);
        panelFondo.add(label);

        JButton botonRap1 = new JButton("Add Clientes");
        botonRap1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap1.setBounds(300, 300, 300, 150);
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
        botonRap2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap2.setBounds(800, 300, 300, 150);
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
        botonRap3.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap3.setBounds(375, 500, 300, 150);
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
        botonRap4.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap4.setBounds(725, 500, 300, 150);
        botonRap4.setBackground((new Color(110,149,0)));
        botonRap4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                EditPedido pedi = new EditPedido();

                pedi.setVisible(true);
            }
        });
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(botonRap4);
    }
}
