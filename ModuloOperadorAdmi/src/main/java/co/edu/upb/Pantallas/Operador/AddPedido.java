package co.edu.upb.Pantallas.Operador;

import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.domain.Menu;
import co.edu.upb.domain.Pedido;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AddPedido extends JFrame {
    String nombreChange = "";
    String apellidoChange = "";
    String preViewPedidoStr = "";
    DoubleLinkedList<PedidosDetalle> listPed;

    JLabel muestraPreView = new JLabel();

    public static void main(String[] args) {
        AddPedido ped = new AddPedido();
    }

    public AddPedido() {
        initOperatorAddPedido();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\logo (Pequeño).jpg").getImage());
    }

    Pedido pedido;
    Menu menu = new Menu();
    PedidosDetalle pedidosDetalle = new PedidosDetalle();

    public void initOperatorAddPedido() {
        listPed = new DoubleLinkedList<>();
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

        JPanel panelnumPed = new JPanel();
        panelnumPed.setBackground(new Color(77, 101, 0));
        panelnumPed.setBounds(1300, 120, 50, 50);
        panelnumPed.setLayout(null);
        panelFondo.add(panelnumPed);
        JLabel labelNumPed = new JLabel();
        labelNumPed.setForeground(Color.WHITE);
        labelNumPed.setFont(new Font("Times New Roman", 1, 30));
        labelNumPed.setBounds(10, 10, 50, 30);
        panelnumPed.add(labelNumPed);


        JLabel labelBuscar = new JLabel("Buscar Cliente ");
        labelBuscar.setForeground(Color.WHITE);
        labelBuscar.setFont(new Font("Times New Roman", 1, 30));
        labelBuscar.setBounds(800, 20, 400, 100);
        panelFondo.add(labelBuscar);
        JTextField busquedaField = new JTextField();
        busquedaField.setBounds(1070, 50, 350, 50);
        busquedaField.setFont(new Font("Arial", 0, 20));
        busquedaField.setBackground(new Color(110, 149, 0));
        busquedaField.setColumns(1);
        busquedaField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = busquedaField.getText();
                try {
                    String idCli = ModeloLogin.clienteOperador.bringCliente(text);
                    LocalDateTime locDa = LocalDateTime.now();
                    Timestamp sqlDate = Timestamp.valueOf(locDa);
                    String idPedido = ModeloLogin.clienteOperador.selectPedido(Integer.parseInt(idCli));
                    pedido = new Pedido(Integer.parseInt(idPedido), Integer.parseInt(idCli), sqlDate, "Pedido");
                    labelNumPed.setText(idPedido);

                    if (ModeloLogin.clienteOperador.addPedido(pedido)) {
                        JOptionPane.showMessageDialog(null, "Se ha creado un pedido ingrese  lo que desea ordenar" + pedido.getNmpedido());
                        pedido.setNmpedido(Integer.parseInt(ModeloLogin.clienteOperador.selectPedido(Integer.parseInt(idCli))));
                    }

                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panelFondo.add(busquedaField);



        JButton botonEnviar = new JButton("Enviar:)");
        botonEnviar.setBackground(new Color(110, 149, 0));
        botonEnviar.setForeground(Color.WHITE);
        botonEnviar.setFont(new Font("Times New Roman", 1, 30));
        botonEnviar.setBounds(330, 625, 300, 150);
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while (!listPed.isEmpty()) {
                    try {
                        ModeloLogin.clienteOperador.addPedidoDetalle(listPed.pop());
                    } catch (RemoteException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                JOptionPane.showMessageDialog(null, "se ingreso el pedido a la cola");
                setVisible(false);

                MenuOperador men = new MenuOperador();
                men.setVisible(true);
            }
        });
        panelFondo.add(botonEnviar);

        JPanel panelDatos = new JPanel();
        panelDatos.setBackground(new Color(87, 122, 147));
        panelDatos.setBounds(1000, 150, 450, 600);
        panelFondo.add(panelDatos);
        panelDatos.setLayout(null);

        JLabel Prodct = new JLabel("Buscar Producto: ");
        Prodct.setForeground(Color.WHITE);
        Prodct.setFont(new Font("Arial", 1, 15));
        Prodct.setBounds(20, 10, 200, 50);
        panelDatos.add(Prodct);

        JTextField busquedaProduct = new JTextField();
        busquedaProduct.setBounds(50, 50, 350, 30);
        busquedaProduct.setFont(new Font("Arial", 0, 20));
        busquedaProduct.setBackground(new Color(110, 149, 0));
        busquedaProduct.setColumns(1);
        busquedaProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = busquedaProduct.getText();
                try {
                    String idCli = ModeloLogin.clienteOperador.selectProducto(text);
                    pedidosDetalle = new PedidosDetalle();
                    pedidosDetalle.setIdProducto(Integer.parseInt(idCli));
                    JOptionPane.showMessageDialog(null, pedidosDetalle.getIdProducto());

                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panelDatos.add(busquedaProduct);

        JLabel cantProdct = new JLabel("Cantidad del prducto: ");
        cantProdct.setForeground(Color.WHITE);
        cantProdct.setFont(new Font("Arial", 1, 15));
        cantProdct.setBounds(20, 100, 200, 50);
        panelDatos.add(cantProdct);
        JTextField cantProdutField = new JTextField();
        cantProdutField.setBounds(210, 110, 200, 30);
        cantProdutField.setFont(new Font("Arial", 0, 20));
        cantProdutField.setBackground(new Color(185, 180, 180));
        cantProdutField.setColumns(1);
        cantProdutField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cant = cantProdutField.getText();
                JOptionPane.showMessageDialog(null, cant);
                pedidosDetalle.setIdPedidos(pedido.getNmpedido());
                pedidosDetalle.setCantidad(Integer.parseInt(cant));
                pedidosDetalle.setIdPedidos(Integer.parseInt(labelNumPed.getText()));
                pedidosDetalle.setEstatuPedido("Cola");
            }
        });
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


        TextArea muestraPreView = new TextArea(preViewPedidoStr);
        muestraPreView.setForeground(Color.BLACK);
        muestraPreView.setBackground(new Color(149, 143, 0));
        muestraPreView.setFont(new Font("Arial", Font.PLAIN, 15));
        muestraPreView.setBounds(10, 60, 400, 200);
        panPre.add(muestraPreView);

        JButton anadirPedido = new JButton("AddPedido:)");
        anadirPedido.setBackground(new Color(110, 149, 0));
        anadirPedido.setForeground(Color.WHITE);
        anadirPedido.setFont(new Font("Times New Roman", 1, 30));
        anadirPedido.setBounds(700, 625, 200, 100);
        anadirPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listPed.add(pedidosDetalle);
                preViewPedidoStr = listPed.imprimir();
                muestraPreView.setText(preViewPedidoStr);

                cantProdutField.setText("");
                busquedaProduct.setText("");
            }
        });
        panelFondo.add(anadirPedido);


        JButton botRegresar = new JButton("Regresaté");
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
