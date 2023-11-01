package co.edu.upb.Server;

import co.edu.upb.domain.Clientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;

public class PatallaServer extends JFrame {
    public PatallaServer() {
        initOperatorAddClient();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\logo (Pequeño).jpg").getImage());
    }

    public void initOperatorAddClient() {
        setTitle("Deploy server :)");
        setBounds(0, 0, 700, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0, 0, 1500, 1000);
        panelFondo.setBackground(new Color(64, 93, 128));
        setContentPane(panelFondo);
        setLayout(null);

        JLabel labelTitulo = new JLabel("Deploy server ");
        labelTitulo.setForeground(Color.WHITE);
        labelTitulo.setFont(new Font("Times New Roman", 1, 50));
        labelTitulo.setBounds(70, 20, 400, 100);
        panelFondo.add(labelTitulo);



        JButton botonEnviar = new JButton("Deploy Server:)");
        botonEnviar.setBackground(new Color(110, 149, 0));
        botonEnviar.setForeground(Color.WHITE);
        botonEnviar.setFont(new Font("Times New Roman",1,30));
        botonEnviar.setBounds(150,150,400,300);
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Server server = new Server("10.152.164.114");
                try {
                    if(server.deployServices()){
                        JOptionPane.showMessageDialog(null, "Server on ");
                    }else{
                        JOptionPane.showMessageDialog(null, "Upsiii error");
                    }
                } catch (HeadlessException | IOException e1) {
                }
            }
        });
        panelFondo.add(botonEnviar);

    }
}
