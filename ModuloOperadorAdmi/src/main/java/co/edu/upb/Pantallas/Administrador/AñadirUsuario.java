package co.edu.upb.Pantallas.Administrador;

import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.Pantallas.Operador.MenuOperador;
import co.edu.upb.domain.Users;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
/**
 * Clase para añadir usuario interfaz grafica
 *@author ChristianRodriguez
 */
public class AñadirUsuario extends JFrame {

    private JPanel contentPane;
    private JTextField nombreField;
    private JTextField EmailField;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JTextField PermisoField;
    private JTextField apellidoField;
    private JTextField ContraField;
    private JLabel lblNewLabel_7;

    /**
     * Launch the application.
     */
    public AñadirUsuario() {
        ComponentesDePagina();
    }

    public void ComponentesDePagina() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1500, 1000);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(14, 106, 156));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);


        lblNewLabel_1 = new JLabel("Nombre");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
        lblNewLabel_1.setBounds(60, 200, 201, 40);
        contentPane.add(lblNewLabel_1);

        nombreField = new JTextField();
        nombreField.setBackground(new Color(255, 255, 255));
        nombreField.setBounds(60, 240, 566, 40);
        nombreField.setFont(new Font("Arial", 0, 20));
        contentPane.add(nombreField);
        nombreField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Permiso");
        lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
        lblNewLabel_1_1.setBounds(500, 400, 442, 40);
        contentPane.add(lblNewLabel_1_1);

        EmailField = new JTextField();
        EmailField.setColumns(1);
        EmailField.setBackground(new Color(255, 255, 255));
        EmailField.setBounds(60, 340, 566, 40);
        EmailField.setFont(new Font("Arial", 0, 20));
        contentPane.add(EmailField);


        lblNewLabel = new JLabel("Email");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
        lblNewLabel.setBounds(60, 300, 201, 40);
        contentPane.add(lblNewLabel);

        lblNewLabel_3 = new JLabel("Apellido");
        lblNewLabel_3.setForeground(new Color(0, 0, 0));
        lblNewLabel_3.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
        lblNewLabel_3.setBounds(850, 200, 201, 38);
        contentPane.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("Contraseña");
        lblNewLabel_4.setForeground(new Color(0, 0, 0));
        lblNewLabel_4.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
        lblNewLabel_4.setBounds(850, 300, 201, 38);
        contentPane.add(lblNewLabel_4);

        PermisoField = new JTextField();
        PermisoField.setColumns(1);
        PermisoField.setBackground(Color.WHITE);
        PermisoField.setFont(new Font("Arial", 0, 20));
        PermisoField.setBounds(500, 440, 566, 40);
        contentPane.add(PermisoField);

        apellidoField = new JTextField();
        apellidoField.setColumns(1);
        apellidoField.setBackground(Color.WHITE);
        apellidoField.setFont(new Font("Arial", 0, 20));
        apellidoField.setBounds(850, 240, 566, 40);
        contentPane.add(apellidoField);

        ContraField = new JTextField();
        ContraField.setColumns(1);
        ContraField.setBackground(Color.WHITE);
        ContraField.setFont(new Font("Arial", 0, 20));
        ContraField.setBounds(850, 340, 566, 40);
        contentPane.add(ContraField);

        JPanel panelFondiu = new JPanel();
        panelFondiu.setBounds(50, 175, 1400, 500);
        panelFondiu.setBackground(new Color(185, 180, 180));
        panelFondiu.setLayout(null);
        contentPane.add(panelFondiu);
        JButton btnNewButton_1 = new JButton("Enviar");
        btnNewButton_1.setForeground(new Color(0, 0, 0));
        btnNewButton_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 22));
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setBounds(650, 618, 228, 50);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String Apellido = apellidoField.getText();
                String email = EmailField.getText();
                String contra = ContraField.getText();
                String permiso = PermisoField.getText();
                Users user = new Users(email, contra, Integer.parseInt(permiso), nombre, Apellido);
                try {
                    if (ModeloLogin.clienteOperador.addUser(user)) {
                        JOptionPane.showMessageDialog(null, "Se ingreso el nuevo usuario");
                        setVisible(false);
                        MenuAdmin men = new MenuAdmin();
                        men.setVisible(true);
                    }
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        contentPane.add(btnNewButton_1);


        lblNewLabel_7 = new JLabel("Añadir usuario");
        lblNewLabel_7.setForeground(new Color(255, 255, 255));
        lblNewLabel_7.setFont(new Font("Times News Roman", 1, 50));
        lblNewLabel_7.setBounds(30, 50, 500, 50);
        contentPane.add(lblNewLabel_7);

        JButton botRegresar = new JButton("Regresate:)");
        botRegresar.setBackground(new Color(153, 2, 68));
        botRegresar.setForeground(Color.WHITE);
        botRegresar.setFont(new Font("Times New Roman", 1, 30));
        botRegresar.setBounds(100, 625, 200, 50);
        botRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MenuAdmin men = new MenuAdmin();
                men.setVisible(true);
            }
        });
        contentPane.add(botRegresar);
    }

}
