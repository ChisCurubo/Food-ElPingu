package co.edu.upb.Pantallas.Operador;

import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.Pantallas.Administrador.MenuAdmin;
import co.edu.upb.domain.Clientes;
import co.edu.upb.domain.Menu;
import co.edu.upb.domain.Pedido;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.listas.DoubleLinkedList;
import co.edu.upb.estructuras.listas.DoubleListNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Iterator;
/**
 * Pantalla de la factura del cliente
 *@author ChristianRodriguez
 */
public class Factura extends JFrame {


    public static void main(String[] args) {
        Factura ped = new Factura();
    }

    public static DoubleLinkedList<PedidosDetalle> listPed = new DoubleLinkedList<>();
    JTextArea textArea;

    public Factura() {
        System.out.println(listPed.get());
        initOperatorAddPedido(listPed);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\logo (Pequeño).jpg").getImage());
    }

    public Factura(DoubleLinkedList<PedidosDetalle> listD) {
        listPed = listD;
        initOperatorAddPedido(listD);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\logo (Pequeño).jpg").getImage());
    }

    Pedido pedido;
    co.edu.upb.domain.Menu menu = new Menu();
    PedidosDetalle pedidosDetalle = new PedidosDetalle();

    public void initOperatorAddPedido(DoubleLinkedList<PedidosDetalle> listD) {
        setTitle("Factura");
        setBounds(0, 0, 800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0, 0, 800, 600);
        panelFondo.setBackground(new Color(64, 93, 128));
        setContentPane(panelFondo);
        setLayout(null);

        JLabel labelTitulo = new JLabel("Factura Orden");
        labelTitulo.setForeground(Color.WHITE);
        labelTitulo.setFont(new Font("Times New Roman", 1, 40));
        labelTitulo.setBounds(30, 10, 300, 50);
        panelFondo.add(labelTitulo);

        JPanel panelnumPed = new JPanel();
        panelnumPed.setBackground(new Color(164, 178, 131));
        panelnumPed.setBounds(400, 175, 250, 300);
        panelnumPed.setLayout(null);
        panelFondo.add(panelnumPed);
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(5, 5, 400, 390);
        textArea.setBackground(new Color(164, 178, 131));
        textArea.setFont(new Font("Times New Roman", 0, 15));
        textArea.setText("Total de productos: " + listD.size() + "\n" + "\nLista de productos y cantidad : " + "\n" + listPrintArea(listD));
        panelnumPed.add(textArea);


        JPanel panelDatos = new JPanel();
        panelDatos.setBackground(new Color(87, 122, 147));
        panelDatos.setBounds(50, 90, 700, 450);
        panelFondo.add(panelDatos);
        panelDatos.setLayout(null);

        JLabel Prodct = new JLabel("La factura del cliente ");
        Prodct.setForeground(Color.WHITE);
        Prodct.setFont(new Font("Arial", 1, 25));
        Prodct.setBounds(50, 100, 300, 50);
        panelDatos.add(Prodct);

        JLabel idDelPedido = new JLabel();
        idDelPedido.setForeground(Color.WHITE);
        idDelPedido.setFont(new Font("Arial", 1, 20));
        idDelPedido.setBounds(80, 200, 300, 30);
        idDelPedido.setText("Id del pedido: " + listD.get().getIdPedidos());
        panelDatos.add(idDelPedido);

        JLabel ClienteMane = new JLabel();
        ClienteMane.setForeground(Color.WHITE);
        ClienteMane.setFont(new Font("Arial", 1, 20));
        ClienteMane.setBounds(50, 300, 300, 30);
        try {
            Pedido sr = ModeloLogin.clienteOperador.selectIdPedido(listD.get().getIdPedidos());
            System.out.println(sr);
            Clientes cli = ModeloLogin.clienteOperador.selctCliennte(sr.getIdClientes());
            ClienteMane.setText("Nombre Cliente: " + cli.getNombre());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        panelDatos.add(ClienteMane);


        JButton botRegresar = new JButton("Regresaté");
        botRegresar.setBackground(new Color(153, 2, 68));
        botRegresar.setForeground(Color.WHITE);
        botRegresar.setFont(new Font("Times New Roman", 1, 30));
        botRegresar.setBounds(125, 400, 200, 50);
        botRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Iterator<PedidosDetalle> iter = listD.iteratorObj();
                while (iter.hasNext()) {
                    try {
                        PedidosDetalle pediTemp = iter.next();
                        if (ModeloLogin.clienteOperador.addPedidoDetalle(pediTemp)) {
                            System.out.println("se agrego ");
                        }
                    } catch (RemoteException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                try {
                    if (ModeloLogin.clienteOperador.login(ModeloLogin.email, ModeloLogin.contra) == 0) {
                        MenuOperador men = new MenuOperador();
                        men.setVisible(true);
                    } else {
                        MenuAdmin admin = new MenuAdmin();
                        admin.setVisible(true);
                    }
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        panelDatos.add(botRegresar);
    }

    private String listPrintArea(DoubleLinkedList<PedidosDetalle> listD) {
        double total = 0;
        PedidosDetalle pedi;
        String str = "";
        Iterator<PedidosDetalle> iter = listD.iteratorObj();
        while (iter.hasNext()) {
            try {
                PedidosDetalle pediTemp = iter.next();
                Menu men = ModeloLogin.clienteOperador.selectProuctId(pediTemp.getIdProducto());
                str += men.getProduct() + "  Precio : " + men.getPrecio() + "\n";
                total += men.getPrecio();
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }
        double impt = total * 0.08;
        double totalImp = total + impt;
        double valorDomi = 0;
        Clientes clien = getCliente(listD.get());
        try {
            valorDomi = ModeloLogin.clienteOperador.getrValorDomiOp(clien.getBarrio());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        double totalMasDomi = totalImp + valorDomi;
        str += "\n" + "El total fue = " + total + "\n" + "Total con iva(8%) = " + totalImp;
        str += "\n" + "El valor del domicilio fue: " + valorDomi + "\n" + "Valor de la compra más domicilio: \n " + totalMasDomi;
        str += "\n" + "Gracias por confiar en El Pingü";
        return str;
    }

    public Clientes getCliente(PedidosDetalle pedi) {
        try {
            Pedido pedido = ModeloLogin.clienteOperador.selectIdPedido(pedi.getIdPedidos());
            Clientes cli = ModeloLogin.clienteOperador.selctCliennte(pedido.getIdClientes());
            return cli;
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
