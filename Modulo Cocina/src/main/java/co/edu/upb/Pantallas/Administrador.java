package co.edu.upb.Pantallas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 * Pantalla administrador
 */

public class Administrador extends JFrame {

	private JPanel contentPane;
	private JPanel miPanel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	private JLabel lblBienvenido;
	private JLabel lblAccion1;
	private JLabel lblAccion2;
	private JLabel lblAccion3;
	private JLabel lblAccion4;
	private JLabel lblAccion5;
	private JLabel lblAccion6;
	private JComponent btnNewButton_4;
	private JComponent btnNewButton_5;
	private JComponent btnNewButton_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador frame = new Administrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Administrador() {
		ComponentesDePagina();
		this.setExtendedState(this.MAXIMIZED_BOTH);
	}

	/**
	 * metodos de componentes
	 */
	private void ComponentesDePagina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 1000, 720);
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
		
		
				
		lblBienvenido = new JLabel("Bienvenido administrador");
		lblBienvenido.setBounds(10, 22, 481, 45);
		miPanel.add(lblBienvenido);
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		
		lblAccion1 = new JLabel(" Cambiar de Cuenta");
		lblAccion1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
		lblAccion1.setBounds(51, 120, 378, 25);
		miPanel.add(lblAccion1);
				
		lblAccion2 = new JLabel(" Ver seguimiento de ventas en los ultimos dias");
		lblAccion2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
		lblAccion2.setBounds(55, 170, 378, 25);
		miPanel.add(lblAccion2);
				
		lblAccion3 = new JLabel(" Eliminar Usuario");
		lblAccion3.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
		lblAccion3.setBounds(55, 220, 378, 25);
		miPanel.add(lblAccion3);
				
		lblAccion4 = new JLabel(" Administrar Usuarios");
		lblAccion4.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
		lblAccion4.setBounds(55, 270, 378, 25);
		miPanel.add(lblAccion4);
		
		lblAccion5 = new JLabel(" Agregar Platos");
		lblAccion5.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
		lblAccion5.setBounds(55, 320, 378, 25);
		miPanel.add(lblAccion5);
		
		lblAccion6 = new JLabel(" Eliminar Platos");
		lblAccion6.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
		lblAccion6.setBounds(55, 370, 378, 25);
		miPanel.add(lblAccion6);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setFont(new Font("Meiryo", Font.BOLD, 10));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(20, 120, 25, 25);
		miPanel.add(btnNewButton_1);
			
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Meiryo", Font.BOLD, 10));
		btnNewButton_2.setBackground(new Color(255, 128, 0));
		btnNewButton_2.setBounds(20, 170, 25, 25);
		miPanel.add(btnNewButton_2);
				
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setFont(new Font("Meiryo", Font.BOLD, 10));
		btnNewButton_3.setBackground(new Color(255, 0, 0));
		btnNewButton_3.setBounds(20, 220, 25, 25);
		miPanel.add(btnNewButton_3);
				
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setFont(new Font("Meiryo", Font.BOLD, 10));
		btnNewButton_4.setBackground(new Color(200, 20, 0));
		btnNewButton_4.setBounds(20, 270, 25, 25);
		miPanel.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("");
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setFont(new Font("Meiryo", Font.BOLD, 10));
		btnNewButton_5.setBackground(new Color(192, 192, 192));
		btnNewButton_5.setBounds(20, 320, 25, 25);
		miPanel.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("");
		btnNewButton_6.setForeground(Color.BLACK);
		btnNewButton_6.setFont(new Font("Meiryo", Font.BOLD, 10));
		btnNewButton_6.setBackground(new Color(99, 99, 99));
		btnNewButton_6.setBounds(20, 370, 25, 25);
		miPanel.add(btnNewButton_6);
	}
}