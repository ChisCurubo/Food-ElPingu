package co.edu.upb.Pantallas.Domicilio;

import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.domain.Clientes;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.colas.CilaPriiory;
import co.edu.upb.estructuras.colas.ColaArry;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Iterator;
/**
 *@author ChristianRodriguez
 */
public class Domicilio extends JFrame {
    public static void main(String[] args) {
        Domicilio men = new Domicilio();
    }

    /**
     * CLase de interfaz grafica apara  el domicilio
     */
    public Domicilio() {
        initDomicilio();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Metodo inicaiar componentes
     */

    public void initDomicilio(){
        setTitle("Domicilio");
        setBounds(0, 0, 1500, 1000);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0,0,1500,1000);
        panelFondo.setBackground(new Color(64,93,128));
        setContentPane(panelFondo);
        setLayout(null);

        JLabel label = new JLabel("Domicilio");
        label.setFont(new Font("Times New Roman", 1, 50));
        label.setForeground(Color.WHITE);
        label.setBounds(100, 30, 500, 100);
        panelFondo.add(label);

        JPanel panelMapa = new JPanel();
        panelMapa.setBounds(50,150,510,450);
        panelMapa.setBackground(new Color(110,149,0));
        panelMapa.setLayout(null);
        panelFondo.add(panelMapa);
        JLabel panelImage = new JLabel();
        panelImage.setBounds(5,5,500,440);
        ImageIcon image = new ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\mapa (Personalizado).png");
        panelImage.setIcon(image);
        panelMapa.add(panelImage);

        JPanel panelInfo = new JPanel();
        panelInfo.setBounds(700,150,750,570);
        panelInfo.setBackground(new Color(110,149,0));
        panelInfo.setLayout(null);
        panelFondo.add(panelInfo);

        JLabel verCola = new JLabel("Ver Cola ");
        verCola.setFont(new Font("Arial", 1, 20));
        verCola.setForeground(Color.WHITE);
        verCola.setBounds(325, 10, 200, 30);
        panelInfo.add(verCola);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", 1, 20));
        textArea.setBackground(new Color(64, 77,128));
        textArea.setBounds(30,50,690,225);
        textArea.setEditable(false);
        panelInfo.add(textArea);
        JLabel ruta = new JLabel("Ruta ");
        ruta.setFont(new Font("Arial", 1, 20));
        ruta.setForeground(Color.WHITE);
        ruta.setBounds(350, 290, 200, 30);
        panelInfo.add(ruta);

        JTextArea textRuta = new JTextArea();
        textRuta.setFont(new Font("Arial", 1, 20));
        textRuta.setBackground(new Color(64, 77,128));
        textRuta.setBounds(30,320,690,225);
        textRuta.setEditable(false);
        panelInfo.add(textRuta);

        JButton botonRegre = new JButton("Regresame");
        botonRegre.setForeground(Color.WHITE);
        botonRegre.setFont(new Font("Arial", 1, 20));
        botonRegre.setBounds(1250, 50, 150, 50);
        botonRegre.setBackground(new Color(153, 2, 68));
        botonRegre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MenuDomi dom =  new MenuDomi();
                dom.setVisible(true);
            }
        });
        panelFondo.add(botonRegre);

        JButton botonRap1 = new JButton("Entregramé");
        botonRap1.setForeground(Color.WHITE);
        botonRap1.setFont(new Font("Arial", 1, 20));
        botonRap1.setBounds(300, 625, 300, 150);
        botonRap1.setBackground(new Color(110,149,0));
        botonRap1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DoubleLinkedList<PedidosDetalle> listDomi = new DoubleLinkedList<>();
                    for (int i = 0; i < 8; i++) {
                        if(!ModeloLogin.DomicilioInterface.isEmptyCola()) {
                            listDomi.add(ModeloLogin.DomicilioInterface.popsColaDespacho());
                        }
                    }
                    DoubleLinkedList<String> listStr = new DoubleLinkedList<>();
                    Iterator iter = listDomi.iteratorObj();
                    while (iter.hasNext()){
                        PedidosDetalle temp = (PedidosDetalle) iter.next();
                        Clientes cle = ModeloLogin.DomicilioInterface.busqCliente(temp);
                        listStr.add(cle.getBarrio());
                    }
                    DoubleLinkedList<String> listFin = new DoubleLinkedList<>();
                    Iterator iterar = listStr.iterator();
                    while (iterar.hasNext()){
                        String str = (String) iterar.next();
                        if(listFin.contains(str)){

                        }else{
                            listFin.add(str);
                        }
                    }
                    textArea.setText(ModeloLogin.DomicilioInterface.imprimirCola());
                    int valMax = ModeloLogin.DomicilioInterface.rutaAPuntos(listStr);
                    String verticeLejano = ModeloLogin.DomicilioInterface.getrVerticeDistanciaMayor();
                    if(listStr.contains(verticeLejano)){
                        listStr.remove(verticeLejano);
                        listStr.addOnHead(verticeLejano);
                    }
                    textRuta.setText(ModeloLogin.DomicilioInterface.rutaTotal(listStr).print());
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panelFondo.add(botonRap1);

    }
}
