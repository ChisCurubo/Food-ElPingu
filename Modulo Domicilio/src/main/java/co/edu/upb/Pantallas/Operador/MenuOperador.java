package co.edu.upb.Pantallas.Operador;

import javax.swing.*;
import java.awt.*;

public class MenuOperador extends JFrame {
    public static void main(String[] args) {
        MenuOperador men = new MenuOperador();
    }
    public MenuOperador() {
        initOperator();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(botonRap1);

        JButton botonRap2 = new JButton("Add Pedidos");
        botonRap2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap2.setBounds(800, 300, 300, 150);
        botonRap2.setBackground((new Color(110,149,0)));
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(botonRap2);

        JButton botonRap3 = new JButton("Update Clientes");
        botonRap3.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap3.setBounds(375, 500, 300, 150);
        botonRap3.setBackground((new Color(110,149,0)));
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(botonRap3);

        JButton botonRap4 = new JButton("Update Pedido");
        botonRap4.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap4.setBounds(725, 500, 300, 150);
        botonRap4.setBackground((new Color(110,149,0)));
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(botonRap4);
    }
}
