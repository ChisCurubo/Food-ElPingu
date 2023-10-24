package co.edu.upb.Pantallas.Operador;

import javax.swing.*;
import java.awt.*;

public class AddCliente extends JFrame {
    

    public AddCliente() {
        initOperatorAddClient();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initOperatorAddClient() {
        setTitle("Add Client");
        setBounds(0, 0, 1500, 1000);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0, 0, 1500, 1000);
        panelFondo.setBackground(new Color(64, 93, 128));
        setContentPane(panelFondo);
        setLayout(null);

        JLabel labelTitulo = new JLabel("Añadir Cliente ");
        labelTitulo.setForeground(Color.WHITE);
        labelTitulo.setFont(new Font("Times New Roman", 1, 50));
        labelTitulo.setBounds(70, 20, 400, 100);
        panelFondo.add(labelTitulo);

        JLabel labelNombre = new JLabel("Nombre");
        labelNombre.setForeground(Color.WHITE);
        labelNombre.setFont(new Font("Arial", 1, 20));
        labelNombre.setBounds(100, 100, 200, 50);
        panelFondo.add(labelNombre);
        JTextField nombreField = new JTextField();
        nombreField.setBounds(70, 150, 600, 50);
        nombreField.setFont(new Font("Arial", 0, 20));
        nombreField.setBackground(new Color(185, 180, 180));
        nombreField.setColumns(1);
        panelFondo.add(nombreField);

        JLabel labelApellido = new JLabel("Apellido");
        labelApellido.setForeground(Color.WHITE);
        labelApellido.setFont(new Font("Arial", 1, 20));
        labelApellido.setBounds(870, 100, 200, 50);
        panelFondo.add(labelApellido);
        JTextField apellidoField = new JTextField();
        apellidoField.setBounds(850, 150, 600, 50);
        apellidoField.setFont(new Font("Arial", 0, 20));
        apellidoField.setBackground(new Color(185, 180, 180));
        apellidoField.setColumns(1);
        panelFondo.add(apellidoField);

        JLabel labelCorreo = new JLabel("Correo");
        labelCorreo.setForeground(Color.WHITE);
        labelCorreo.setFont(new Font("Arial", 1, 20));
        labelCorreo.setBounds(100, 220, 200, 50);
        panelFondo.add(labelCorreo);
        JTextField correoField = new JTextField();
        correoField.setBounds(70, 270, 600, 50);
        correoField.setFont(new Font("Arial", 0, 20));
        correoField.setBackground(new Color(185, 180, 180));
        correoField.setColumns(1);
        panelFondo.add(correoField);

        JLabel labelTelefono = new JLabel("Telefono");
        labelTelefono.setForeground(Color.WHITE);
        labelTelefono.setFont(new Font("Arial", 1, 20));
        labelTelefono.setBounds(870, 220, 200, 50);
        panelFondo.add(labelTelefono);
        JTextField TelefonoField = new JTextField();
        TelefonoField.setBounds(850, 270, 600, 50);
        TelefonoField.setFont(new Font("Arial", 0, 20));
        TelefonoField.setBackground(new Color(185, 180, 180));
        TelefonoField.setColumns(1);
        panelFondo.add(TelefonoField);

        JLabel labelMunicipio = new JLabel("Municipio");
        labelMunicipio.setForeground(Color.WHITE);
        labelMunicipio.setFont(new Font("Arial", 1, 20));
        labelMunicipio.setBounds(100, 350, 200, 50);
        panelFondo.add(labelMunicipio);
        JTextField MunicipioField = new JTextField();
        MunicipioField.setBounds(70, 400, 600, 50);
        MunicipioField.setFont(new Font("Arial", 0, 20));
        MunicipioField.setBackground(new Color(185, 180, 180));
        MunicipioField.setColumns(1);
        panelFondo.add(MunicipioField);

        JLabel labelComuna = new JLabel("Comuna");
        labelComuna.setForeground(Color.WHITE);
        labelComuna.setFont(new Font("Arial", 1, 20));
        labelComuna.setBounds(870, 350, 200, 50);
        panelFondo.add(labelComuna);
        JTextField ComunaField = new JTextField();
        ComunaField.setBounds(850, 400, 600, 50);
        ComunaField.setFont(new Font("Arial", 0, 20));
        ComunaField.setBackground(new Color(185, 180, 180));
        ComunaField.setColumns(1);
        panelFondo.add(ComunaField);

        JLabel labelCarrera = new JLabel("Carrera");
        labelCarrera.setForeground(Color.WHITE);
        labelCarrera.setFont(new Font("Arial", 1, 20));
        labelCarrera.setBounds(100, 470, 200, 50);
        panelFondo.add(labelCarrera);
        JTextField carreraField = new JTextField();
        carreraField.setBounds(70, 530, 600, 50);
        carreraField.setFont(new Font("Arial", 0, 20));
        carreraField.setBackground(new Color(185, 180, 180));
        carreraField.setColumns(1);
        panelFondo.add(carreraField);

        JLabel labelCalle = new JLabel("Calle");
        labelCalle.setForeground(Color.WHITE);
        labelCalle.setFont(new Font("Arial", 1, 20));
        labelCalle.setBounds(870, 470, 200, 50);
        panelFondo.add(labelCalle);
        JTextField calleField = new JTextField();
        calleField.setBounds(850,530,600,50);
        calleField.setFont(new Font("Arial", 0, 20));
        calleField.setBackground(new Color(185, 180, 180));
        calleField.setColumns(1);
        panelFondo.add(calleField);

        JButton botonEnviar = new JButton("Enviar:)");
        botonEnviar.setBackground(new Color(110, 149, 0));
        botonEnviar.setForeground(Color.WHITE);
        botonEnviar.setFont(new Font("Times New Roman",1,30));
        botonEnviar.setBounds(610,625,300,150);
        panelFondo.add(botonEnviar);
    }
}
