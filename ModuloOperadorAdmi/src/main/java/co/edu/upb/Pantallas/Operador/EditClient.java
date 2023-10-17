package co.edu.upb.Pantallas.Operador;

import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.domain.Clientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class EditClient extends JFrame {
    public static void main(String[] args) {
        EditClient clie = new EditClient();
    }

    String nombreChange = "";
    String apellidoChange = "";
    String telefonoChange = "";
    String correoChange = "";
    String calleChange = "";
    String municipioChange = "";
    String comunaChange = "";
    String carreraChange = "";
    String tipostr = "";

    // faltan los action listeners, al hacer eso nos permitira cambiar todo.
    //actualizar panel de la derecha

    public EditClient() {
        initOperatorAddClient();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\logo (Pequeño).jpg").getImage());
    }

    public void initOperatorAddClient() {
        setTitle("Edit Client");
        setBounds(0, 0, 1500, 1000);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0, 0, 1500, 1000);
        panelFondo.setBackground(new Color(64, 93, 128));
        setContentPane(panelFondo);
        setLayout(null);

        JLabel labelTitulo = new JLabel("Actualizar Cliente ");
        labelTitulo.setForeground(Color.WHITE);
        labelTitulo.setFont(new Font("Times New Roman", 1, 50));
        labelTitulo.setBounds(70, 20, 500, 100);
        panelFondo.add(labelTitulo);

        JPanel panelDatos = new JPanel();
        panelDatos.setBackground(new Color(87, 122, 147));
        panelDatos.setBounds(850, 150, 600, 450);
        panelFondo.add(panelDatos);
        panelDatos.setLayout(null);

        JLabel tituloPanelDatos = new JLabel("Info Cliente");
        tituloPanelDatos.setForeground(Color.WHITE);
        tituloPanelDatos.setFont(new Font("Arial", 1, 20));
        tituloPanelDatos.setBounds(250, 20, 150, 50);
        panelDatos.add(tituloPanelDatos);

        JLabel labelNombreInfo = new JLabel("Nombre: ");
        labelNombreInfo.setForeground(Color.WHITE);
        labelNombreInfo.setFont(new Font("Arial", 1, 20));
        labelNombreInfo.setBounds(30, 70, 100, 25);
        panelDatos.add(labelNombreInfo);
        JLabel nombreFieldInfo = new JLabel();
        nombreFieldInfo.setBounds(120, 70, 200, 30);
        nombreFieldInfo.setFont(new Font("Arial", 0, 20));
        nombreFieldInfo.setForeground(Color.WHITE);
        nombreFieldInfo.setText(nombreChange);
        panelDatos.add(nombreFieldInfo);

        JLabel labelApellidoInfo = new JLabel("Apellido: ");
        labelApellidoInfo.setForeground(Color.WHITE);
        labelApellidoInfo.setFont(new Font("Arial", 1, 20));
        labelApellidoInfo.setBounds(330, 70, 100, 25);
        panelDatos.add(labelApellidoInfo);
        JLabel apellidoFieldINfo = new JLabel();
        apellidoFieldINfo.setBounds(430, 70, 200, 30);
        apellidoFieldINfo.setFont(new Font("Arial", 0, 20));
        apellidoFieldINfo.setForeground(Color.WHITE);
        apellidoFieldINfo.setText(apellidoChange);
        panelDatos.add(apellidoFieldINfo);

        JLabel labelCorreoInfo = new JLabel("Correo: ");
        labelCorreoInfo.setForeground(Color.WHITE);
        labelCorreoInfo.setFont(new Font("Arial", 1, 20));
        labelCorreoInfo.setBounds(30, 140, 100, 25);
        panelDatos.add(labelCorreoInfo);
        JLabel correoFieldInfo = new JLabel();
        correoFieldInfo.setBounds(110, 140, 200, 30);
        correoFieldInfo.setFont(new Font("Arial", 0, 20));
        correoFieldInfo.setForeground(Color.WHITE);
        correoFieldInfo.setText(correoChange);
        panelDatos.add(correoFieldInfo);

        JLabel labelTelefonoInfo = new JLabel("Telefono: ");
        labelTelefonoInfo.setForeground(Color.WHITE);
        labelTelefonoInfo.setFont(new Font("Arial", 1, 20));
        labelTelefonoInfo.setBounds(330, 140, 100, 30);
        panelDatos.add(labelTelefonoInfo);
        JLabel TelefonoFieldINfo = new JLabel();
        TelefonoFieldINfo.setBounds(430, 140, 200, 30);
        TelefonoFieldINfo.setFont(new Font("Arial", 0, 20));
        TelefonoFieldINfo.setForeground(Color.WHITE);
        TelefonoFieldINfo.setText(telefonoChange);
        panelDatos.add(TelefonoFieldINfo);

        JLabel labelMunicipioInfo = new JLabel("Municipio: ");
        labelMunicipioInfo.setForeground(Color.WHITE);
        labelMunicipioInfo.setFont(new Font("Arial", 1, 20));
        labelMunicipioInfo.setBounds(30, 210, 110, 30);
        panelDatos.add(labelMunicipioInfo);
        JLabel MunicipioFieldInfo = new JLabel();
        MunicipioFieldInfo.setBounds(130, 210, 180, 30);
        MunicipioFieldInfo.setFont(new Font("Arial", 0, 20));
        MunicipioFieldInfo.setForeground(Color.WHITE);
        MunicipioFieldInfo.setText(municipioChange);
        panelDatos.add(MunicipioFieldInfo);

        JLabel labelComunaInfo = new JLabel("Comuna: ");
        labelComunaInfo.setForeground(Color.WHITE);
        labelComunaInfo.setFont(new Font("Arial", 1, 20));
        labelComunaInfo.setBounds(330, 210, 100, 30);
        panelDatos.add(labelComunaInfo);
        JLabel ComunaFieldInfo = new JLabel();
        ComunaFieldInfo.setBounds(430, 210, 200, 30);
        ComunaFieldInfo.setFont(new Font("Arial", 0, 20));
        ComunaFieldInfo.setForeground(Color.WHITE);
        ComunaFieldInfo.setText(comunaChange);
        panelDatos.add(ComunaFieldInfo);

        JLabel labelCarreraInfo = new JLabel("Carrera: ");
        labelCarreraInfo.setForeground(Color.WHITE);
        labelCarreraInfo.setFont(new Font("Arial", 1, 20));
        labelCarreraInfo.setBounds(30, 280, 100, 30);
        panelDatos.add(labelCarreraInfo);
        JLabel carreraFieldInfo = new JLabel();
        carreraFieldInfo.setBounds(110, 280, 200, 30);
        carreraFieldInfo.setFont(new Font("Arial", 0, 20));
        carreraFieldInfo.setForeground(Color.WHITE);
        carreraFieldInfo.setText(carreraChange);
        panelDatos.add(carreraFieldInfo);

        JLabel labelCalleInfo = new JLabel("Calle: ");
        labelCalleInfo.setForeground(Color.WHITE);
        labelCalleInfo.setFont(new Font("Arial", 1, 20));
        labelCalleInfo.setBounds(330, 280, 100, 30);
        panelDatos.add(labelCalleInfo);
        JLabel calleFieldInfo = new JLabel();
        calleFieldInfo.setBounds(430, 280, 200, 30);
        calleFieldInfo.setFont(new Font("Arial", 0, 20));
        calleFieldInfo.setForeground(Color.WHITE);
        calleFieldInfo.setText(calleChange);
        panelDatos.add(calleFieldInfo);

        JLabel tipos = new JLabel("Tipo : ");
        tipos.setBounds(30, 350, 200, 30);
        tipos.setFont(new Font("Arial", 1, 20));
        tipos.setForeground(Color.WHITE);
        panelDatos.add(tipos);
        JLabel tiposFieldInfo = new JLabel();
        tiposFieldInfo.setBounds(110, 350, 200, 30);
        tiposFieldInfo.setFont(new Font("Arial", 0, 20));
        tiposFieldInfo.setForeground(Color.WHITE);
        tiposFieldInfo.setText(tipostr);
        panelDatos.add(tiposFieldInfo);

        JLabel idClient = new JLabel("IDCliente : ");
        idClient.setBounds(330, 350, 200, 30);
        idClient.setFont(new Font("Arial", 1, 20));
        idClient.setForeground(Color.WHITE);
        panelDatos.add(idClient);
        JLabel idClientInfo = new JLabel();
        idClientInfo.setBounds(430, 350, 200, 30);
        idClientInfo.setFont(new Font("Arial", 0, 20));
        idClientInfo.setForeground(Color.WHITE);
        idClientInfo.setText(tipostr);
        panelDatos.add(idClientInfo);

        JLabel labelBuscar = new JLabel("Buscar por telefono ");
        labelBuscar.setForeground(Color.WHITE);
        labelBuscar.setFont(new Font("Times New Roman", 1, 30));
        labelBuscar.setBounds(800, 20, 400, 100);
        panelFondo.add(labelBuscar);
        JTextField busquedaField = new JTextField();
        busquedaField.setBounds(1070, 50, 300, 50);
        busquedaField.setFont(new Font("Arial", 0, 20));
        busquedaField.setBackground(new Color(110, 149, 0));
        busquedaField.setColumns(1);
        busquedaField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busqueda = busquedaField.getText();
                try {
                    String str = ModeloLogin.clienteOperador.bringClienteCompleate(busqueda);
                    String[] arrstrstr = str.split(",");
                    Clientes cli = new Clientes(Integer.parseInt(arrstrstr[0]),arrstrstr[1],arrstrstr[2], arrstrstr[3], arrstrstr[4], arrstrstr[5], arrstrstr[6], arrstrstr[7], arrstrstr[8],Integer.parseInt(arrstrstr[9]));
                    nombreFieldInfo.setText(cli.getNombre());
                    apellidoFieldINfo.setText(cli.getApellido());
                    calleFieldInfo.setText(cli.getCalle());
                    carreraFieldInfo.setText(cli.getCarrera());
                    correoFieldInfo.setText(cli.getCorreo());
                    TelefonoFieldINfo.setText(cli.getTelefono());
                    MunicipioFieldInfo.setText(cli.getMunicipio());
                    ComunaFieldInfo.setText(cli.getBarrio());
                    tiposFieldInfo.setText(String.valueOf(cli.getTipoCliente()));
                    idClientInfo.setText(String.valueOf(cli.getIdClientes()));


                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panelFondo.add(busquedaField);



        JPanel panelDatosUpdate = new JPanel();
        panelDatosUpdate.setBackground(new Color(87, 122, 147));
        panelDatosUpdate.setBounds(50, 150, 700, 450);
        panelFondo.add(panelDatosUpdate);
        panelDatosUpdate.setLayout(null);
        JLabel tituloPanelDatosUpdate = new JLabel("Update Info Cliente");
        tituloPanelDatosUpdate.setForeground(Color.WHITE);
        tituloPanelDatosUpdate.setFont(new Font("Arial", 1, 20));
        tituloPanelDatosUpdate.setBounds(250, 10, 250, 50);
        panelDatosUpdate.add(tituloPanelDatosUpdate);

        JLabel labelNombre = new JLabel("Nombre");
        labelNombre.setForeground(Color.WHITE);
        labelNombre.setFont(new Font("Arial", 1, 20));
        labelNombre.setBounds(30, 70, 100, 25);
        panelDatosUpdate.add(labelNombre);
        JTextField nombreField = new JTextField();
        nombreField.setBounds(110, 70, 200, 30);
        nombreField.setFont(new Font("Arial", 0, 20));
        nombreField.setBackground(new Color(185, 180, 180));
        nombreField.setColumns(1);
        panelDatosUpdate.add(nombreField);

        JLabel labelApellido = new JLabel("Apellido");
        labelApellido.setForeground(Color.WHITE);
        labelApellido.setFont(new Font("Arial", 1, 20));
        labelApellido.setBounds(330, 70, 100, 25);
        panelDatosUpdate.add(labelApellido);
        JTextField apellidoField = new JTextField();
        apellidoField.setBounds(430, 70, 200, 30);
        apellidoField.setFont(new Font("Arial", 0, 20));
        apellidoField.setBackground(new Color(185, 180, 180));
        apellidoField.setColumns(1);
        panelDatosUpdate.add(apellidoField);

        JLabel labelCorreo = new JLabel("Correo");
        labelCorreo.setForeground(Color.WHITE);
        labelCorreo.setFont(new Font("Arial", 1, 20));
        labelCorreo.setBounds(30, 140, 100, 25);
        panelDatosUpdate.add(labelCorreo);
        JTextField correoField = new JTextField();
        correoField.setBounds(110, 140, 200, 30);
        correoField.setFont(new Font("Arial", 0, 20));
        correoField.setBackground(new Color(185, 180, 180));
        correoField.setColumns(1);
        panelDatosUpdate.add(correoField);

        JLabel labelTelefono = new JLabel("Telefono");
        labelTelefono.setForeground(Color.WHITE);
        labelTelefono.setFont(new Font("Arial", 1, 20));
        labelTelefono.setBounds(330, 140, 100, 30);
        panelDatosUpdate.add(labelTelefono);
        JTextField TelefonoField = new JTextField();
        TelefonoField.setBounds(430, 140, 200, 30);
        TelefonoField.setFont(new Font("Arial", 0, 20));
        TelefonoField.setBackground(new Color(185, 180, 180));
        TelefonoField.setColumns(1);
        panelDatosUpdate.add(TelefonoField);

        JLabel labelMunicipio = new JLabel("Municipio");
        labelMunicipio.setForeground(Color.WHITE);
        labelMunicipio.setFont(new Font("Arial", 1, 20));
        labelMunicipio.setBounds(30, 210, 100, 30);
        panelDatosUpdate.add(labelMunicipio);
        JTextField MunicipioField = new JTextField();
        MunicipioField.setBounds(130, 210, 180, 30);
        MunicipioField.setFont(new Font("Arial", 0, 20));
        MunicipioField.setBackground(new Color(185, 180, 180));
        MunicipioField.setColumns(1);
        panelDatosUpdate.add(MunicipioField);

        JLabel labelComuna = new JLabel("Comuna");
        labelComuna.setForeground(Color.WHITE);
        labelComuna.setFont(new Font("Arial", 1, 20));
        labelComuna.setBounds(330, 210, 100, 30);
        panelDatosUpdate.add(labelComuna);
        JTextField ComunaField = new JTextField();
        ComunaField.setBounds(430, 210, 200, 30);
        ComunaField.setFont(new Font("Arial", 0, 20));
        ComunaField.setBackground(new Color(185, 180, 180));
        ComunaField.setColumns(1);
        panelDatosUpdate.add(ComunaField);

        JLabel labelCarrera = new JLabel("Carrera");
        labelCarrera.setForeground(Color.WHITE);
        labelCarrera.setFont(new Font("Arial", 1, 20));
        labelCarrera.setBounds(30, 280, 100, 30);
        panelDatosUpdate.add(labelCarrera);
        JTextField carreraField = new JTextField();
        carreraField.setBounds(110, 280, 200, 30);
        carreraField.setFont(new Font("Arial", 0, 20));
        carreraField.setBackground(new Color(185, 180, 180));
        carreraField.setColumns(1);
        panelDatosUpdate.add(carreraField);

        JLabel labelCalle = new JLabel("Calle");
        labelCalle.setForeground(Color.WHITE);
        labelCalle.setFont(new Font("Arial", 1, 20));
        labelCalle.setBounds(330, 280, 100, 30);
        panelDatosUpdate.add(labelCalle);
        JTextField calleField = new JTextField();
        calleField.setBounds(430, 280, 200, 30);
        calleField.setFont(new Font("Arial", 0, 20));
        calleField.setBackground(new Color(185, 180, 180));
        calleField.setColumns(1);
        panelDatosUpdate.add(calleField);


        JLabel tipo = new JLabel("Tipo");
        tipo.setForeground(Color.WHITE);
        tipo.setFont(new Font("Arial", 1, 20));
        tipo.setBounds(30, 340, 100, 30);
        panelDatosUpdate.add(tipo);
        JTextField tipoField = new JTextField();
        tipoField.setBounds(110, 340, 200, 30);
        tipoField.setFont(new Font("Arial", 0, 20));
        tipoField.setBackground(new Color(185, 180, 180));
        tipoField.setColumns(1);
        panelDatosUpdate.add(tipoField);

        JButton actualizar = new JButton("Actualizar");
        actualizar.setBackground(new Color(110, 149, 0));
        actualizar.setForeground(Color.WHITE);
        actualizar.setFont(new Font("Times New Roman", 1, 30));
        actualizar.setBounds(430, 340, 200, 100);
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String calle = calleField.getText();
                String carrera = carreraField.getText();
                String correo = correoField.getText();
                String telefono = TelefonoField.getText();
                String barrio = ComunaField.getText();
                String municipio = MunicipioField.getText();
                String tipoStr = tipoField.getText();
                String id = idClientInfo.getText();
                Clientes cliente = new Clientes(Integer.parseInt(id),nombre, apellido, calle, carrera,barrio,municipio,telefono,correo, Integer.parseInt(tipoStr));
                nombreFieldInfo.setText(nombre);
                apellidoFieldINfo.setText(apellido);
                calleFieldInfo.setText(calle);
                carreraFieldInfo.setText(carrera);
                correoFieldInfo.setText(correo);
                TelefonoFieldINfo.setText(telefono);
                MunicipioFieldInfo.setText(municipio);
                ComunaFieldInfo.setText(barrio);
                tiposFieldInfo.setText(tipoStr);
                idClientInfo.setText(id);
            }
        });
        panelDatosUpdate.add(actualizar);


        JPanel lineDiv = new JPanel();
        lineDiv.setBackground(Color.BLACK);
        lineDiv.setBounds(790, 140, 10, 470);
        panelFondo.add(lineDiv);

        JButton botonEnviar = new JButton("Enviar:)");
        botonEnviar.setBackground(new Color(110, 149, 0));
        botonEnviar.setForeground(Color.WHITE);
        botonEnviar.setFont(new Font("Times New Roman", 1, 30));
        botonEnviar.setBounds(630, 625, 300, 150);
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreFieldInfo.getText();
                String apellido = apellidoFieldINfo.getText();
                String calle = calleFieldInfo.getText();
                String carrera = carreraFieldInfo.getText();
                String correo = correoFieldInfo.getText();
                String telefono = TelefonoFieldINfo.getText();
                String barrio = ComunaFieldInfo.getText();
                String municipio = MunicipioFieldInfo.getText();
                String tipoStr = tiposFieldInfo.getText();
                String id = idClientInfo.getText();
                Clientes cliente = new Clientes(Integer.parseInt(id),nombre, apellido, calle, carrera,barrio,municipio,telefono,correo, Integer.parseInt(tipoStr));
                try {
                    if(ModeloLogin.clienteOperador.editClient(cliente)){
                        setVisible(false);
                        JOptionPane.showMessageDialog(null,  "se edito el cliente"+ cliente.getCorreo());
                        MenuOperador men = new MenuOperador();
                        men.setVisible(true);

                    }
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panelFondo.add(botonEnviar);

        JButton botRegresar = new JButton("Regresate:)");
        botRegresar.setBackground(new Color(153, 2, 68));
        botRegresar.setForeground(Color.WHITE);
        botRegresar.setFont(new Font("Times New Roman", 1, 30));
        botRegresar.setBounds(100, 625, 200, 100);
        botRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MenuOperador men = new MenuOperador();
                men.setVisible(true);
            }
        });
        panelFondo.add(botRegresar);
    }


}
