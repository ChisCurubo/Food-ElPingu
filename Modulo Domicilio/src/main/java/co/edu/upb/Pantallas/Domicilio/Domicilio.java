package co.edu.upb.Pantallas.Domicilio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Domicilio extends JFrame {
    public static void main(String[] args) {
        Domicilio men = new Domicilio();
    }
    public Domicilio() {
        initDomicilio();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initDomicilio(){
        setTitle("Domicilio");
        setBounds(0, 0, 1500, 1000);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0,0,1500,1000);
        panelFondo.setBackground(new Color(64,93,128));
        setContentPane(panelFondo);
        setLayout(null);

        JLabel label = new JLabel("Domicilio");
        label.setFont(new Font("Times New Roman", 1, 50));
        label.setForeground(Color.WHITE);
        label.setBounds(100, 30, 500, 100);
        panelFondo.add(label);

        JPanel panelMapa = new JPanel();
        panelMapa.setBounds(50,150,510,450);
        panelMapa.setBackground(new Color(110,149,0));
        panelMapa.setLayout(null);
        panelFondo.add(panelMapa);
        JLabel panelImage = new JLabel();
        panelImage.setBounds(5,5,500,440);
        ImageIcon image = new ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Modulo Domicilio\\src\\main\\java\\co\\edu\\upb\\Images\\Mapa (Personalizado).png");
        panelImage.setIcon(image);
        panelMapa.add(panelImage);

        JPanel panelInfo = new JPanel();
        panelInfo.setBounds(700,150,750,550);
        panelInfo.setBackground(new Color(110,149,0));
        panelInfo.setLayout(null);
        panelFondo.add(panelInfo);

        JLabel verCola = new JLabel("Ver Cola ");
        verCola.setFont(new Font("Arial", 1, 20));
        verCola.setForeground(Color.WHITE);
        verCola.setBounds(325, 10, 200, 30);
        panelInfo.add(verCola);

        JButton botonRegre = new JButton("Regresame");
        botonRegre.setForeground(Color.WHITE);
        botonRegre.setFont(new Font("Arial", 1, 20));
        botonRegre.setBounds(1250, 50, 150, 50);
        botonRegre.setBackground(new Color(153, 2, 68));
        botonRegre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MenuDomi dom =  new MenuDomi();
                dom.setVisible(true);
            }
        });
        panelFondo.add(botonRegre);

        JButton botonRap1 = new JButton("Entregramé");
        botonRap1.setForeground(Color.WHITE);
        botonRap1.setFont(new Font("Arial", 1, 20));
        botonRap1.setBounds(300, 625, 300, 150);
        botonRap1.setBackground(new Color(110,149,0));
        botonRap1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,  "Se ingreso el nuevo cliente");
            }
        });
        panelFondo.add(botonRap1);

    }
}
