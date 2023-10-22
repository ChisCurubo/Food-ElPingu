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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Iterator;

public class AddPedido extends JFrame {
    String nombreChange = "";
    String apellidoChange = "";
    String preViewPedidoStr = "";
    DoubleLinkedList<PedidosDetalle> listPed ;
    JTextField cantProdutField = new JTextField() ;
    JTextField busquedaProduct = new JTextField();

    DoubleLinkedList<JPanel> paneles =  new DoubleLinkedList<>();

    JLabel muestraPreView = new JLabel();
    int contBot = 0;

    public static void main(String[] args) {
        ModeloLogin  modeloLogin = new ModeloLogin();
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

        JPanel panelComidaMasPedida = new JPanel();
        panelComidaMasPedida.setBackground(new Color(77, 101, 0));
        panelComidaMasPedida.setBounds(1025, 325, 400, 100);
        panelComidaMasPedida.setLayout(null);
        panelFondo.add(panelComidaMasPedida);
        JLabel labelPedidoInfo = new JLabel();
        labelPedidoInfo.setForeground(Color.WHITE);
        labelPedidoInfo.setFont(new Font("Times New Roman", 1, 20));
        labelPedidoInfo.setBounds(10, 10, 200, 30);
        labelPedidoInfo.setText("Pedido mas frecuente : ");
        panelComidaMasPedida.add(labelPedidoInfo);
        JLabel labelPedido = new JLabel();
        labelPedido.setForeground(Color.WHITE);
        labelPedido.setFont(new Font("Times New Roman", 1, 20));
        labelPedido.setBounds(50, 50, 150, 30);
        panelComidaMasPedida.add(labelPedido);


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
                    Menu men = ModeloLogin.clienteOperador.getMostPedidoClient(pedido.getNmpedido());
                    labelPedido.setText(men.getProduct() + " " + men.getIdProducto());

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
                try {
                    ModeloLogin.clienteOperador.createGrafo();
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
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



        JLabel cantProdct = new JLabel("Cantidad del prducto: ");
        cantProdct.setForeground(Color.WHITE);
        cantProdct.setFont(new Font("Arial", 1, 15));
        cantProdct.setBounds(20, 100, 200, 50);
        panelDatos.add(cantProdct);
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
        panelDatosUpdate.setBackground(new Color(34, 98, 143));
        panelDatosUpdate.setLayout(null);

// Adjust the preferred size of panelDatosUpdate to accommodate your content
        panelDatosUpdate.setPreferredSize(new Dimension(800, 1000));

        JScrollPane jScrollPaneMenu = new JScrollPane(panelDatosUpdate);
        jScrollPaneMenu.setBounds(50, 150, 800, 430);
        jScrollPaneMenu.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneMenu.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

// Add components to panelDatosUpdate
        panelDatosUpdate.add(panelHamburguesa(10, 10));
        panelDatosUpdate.add(panelCrayPotatoe(300, 10));
        panelDatosUpdate.add(panelHamburguesaPingu(10, 250));
        panelDatosUpdate.add(panelHotPerro(300, 250));
        panelDatosUpdate.add(panelPepito(10, 490));
        panelDatosUpdate.add(panelPicana(300, 490));
        panelDatosUpdate.add(panelSanwich(10, 730));
        panelDatosUpdate.add(panelPipicada(300, 730));

        panelDatosUpdate.revalidate();
        panelDatosUpdate.repaint();

        JLabel Prodct = new JLabel("Buscar Producto: ");
        Prodct.setForeground(Color.WHITE);
        Prodct.setFont(new Font("Arial", 1, 15));
        Prodct.setBounds(20, 10, 200, 50);
        panelDatos.add(Prodct);


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

                    Iterator iter = lisdistancia.iteratorObj();
                    int cont = 1;
                    int x = 10;
                    int y = 10;
                    while (iter.hasNext()){
                        Menu men = (Menu) iter.next();
                        if(cont % 2 == 0) {
                            panelesSwitc(men.getProduct(), x, y);
                            y += 240;
                        }else{
                            panelesSwitc(men.getProduct(), x, y);
                            y += 240;
                        }
                            cont++;
                    }
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

        panelFondo.add(jScrollPaneMenu);

        JPanel lineDiv = new JPanel();
        lineDiv.setBackground(Color.BLACK);
        lineDiv.setBounds(925, 140, 10, 470);
        panelFondo.add(lineDiv);



    }

    public JPanel panelesSwitc(String str, int x , int y){

        switch (str){
            case "Hamburguesa": return panelHamburguesa(x,y);
            case "Crazy Potato": return panelCrayPotatoe(x,y);
            case "Hot Perro": return panelHotPerro(x,y);
            case "Hamburguesa ElPingu": return panelHamburguesaPingu(x,y);
            case "Pepito": return panelPepito(x,y);
            case "Sanwich": return panelSanwich(x,y);
            case "Pipipicada": return panelPipicada(x,y);
            case "Picaña": return panelPicana(x,y);
        }
        return new JPanel();
    }

    public JPanel panelHamburguesa(int x , int y){
        contBot = 0;
        JPanel panelhamburguesa = new JPanel();
        panelhamburguesa.setBounds(x,y,200,200);
        panelhamburguesa.setBackground(new Color(143, 0, 60));
        panelhamburguesa.setLayout(null);

        JLabel labelHambur = new JLabel("Hamburguesa");
        labelHambur.setBounds(5, 5, 150, 15);
        labelHambur.setFont(new Font("Arial", Font.BOLD, 15));
        labelHambur.setForeground(Color.BLACK);
        labelHambur.setVisible(true);
        panelhamburguesa.add(labelHambur);

        JLabel labelPrice = new JLabel("23000");
        labelPrice.setBounds(5, 20, 150, 15);
        labelPrice.setFont(new Font("Arial", Font.BOLD, 15));
        labelPrice.setForeground(Color.BLACK);
        panelhamburguesa.add(labelPrice);
        labelPrice.setVisible(true);

        panelhamburguesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contBot++;
                cantProdutField.setText(String.valueOf(contBot));
                busquedaProduct.setText("Hamburguesa");
            }
        });


        JLabel image  = new JLabel();
        image.setIcon(new javax.swing.ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\Hambur (Personalizado).jpg"));
        image.setBounds(10,45,180,150);
        panelhamburguesa.add(image);
        panelhamburguesa.setVisible(true);
        panelhamburguesa.revalidate();
        panelhamburguesa.repaint();
        return panelhamburguesa;

    }

    public JPanel panelHamburguesaPingu(int x , int y){
        contBot = 0;
        JPanel panelhamburguesa = new JPanel();
        panelhamburguesa.setBounds(x,y,200,200);
        panelhamburguesa.setBackground(new Color(143, 0, 60));
        panelhamburguesa.setLayout(null);

        JLabel labelHambur = new JLabel("Hamburguesa ElPingü");
        labelHambur.setBounds(5, 5, 150, 15);
        labelHambur.setFont(new Font("Arial", Font.BOLD, 15));
        labelHambur.setForeground(Color.BLACK);
        labelHambur.setVisible(true);
        panelhamburguesa.add(labelHambur);

        JLabel labelPrice = new JLabel("30000");
        labelPrice.setBounds(5, 20, 150, 15);
        labelPrice.setFont(new Font("Arial", Font.BOLD, 15));
        labelPrice.setForeground(Color.BLACK);
        panelhamburguesa.add(labelPrice);
        labelPrice.setVisible(true);

        JLabel image  = new JLabel();
        image.setIcon(new javax.swing.ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\CrazyHamburguer (Personalizado).jpg"));
        image.setBounds(10,45,180,150);
        panelhamburguesa.add(image);
        panelhamburguesa.setVisible(true);
        panelhamburguesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contBot++;
                cantProdutField.setText(String.valueOf(contBot));
                busquedaProduct.setText("Crazy Potato");
            }
        });

        panelhamburguesa.revalidate();
        panelhamburguesa.repaint();
        return panelhamburguesa;

    }

    public JPanel panelCrayPotatoe(int x , int y){
        contBot = 0;
        JPanel panelhamburguesa = new JPanel();
        panelhamburguesa.setBounds(x,y,200,200);
        panelhamburguesa.setBackground(new Color(143, 0, 60));
        panelhamburguesa.setLayout(null);

        JLabel labelHambur = new JLabel("Crazy Potato");
        labelHambur.setBounds(5, 5, 150, 15);
        labelHambur.setFont(new Font("Arial", Font.BOLD, 15));
        labelHambur.setForeground(Color.BLACK);
        labelHambur.setVisible(true);
        panelhamburguesa.add(labelHambur);

        JLabel labelPrice = new JLabel("18000");
        labelPrice.setBounds(5, 20, 150, 15);
        labelPrice.setFont(new Font("Arial", Font.BOLD, 15));
        labelPrice.setForeground(Color.BLACK);
        panelhamburguesa.add(labelPrice);
        panelhamburguesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contBot++;
                cantProdutField.setText(String.valueOf(contBot));
                busquedaProduct.setText("Crazy Potato");
            }
        });
        labelPrice.setVisible(true);

        JLabel image  = new JLabel();
        image.setIcon(new javax.swing.ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\CrazyPotato (Personalizado).jpg"));
        image.setBounds(10,45,180,150);
        panelhamburguesa.add(image);
        panelhamburguesa.setVisible(true);
        panelhamburguesa.revalidate();
        panelhamburguesa.repaint();
        return panelhamburguesa;

    }

    public JPanel panelHotPerro(int x , int y){
        contBot = 0;
        JPanel panelhamburguesa = new JPanel();
        panelhamburguesa.setBounds(x,y,200,200);
        panelhamburguesa.setBackground(new Color(143, 0, 60));
        panelhamburguesa.setLayout(null);

        JLabel labelHambur = new JLabel("Hot Perro");
        labelHambur.setBounds(5, 5, 150, 15);
        labelHambur.setFont(new Font("Arial", Font.BOLD, 15));
        labelHambur.setForeground(Color.BLACK);
        labelHambur.setVisible(true);
        panelhamburguesa.add(labelHambur);

        JLabel labelPrice = new JLabel("18000");
        labelPrice.setBounds(5, 20, 150, 15);
        labelPrice.setFont(new Font("Arial", Font.BOLD, 15));
        labelPrice.setForeground(Color.BLACK);
        panelhamburguesa.add(labelPrice);
        panelhamburguesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contBot++;
                cantProdutField.setText(String.valueOf(contBot));
                busquedaProduct.setText("Hot Perro");
            }
        });
        labelPrice.setVisible(true);

        JLabel image  = new JLabel();
        image.setIcon(new javax.swing.ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\CrazyPotato (Personalizado).jpg"));
        image.setBounds(10,45,180,150);
        panelhamburguesa.add(image);
        panelhamburguesa.setVisible(true);
        panelhamburguesa.revalidate();
        panelhamburguesa.repaint();
        return panelhamburguesa;
    }

    public JPanel panelPepito(int x , int y){
        contBot = 0;
        JPanel panelhamburguesa = new JPanel();
        panelhamburguesa.setBounds(x,y,200,200);
        panelhamburguesa.setBackground(new Color(143, 0, 60));
        panelhamburguesa.setLayout(null);

        JLabel labelHambur = new JLabel("Pepito");
        labelHambur.setBounds(5, 5, 150, 15);
        labelHambur.setFont(new Font("Arial", Font.BOLD, 15));
        labelHambur.setForeground(Color.BLACK);
        labelHambur.setVisible(true);
        panelhamburguesa.add(labelHambur);

        JLabel labelPrice = new JLabel("18000");
        labelPrice.setBounds(5, 20, 150, 15);
        labelPrice.setFont(new Font("Arial", Font.BOLD, 15));
        labelPrice.setForeground(Color.BLACK);
        panelhamburguesa.add(labelPrice);
        panelhamburguesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contBot++;
                cantProdutField.setText(String.valueOf(contBot));
                busquedaProduct.setText("Pepito");
            }
        });
        labelPrice.setVisible(true);

        JLabel image  = new JLabel();
        image.setIcon(new javax.swing.ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\Pepito (Personalizado).jpg"));
        image.setBounds(10,45,180,150);
        panelhamburguesa.add(image);
        panelhamburguesa.setVisible(true);
        panelhamburguesa.revalidate();
        panelhamburguesa.repaint();
        return panelhamburguesa;
    }

    public JPanel panelSanwich(int x , int y){
        contBot = 0;
        JPanel panelhamburguesa = new JPanel();
        panelhamburguesa.setBounds(x,y,200,200);
        panelhamburguesa.setBackground(new Color(143, 0, 60));
        panelhamburguesa.setLayout(null);

        JLabel labelHambur = new JLabel("Sanwich");
        labelHambur.setBounds(5, 5, 150, 15);
        labelHambur.setFont(new Font("Arial", Font.BOLD, 15));
        labelHambur.setForeground(Color.BLACK);
        labelHambur.setVisible(true);
        panelhamburguesa.add(labelHambur);

        JLabel labelPrice = new JLabel("15000");
        labelPrice.setBounds(5, 20, 150, 15);
        labelPrice.setFont(new Font("Arial", Font.BOLD, 15));
        labelPrice.setForeground(Color.BLACK);
        panelhamburguesa.add(labelPrice);
        panelhamburguesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contBot++;
                cantProdutField.setText(String.valueOf(contBot));
                busquedaProduct.setText("Sanwich");            }
        });

        labelPrice.setVisible(true);

        JLabel image  = new JLabel();
        image.setIcon(new javax.swing.ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\Sanwich (Personalizado).jpg"));
        image.setBounds(10,45,180,150);
        panelhamburguesa.add(image);
        panelhamburguesa.setVisible(true);
        panelhamburguesa.revalidate();
        panelhamburguesa.repaint();
        return panelhamburguesa;
    }

    public JPanel panelPipicada(int x , int y){
        contBot = 0;
        JPanel panelhamburguesa = new JPanel();
        panelhamburguesa.setBounds(x,y,200,200);
        panelhamburguesa.setBackground(new Color(143, 0, 60));
        panelhamburguesa.setLayout(null);

        JLabel labelHambur = new JLabel("Pipipicada");
        labelHambur.setBounds(5, 5, 150, 15);
        labelHambur.setFont(new Font("Arial", Font.BOLD, 15));
        labelHambur.setForeground(Color.BLACK);
        labelHambur.setVisible(true);
        panelhamburguesa.add(labelHambur);

        JLabel labelPrice = new JLabel("40000");
        labelPrice.setBounds(5, 20, 150, 15);
        labelPrice.setFont(new Font("Arial", Font.BOLD, 15));
        labelPrice.setForeground(Color.BLACK);
        panelhamburguesa.add(labelPrice);
        panelhamburguesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contBot++;
                cantProdutField.setText(String.valueOf(contBot));
                busquedaProduct.setText("Pipipicada");
            }
        });

        labelPrice.setVisible(true);

        JLabel image  = new JLabel();
        image.setIcon(new javax.swing.ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\Picada (Personalizado).jpg"));
        image.setBounds(10,45,180,150);
        panelhamburguesa.add(image);
        panelhamburguesa.setVisible(true);
        panelhamburguesa.revalidate();
        panelhamburguesa.repaint();
        return panelhamburguesa;
    }

    public JPanel panelPicana(int x , int y){
        contBot = 0;
        JPanel panelhamburguesa = new JPanel();
        panelhamburguesa.setBounds(x,y,200,200);
        panelhamburguesa.setBackground(new Color(143, 0, 60));
        panelhamburguesa.setLayout(null);

        JLabel labelHambur = new JLabel("Picaña");
        labelHambur.setBounds(5, 5, 150, 15);
        labelHambur.setFont(new Font("Arial", Font.BOLD, 15));
        labelHambur.setForeground(Color.BLACK);
        labelHambur.setVisible(true);
        panelhamburguesa.add(labelHambur);

        JLabel labelPrice = new JLabel("55000");
        labelPrice.setBounds(5, 20, 150, 15);
        labelPrice.setFont(new Font("Arial", Font.BOLD, 15));
        labelPrice.setForeground(Color.BLACK);
        panelhamburguesa.add(labelPrice);
        panelhamburguesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contBot++;
                cantProdutField.setText(String.valueOf(contBot));
                busquedaProduct.setText("Picaña");
            }
        });
        labelPrice.setVisible(true);

        JLabel image  = new JLabel();
        image.setIcon(new javax.swing.ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\Picana (Personalizado).jpg"));
        image.setBounds(10,45,180,150);
        panelhamburguesa.add(image);
        panelhamburguesa.setVisible(true);
        panelhamburguesa.revalidate();
        panelhamburguesa.repaint();
        return panelhamburguesa;
    }
}
