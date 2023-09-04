package Pantallas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

/**
 * Pantalla de registro de cuenta
 */

public class RegistroDeCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField passwordField;
	private JTextField textCorreo;
	private JPanel miPanel;
	JButton btnRegistrarse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroDeCuenta frame = new RegistroDeCuenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public RegistroDeCuenta() {
		ComponentesDePagina();
		this.setExtendedState(this.MAXIMIZED_BOTH);
	}

	/**
	 * Metodo de inicializacion componentes
	 */
	private void ComponentesDePagina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 1190, 766);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 235, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("Nombre de usuario:");
		lblUser.setBounds(610, 290, 350, 20);
		contentPane.add(lblUser);
		
		textUser = new JTextField();
		textUser.setBounds(610, 310, 350, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo electronico:");
		lblCorreo.setBounds(610, 360, 350, 20);
		contentPane.add(lblCorreo);

		textCorreo = new JTextField();
		textCorreo.setBounds(610, 380, 350, 20);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setBounds(610, 430, 350, 20);
		contentPane.add(lblContraseña);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(610, 450, 350, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Registrarse");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblNewLabel.setBounds(610, 222, 350, 33);
		contentPane.add(lblNewLabel);
		
		miPanel = new JPanel();
		miPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		miPanel.setBackground(new Color(255, 255, 255));
		miPanel.setBounds(600, 180, 372, 500);
		contentPane.add(miPanel);
		miPanel.setLayout(null);
		
		btnRegistrarse = new JButton("Continuar >");
		btnRegistrarse.setBounds(220, 400, 133, 33);
		miPanel.add(btnRegistrarse);
		btnRegistrarse.setForeground(new Color(68, 162, 255));
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				this.setVisible(false);
			}
			private void setVisible(boolean b) {
				// TODO Auto-generated method stub	
			}
		});
	}
}
