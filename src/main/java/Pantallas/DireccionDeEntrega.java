package Pantallas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

/**
 * Ingreso de la dirreccion
 */

public class DireccionDeEntrega extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DireccionDeEntrega frame = new DireccionDeEntrega();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DireccionDeEntrega() {
		ComponentesDePagina();
		//this.setExtendedState(this.MAXIMIZED_BOTH);
	}

	/**
	 * Metetodo para inicializar componentes
	 */
	public void ComponentesDePagina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 20, 600, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" ¿Que platos desea pedir?");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(10, 202, 422, 38);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(10, 250, 566, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel(" Dirección del envio:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(10, 360, 442, 30);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBounds(10, 400, 566, 38);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Ver menu");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(200, 20, 0));
		btnNewButton.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 10, 130, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Comprar");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 22));
		btnNewButton_1.setBackground(new Color(200, 20, 0));
		btnNewButton_1.setBounds(163, 588, 228, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(255, 128, 0));
		lblNewLabel.setBounds(0, -43, 586, 796);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pabra\\Downloads\\ElPingu(2).jpg"));
		contentPane.add(lblNewLabel);
	}
}
