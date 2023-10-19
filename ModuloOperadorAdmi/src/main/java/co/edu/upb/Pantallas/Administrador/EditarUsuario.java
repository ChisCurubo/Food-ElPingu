package co.edu.upb.Pantallas.Administrador;

import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.domain.Users;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class EditarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField BusquedaField;
	private JTextField correoField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JTextField ContrasenaField;
	private JTextField tipoAcceso;
	private JLabel lblNewLabel_7;
	private JPanel panel;
	private JLabel lblNewLabel_1_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton;

	private String correo = "";
	private String contra = "";
	private String tipo = "";
	private String nombre = "";
	private String apellido = "";
	private int id = 0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarUsuario frame = new EditarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditarUsuario() {
		ComponentesDePagina();
	}
	public void ComponentesDePagina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(14, 106, 156));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Buscar usuario: ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times News Roman", 1, 20));
		lblNewLabel_1.setBounds(30, 150, 200, 50);
		contentPane.add(lblNewLabel_1);



		panel = new JPanel();
		panel.setBounds(50, 250, 750, 400);
		panel.setBackground(new Color(185, 180, 180));
		panel.setLayout(null);
		contentPane.add(panel);
		
		lblNewLabel_1_1 = new JLabel("Correo");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(20, 50, 200, 40);
		panel.add(lblNewLabel_1_1);
		
		correoField = new JTextField();
		correoField.setColumns(1);
		correoField.setBackground(new Color(99, 164, 2));
		correoField.setFont(new Font("Arial", 0, 20));
		correoField.setBounds(200, 50, 300, 40);
		panel.add(correoField);

		
		lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", 0, 20));
		lblNewLabel_2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(20, 125, 200, 40);
		panel.add(lblNewLabel_2);
		
		ContrasenaField = new JTextField();
		ContrasenaField.setColumns(1);
		ContrasenaField.setBackground(new Color(99, 164, 2));
		ContrasenaField.setBounds(200, 125, 300, 40);
		panel.add(ContrasenaField);

		lblNewLabel = new JLabel("Tipo Acceso: ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		lblNewLabel.setBounds(20, 200, 200, 40);
		panel.add(lblNewLabel);
		
		tipoAcceso = new JTextField();
		tipoAcceso.setColumns(1);
		tipoAcceso.setFont(new Font("Arial", 0, 20));
		tipoAcceso.setBackground(new Color(99, 164, 2));
		tipoAcceso.setBounds(200, 200, 300, 40);
		panel.add(tipoAcceso);

		JLabel nombreLabel = new JLabel("Nombre: ");
		nombreLabel.setForeground(new Color(0, 0, 0));
		nombreLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		nombreLabel.setBounds(20, 275, 200, 40);
		panel.add(nombreLabel);

		JTextField fieldNombree = new JTextField();
		fieldNombree.setColumns(1);
		fieldNombree.setBackground(new Color(99, 164, 2));
		fieldNombree.setFont(new Font("Arial", 0, 20));
		fieldNombree.setBounds(200, 275, 300, 40);
		panel.add(fieldNombree);

		JLabel ApellidoLabel = new JLabel("Apellido: ");
		ApellidoLabel.setForeground(new Color(0, 0, 0));
		ApellidoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		ApellidoLabel.setBounds(20, 350, 200, 40);
		panel.add(ApellidoLabel);

		JTextField fieldApellido = new JTextField();
		fieldApellido.setColumns(1);
		fieldApellido.setBackground(new Color(99, 164, 2));
		fieldApellido.setFont(new Font("Arial", 0, 20));
		fieldApellido.setBounds(200, 350, 300, 40);
		panel.add(fieldApellido);

		
		lblNewLabel_7 = new JLabel("Editar usuario");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Times News Roman", 1, 50));
		lblNewLabel_7.setBounds(30, 50, 400, 50);
		contentPane.add(lblNewLabel_7);

		JPanel panelDatos = new JPanel();
		panelDatos.setBackground((new Color(99, 164, 2)));
		panelDatos.setBounds(850, 150, 600, 450);
		contentPane.add(panelDatos);
		panelDatos.setLayout(null);

		JLabel tituloPanelDatos = new JLabel("Info Usuario");
		tituloPanelDatos.setForeground(Color.WHITE);
		tituloPanelDatos.setFont(new Font("Arial", 1, 30));
		tituloPanelDatos.setBounds(250, 20, 200, 50);
		panelDatos.add(tituloPanelDatos);

		JLabel labelNombreInfo = new JLabel("Nombre: ");
		labelNombreInfo.setForeground(Color.WHITE);
		labelNombreInfo.setFont(new Font("Arial", 1, 20));
		labelNombreInfo.setBounds(30, 100, 200, 25);
		panelDatos.add(labelNombreInfo);
		JLabel nombreFieldInfo = new JLabel();
		nombreFieldInfo.setBounds(120, 100, 200, 30);
		nombreFieldInfo.setFont(new Font("Arial", 0, 20));
		nombreFieldInfo.setForeground(Color.WHITE);
		nombreFieldInfo.setText(nombre);
		panelDatos.add(nombreFieldInfo);

		JLabel labelApellidoInfo = new JLabel("Apellido: ");
		labelApellidoInfo.setForeground(Color.WHITE);
		labelApellidoInfo.setFont(new Font("Arial", 1, 20));
		labelApellidoInfo.setBounds(330, 100, 200, 25);
		panelDatos.add(labelApellidoInfo);
		JLabel apellidoFieldINfo = new JLabel();
		apellidoFieldINfo.setBounds(430, 100, 200, 30);
		apellidoFieldINfo.setFont(new Font("Arial", 0, 20));
		apellidoFieldINfo.setForeground(Color.WHITE);
		apellidoFieldINfo.setText(apellido);
		panelDatos.add(apellidoFieldINfo);

		JLabel labelCorreoInfo = new JLabel("Correo: ");
		labelCorreoInfo.setForeground(Color.WHITE);
		labelCorreoInfo.setFont(new Font("Arial", 1, 20));
		labelCorreoInfo.setBounds(30, 240, 200, 25);
		panelDatos.add(labelCorreoInfo);
		JLabel correoFieldInfo = new JLabel();
		correoFieldInfo.setBounds(110, 240, 300, 30);
		correoFieldInfo.setFont(new Font("Arial", 0, 20));
		correoFieldInfo.setForeground(Color.WHITE);
		correoFieldInfo.setText(correo);
		panelDatos.add(correoFieldInfo);

		JLabel labelTelefonoInfo = new JLabel("Contraseña: ");
		labelTelefonoInfo.setForeground(Color.WHITE);
		labelTelefonoInfo.setFont(new Font("Arial", 1, 20));
		labelTelefonoInfo.setBounds(330, 170, 200, 30);
		panelDatos.add(labelTelefonoInfo);
		JLabel TelefonoFieldINfo = new JLabel();
		TelefonoFieldINfo.setBounds(450, 170, 200, 30);
		TelefonoFieldINfo.setFont(new Font("Arial", 0, 20));
		TelefonoFieldINfo.setForeground(Color.WHITE);
		TelefonoFieldINfo.setText(contra);
		panelDatos.add(TelefonoFieldINfo);

		JLabel labelMunicipioInfo = new JLabel("Tipo Acceso: ");
		labelMunicipioInfo.setForeground(Color.WHITE);
		labelMunicipioInfo.setFont(new Font("Arial", 1, 20));
		labelMunicipioInfo.setBounds(30, 170, 200, 30);
		panelDatos.add(labelMunicipioInfo);
		JLabel MunicipioFieldInfo = new JLabel();
		MunicipioFieldInfo.setBounds(200, 170, 180, 30);
		MunicipioFieldInfo.setFont(new Font("Arial", 0, 20));
		MunicipioFieldInfo.setForeground(Color.WHITE);
		MunicipioFieldInfo.setText(tipo);
		panelDatos.add(MunicipioFieldInfo);

		BusquedaField = new JTextField();
		BusquedaField.setBackground(new Color(255, 255, 255));
		BusquedaField.setFont(new Font("Arial", 0, 20));
		BusquedaField.setBounds(270, 150, 400, 40);
		BusquedaField.setColumns(1);
		BusquedaField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String busqueda = BusquedaField.getText();
				try {
					Users user = ModeloLogin.clienteOperador.selectUser(busqueda);
					if( user != null){
						nombreFieldInfo.setText(user.getNombre());
						apellidoFieldINfo.setText(user.getApellido());
						correoFieldInfo.setText(user.getEmail());
						TelefonoFieldINfo.setText(user.getPwd());
						MunicipioFieldInfo.setText(String.valueOf(user.getTipo()));
						id = user.getID();
						System.out.println(id);
					}
				} catch (RemoteException ex) {
					throw new RuntimeException(ex);
				}
			}
		});
		contentPane.add(BusquedaField);

		btnNewButton_1 = new JButton("Enviar");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 22));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(648, 695, 228, 38);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Users user = new Users(id,correoFieldInfo.getText(),TelefonoFieldINfo.getText(), Integer.parseInt(MunicipioFieldInfo.getText()), nombreFieldInfo.getText(),apellidoFieldINfo.getText());
				try {
					if(ModeloLogin.clienteOperador.editUser(user)){
						JOptionPane.showMessageDialog(null,  "Se edito usuario");
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

		JButton actualizar = new JButton("Actualizar");
		actualizar.setBackground(new Color(110, 149, 0));
		actualizar.setForeground(Color.WHITE);
		actualizar.setFont(new Font("Times New Roman", 1, 30));
		actualizar.setBounds(525, 200, 200, 100);
		actualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nombreFieldInfo.setText(fieldNombree.getText());
				apellidoFieldINfo.setText(fieldApellido.getText());
				correoFieldInfo.setText(correoField.getText());
				TelefonoFieldINfo.setText(correoField.getText());
				MunicipioFieldInfo.setText(tipoAcceso.getText());
			}
		});
		panel.add(actualizar);
	}
}
