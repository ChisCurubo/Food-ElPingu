package co.edu.upb.Pantallas.Operador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * Pantalla de inicio de sesion
 */
public class InicioSesion extends JFrame {
    private JPanel contentPane;
    private JPasswordField pswField;
    private JTextField textCorreo;
    private JPanel miJPanel;
    private JButton boton;


    public InicioSesion(){
        componets();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\logo (Pequeño).jpg").getImage());
    }

    /**
     * Metodos inilizacion de la pantalla
     */

    private void componets(){
        setBounds(500, 100, 1190, 766);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(87, 122, 147));
        contentPane.setBorder(new EmptyBorder(5,5,5,5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblnewLabel = new JLabel("Log in");
        lblnewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblnewLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 45));
        lblnewLabel.setBounds(600,222,375, 50);
        contentPane.add(lblnewLabel);

        miJPanel = new JPanel();
        miJPanel.setBorder(new MatteBorder(2, 4, 2, 4, (Color) new Color(0, 0, 0)));
        miJPanel.setBounds(600,180, 372, 443);
        contentPane.add(miJPanel);
        miJPanel.setLayout(null);

        boton = new JButton("Continuar");
        boton.setBounds(216, 360, 125, 33);
        miJPanel.add(boton);
        boton.setForeground(new Color(22, 22, 92));
        boton.setFont(new Font("Tahoma", Font.BOLD, 15));

        JLabel lblCorreo = new JLabel("Correo electronico:");
        lblCorreo.setBounds(10, 120, 350, 20);
        lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        miJPanel.add(lblCorreo);

        textCorreo = new JTextField();
        textCorreo.setBounds(10, 150, 350, 20);
        miJPanel.add(textCorreo);
        textCorreo.setColumns(10);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setBounds(10, 200, 350, 20);
        lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
        miJPanel.add(lblContraseña);

        pswField = new JPasswordField();
        pswField.setBounds(10, 230, 350, 20);
        miJPanel.add(pswField);

    }

    public JPasswordField getPswField() {
        return pswField;
    }

    public void setPswField(JPasswordField pswField) {
        this.pswField = pswField;
    }

    public JTextField getTextCorreo() {
        return textCorreo;
    }

    public void setTextCorreo(JTextField textCorreo) {
        this.textCorreo = textCorreo;
    }

    public JPanel getMiJPanel() {
        return miJPanel;
    }

    public void setMiJPanel(JPanel miJPanel) {
        this.miJPanel = miJPanel;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }
}
