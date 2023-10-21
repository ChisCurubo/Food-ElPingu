package co.edu.upb.Pantallas.Operador;

import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.Pantallas.Administrador.MenuAdmin;
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
    DoubleLinkedList<PedidosDetalle> listPed ;

    JLabel muestraPreView = new JLabel();

    public static void main(String[] args) {
        AddPedido ped = new AddPedido();
    }

    public AddPedido() {
        listPed = new DoubleLinkedList<>();
        initOperatorAddPedido();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\logo (Pequeño).jpg").getImage());
    }

    Pedido pedido;
    Menu menu = new Menu();
    PedidosDetalle pedidosDetalle;

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
                JOptionPane.showMessageDialog(null, "se ingreso el pedido a la cola");
                setVisible(false);
                Factura fact = new Factura(listPed);
                fact.setVisible(true);
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
                    DoubleLinkedList<Menu> lisdistancia = ModeloLogin.clienteOperador.algortmoHammil(text);
                    busquedaProduct.setText(lisdistancia.get().getProduct());
                    pedidosDetalle = new PedidosDetalle();
                    pedidosDetalle.setIdProducto(lisdistancia.get().getIdProducto());
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
        muestraPreView.setEditable(false);
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
                try {
                    if(ModeloLogin.clienteOperador.login(ModeloLogin.email,ModeloLogin.contra) == 0 ){
                        MenuOperador men = new MenuOperador();
                        men.setVisible(true);
                    }else{
                        MenuAdmin men = new MenuAdmin();
                        men.setVisible(true);
                    }
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        panelFondo.add(botRegresar);

        JPanel panelDatosUpdate = new JPanel();
        panelDatosUpdate.setBackground(new Color(87, 122, 147));
        panelDatosUpdate.setBounds(50, 150, 800, 450);
        panelFondo.add(panelDatosUpdate);
        panelDatosUpdate.setLayout(null);

         panelDatosUpdate.add(panelHamburguesa(10,10));

        JPanel lineDiv = new JPanel();
        lineDiv.setBackground(Color.BLACK);
        lineDiv.setBounds(925, 140, 10, 470);
        panelFondo.add(lineDiv);


    }

    public JPanel panelHamburguesa(int x , int y){
        JPanel panelhamburguesa = new JPanel();
        panelhamburguesa.setBounds(x,y,300,300);
        panelhamburguesa.setBackground(new Color(87, 122, 147));
        panelhamburguesa.setLayout(null);

        JLabel labelHambur = new JLabel("Hamburguesa");
        labelHambur.setBounds(10, 250, 150, 15);
        labelHambur.setFont(new Font("Arial", Font.BOLD, 15));
        labelHambur.setForeground(Color.BLACK);
        panelhamburguesa.add(labelHambur);

        JLabel labelPrice = new JLabel("Precio");
        labelPrice.setBounds(10, 270, 150, 15);
        labelPrice.setFont(new Font("Arial", Font.BOLD, 15));
        labelPrice.setForeground(Color.BLACK);
        panelhamburguesa.add(labelPrice);
        return panelhamburguesa;

    }
}
