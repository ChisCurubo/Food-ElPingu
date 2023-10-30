package co.edu.upb.Pantallas.Domicilio;

import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
/**
 *@author ChristianRodriguez
 */

public class MenuDomi extends JFrame {
    public static void main(String[] args) throws IOException {
        ModeloLogin modelo = new ModeloLogin();
        MenuDomi men = new MenuDomi();
    }
    public MenuDomi() {
        initOperator();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initOperator(){
        setTitle("Inicio Domi");
        setBounds(0, 0, 1500, 1000);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0,0,1500,1000);
        panelFondo.setBackground(new Color(64,93,128));
        setContentPane(panelFondo);
        setLayout(null);

        JLabel label = new JLabel("Bienvenido Domiciliario");
        label.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 50));
        label.setForeground(Color.WHITE);
        label.setBounds(500, 50, 500, 100);
        panelFondo.add(label);

        JButton botonRap1 = new JButton("Entregramé");
        botonRap1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap1.setBounds(450, 300, 500, 250);
        botonRap1.setBackground(new Color(110,149,0));
        botonRap1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(ModeloLogin.DomicilioInterface.createGrafo()){
                        setVisible(false);
                        Domicilio domi = new Domicilio();
                        domi.setVisible(true);
                    }
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //recordar que cambie de color si esta en uso o no
        panelFondo.add(botonRap1);

    }
}
