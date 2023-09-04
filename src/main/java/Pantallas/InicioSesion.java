package Pantallas;

import datos.UsersConnect;
import domain.Users;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Pantalla de inicio de sesion
 */
public class InicioSesion extends JFrame {
    private JPanel contentPane;
    private JPasswordField pswField;
    private JTextField textCorreo;
    private JPanel miJPanel;
    JButton boton;

    public InicioSesion(){
        componets();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Metodos inilizacion de la pantalla
     */

    private void componets(){
        setBounds(500, 100, 1190, 766);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(80, 199, 199));
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

        ActionListener validation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textCorreo.getText().length() > 0 && pswField.getText().length() > 0){
                        String em = textCorreo.getText();
                        String ps = pswField.getText();
                        UsersConnect conDb = new UsersConnect();
                        Users user = conDb.select(em,ps);
                        if (user.getEmail() != null){
                            setVisible(false);
                            Menu menu = new Menu();
                            menu.setVisible(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "no es el usuario o la contaseña");
                            textCorreo.setText("");
                            pswField.setText("");
                            textCorreo.requestFocusInWindow();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Esta vacio");
                    }
                }catch (Exception ex){
                   ex.printStackTrace();
                }
            }
        };

        boton.addActionListener(validation);


    }
}
