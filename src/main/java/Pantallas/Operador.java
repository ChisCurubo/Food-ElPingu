package Pantallas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Operador extends JFrame {

	private JPanel contentPane;
	private JPanel miPanel;
	private JLabel lblBloquearUsuario;
	private JLabel lblAdministrarUsuarios;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operador frame = new Operador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Operador() {
		ComponentesDePagina();
		this.setExtendedState(this.MAXIMIZED_BOTH);
	}
	private void ComponentesDePagina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 950, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 235, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		miPanel = new JPanel();
		miPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		miPanel.setBackground(new Color(255, 255, 255));
		miPanel.setBounds(500, 50, 501, 604);
		contentPane.add(miPanel);
		miPanel.setLayout(null);
	
		JLabel lblNewLabel = new JLabel("Bienvenido operador");
		lblNewLabel.setBounds(10, 22, 481, 45);
		miPanel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		
		JLabel lblCorreo = new JLabel(" Cambiar de Cuenta");
		lblCorreo.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
		lblCorreo.setBounds(51, 120, 378, 25);
		miPanel.add(lblCorreo);
				
		JLabel lblContraseña = new JLabel(" Metodos de pago");
		lblContraseña.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
		lblContraseña.setBounds(55, 220, 378, 25);
		miPanel.add(lblContraseña);
				
		lblBloquearUsuario = new JLabel(" Agregar direcciones de entrega especificas");
		lblBloquearUsuario.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
		lblBloquearUsuario.setBounds(55, 170, 378, 25);
		miPanel.add(lblBloquearUsuario);
		
		lblAdministrarUsuarios = new JLabel(" Alterar diseño de la pagina");
		lblAdministrarUsuarios.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
		lblAdministrarUsuarios.setBounds(55, 270, 378, 25);
		miPanel.add(lblAdministrarUsuarios);
				
		btnNewButton = new JButton("");
		btnNewButton.setFont(new Font("Meiryo", Font.BOLD, 10));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(20, 120, 25, 25);
		miPanel.add(btnNewButton);
				
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Meiryo", Font.BOLD, 10));
		btnNewButton_1.setBackground(new Color(255, 128, 0));
		btnNewButton_1.setBounds(20, 170, 25, 25);
		miPanel.add(btnNewButton_1);
				
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Meiryo", Font.BOLD, 10));
		btnNewButton_2.setBackground(new Color(200, 20, 0));
		btnNewButton_2.setBounds(20, 270, 25, 25);
		miPanel.add(btnNewButton_2);
				
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setFont(new Font("Meiryo", Font.BOLD, 10));
		btnNewButton_3.setBackground(new Color(255, 0, 0));
		btnNewButton_3.setBounds(20, 220, 25, 25);
		miPanel.add(btnNewButton_3);
	}
}