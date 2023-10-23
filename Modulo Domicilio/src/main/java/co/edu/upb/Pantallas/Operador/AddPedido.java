package co.edu.upb.Pantallas.Operador;

import javax.swing.*;
import java.awt.*;

public class AddPedido extends JFrame {
    String nombreChange = "";
    String apellidoChange = "";
    String preViewPedidoStr = "";

    JLabel muestraPreView = new JLabel();

    public AddPedido (){
    initOperatorAddPedido();
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}

    public void initOperatorAddPedido() {
        setTitle("Add Pedido");
        setBounds(0, 0, 1500, 1000);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0, 0, 1500, 1000);
        panelFondo.setBackground(new Color(64, 93, 128));
        setContentPane(panelFondo);
        setLayout(null);

        JLabel labelTitulo = new JLabel("Añadir Pedido ");
        labelTitulo.setForeground(Color.WHITE);
        labelTitulo.setFont(new Font("Times New Roman", 1, 50));
        labelTitulo.setBounds(70, 20, 500, 100);
        panelFondo.add(labelTitulo);
        JLabel labelBuscar = new JLabel("Buscar producto ");
        labelBuscar.setForeground(Color.WHITE);
        labelBuscar.setFont(new Font("Times New Roman", 1, 30));
        labelBuscar.setBounds(800, 20, 400, 100);
        panelFondo.add(labelBuscar);
        JTextField busquedaField = new JTextField();
        busquedaField.setBounds(1070, 50, 350, 50);
        busquedaField.setFont(new Font("Arial", 0, 20));
        busquedaField.setBackground(new Color(110, 149, 0));
        busquedaField.setColumns(1);
        panelFondo.add(busquedaField);

        JButton botonEnviar = new JButton("Enviar:)");
        botonEnviar.setBackground(new Color(110, 149, 0));
        botonEnviar.setForeground(Color.WHITE);
        botonEnviar.setFont(new Font("Times New Roman", 1, 30));
        botonEnviar.setBounds(530, 625, 300, 150);
        panelFondo.add(botonEnviar);

        JPanel panelDatos = new JPanel();
        panelDatos.setBackground(new Color(87, 122, 147));
        panelDatos.setBounds(1000, 150, 450, 600);
        panelFondo.add(panelDatos);
        panelDatos.setLayout(null);

        JLabel cantProdct = new JLabel("Cantidad del prducto: ");
        cantProdct.setForeground(Color.WHITE);
        cantProdct.setFont(new Font("Arial", 1, 15));
        cantProdct.setBounds(20,100,200,50);
        panelDatos.add(cantProdct);
        JTextField cantProdutField = new JTextField();
        cantProdutField.setBounds(210, 110, 200, 30);
        cantProdutField.setFont(new Font("Arial", 0, 20));
        cantProdutField.setBackground(new Color(185, 180, 180));
        cantProdutField.setColumns(1);
        panelDatos.add(cantProdutField);

        JPanel panPre = new JPanel();
        panPre.setBounds(10, 290, 430, 300);
        panPre.setBackground(new Color(149, 143, 0));
        panelDatos.add(panPre);
        panPre.setLayout(null);

        JLabel preViewPedido = new JLabel("PreView-Pedido");
        preViewPedido.setBounds(150, 10, 200, 50);
        preViewPedido.setFont(new Font("Arial", Font.BOLD, 20));
        preViewPedido.setForeground(Color.BLACK);
        panPre.add(preViewPedido);

        String preViewPedidoStr = "Hamburguesa, cant= 2" + ", Perro Pingu, cant= 1" + ", Pipipicada, cant= 5";

        JLabel muestraPreView = new JLabel(preViewPedidoStr);
        muestraPreView.setForeground(Color.BLACK);
        muestraPreView.setFont(new Font("Arial", Font.PLAIN, 15));
        muestraPreView.setBounds(10, 50, 600, 50);
        panPre.add(muestraPreView);


        JPanel panelDatosUpdate = new JPanel();
        panelDatosUpdate.setBackground(new Color(87, 122, 147));
        panelDatosUpdate.setBounds(50, 150, 800, 450);
        panelFondo.add(panelDatosUpdate);
        panelDatosUpdate.setLayout(null);

        JPanel lineDiv = new JPanel();
        lineDiv.setBackground(Color.BLACK);
        lineDiv.setBounds(925, 140, 10, 470);
        panelFondo.add(lineDiv);

        /*

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
        nombreFieldInfo.setBounds(110, 70, 200, 30);
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
*/

        /*
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

        JButton actualizar = new JButton("Actualizar");
        actualizar.setBackground(new Color(110, 149, 0));
        actualizar.setForeground(Color.WHITE);
        actualizar.setFont(new Font("Times New Roman", 1, 30));
        actualizar.setBounds(250, 340, 200, 100);
        panelDatosUpdate.add(actualizar);
*/

    }
}
