package co.edu.upb.Pantallas;

import co.edu.upb.Clasificacion.CocinaCola;
import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.datos.PedidosDetalleConnet;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.colas.ColaPrioridadList;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class Cocina extends JFrame {

    ColaPrioridadList<PedidosDetalle> colaDomicilio = new ColaPrioridadList<>();

    private JPanel panel;
    PedidosDetalle[] fogRapido = new PedidosDetalle[12];
    PedidosDetalle[] fogLento = new PedidosDetalle[4];
    private JLabel labelColaRap = new JLabel();
    private JLabel labelCola = new JLabel();
    JTextArea textAreaPedi = new JTextArea();
    DoubleLinkedList<PedidosDetalle> list  = new DoubleLinkedList<>();

    public static void main(String[] args) {
        Cocina co = new Cocina();
    }

    public Cocina() {
        initCocina();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Images\\logo (Pequeño).jpg").getImage());
    }

    public void initCocina() {
        CocinaCola cos = new CocinaCola();
        setTitle("Modulo Cocina");
        setBounds(0, 0, 1500, 1000);
        setLocationRelativeTo(null);
        setResizable(false);

        panel = new JPanel();
        panel.setBackground(new Color(64, 93, 128));
        setContentPane(panel);
        setLayout(null);

        JLabel jlabel = new JLabel("Bienvenido al modulo de cocina");
        jlabel.setHorizontalAlignment(SwingConstants.CENTER);
        jlabel.setForeground(Color.WHITE);
        jlabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 40));
        jlabel.setBounds(370, 50, 500, 50);
        panel.add(jlabel);

        JButton botonRap1 = new JButton("Fogon Rapido 1");
        botonRap1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap1.setBounds(50, 200, 200, 100);
        botonRap1.setBackground(Color.PINK);
        //recordar que cambie de color si esta en uso o no


        panel.add(botonRap1);

        JButton botonRap2 = new JButton("Fogon Rapido 2");
        botonRap2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap2.setBounds(270, 200, 200, 100);
        botonRap2.setBackground(Color.PINK);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonRap2);

        JButton botonRap3 = new JButton("Fogon Rapido 3");
        botonRap3.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap3.setBounds(490, 200, 200, 100);
        botonRap3.setBackground(Color.PINK);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonRap3);

        JButton botonRap4 = new JButton("Fogon Rapido 4");
        botonRap4.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap4.setBounds(710, 200, 200, 100);
        botonRap4.setBackground(Color.PINK);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonRap4);

        JButton botonRap5 = new JButton("Fogon Rapido 5");
        botonRap5.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap5.setBounds(930, 200, 200, 100);
        botonRap5.setBackground(Color.PINK);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonRap5);

        JButton botonRap6 = new JButton("Fogon Rapido 6");
        botonRap6.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap6.setBounds(50, 320, 200, 100);
        botonRap6.setBackground(Color.PINK);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonRap6);

        JButton botonRap7 = new JButton("Fogon Rapido 7");
        botonRap7.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap7.setBounds(270, 320, 200, 100);
        botonRap7.setBackground(Color.PINK);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonRap7);

        JButton botonRap8 = new JButton("Fogon Rapido 8");
        botonRap8.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap8.setBounds(490, 320, 200, 100);
        botonRap8.setBackground(Color.PINK);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonRap8);

        JButton botonRap9 = new JButton("Fogon Rapido 9");
        botonRap9.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap9.setBounds(710, 320, 200, 100);
        botonRap9.setBackground(Color.PINK);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonRap9);

        JButton botonRap10 = new JButton("Fogon Rapido 10");
        botonRap10.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap10.setBounds(930, 320, 200, 100);
        botonRap10.setBackground(Color.PINK);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonRap10);

        JButton botonRap11 = new JButton("Fogon Rapido 11");
        botonRap11.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap11.setBounds(390, 440, 200, 100);
        botonRap11.setBackground(Color.PINK);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonRap11);

        JButton botonRap12 = new JButton("Fogon Rapido 12");
        botonRap12.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonRap12.setBounds(610, 440, 200, 100);
        botonRap12.setBackground(Color.PINK);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonRap12);


        JButton botonComp1 = new JButton("Fogon Complejo 1");
        botonComp1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonComp1.setBounds(150, 600, 200, 100);
        botonComp1.setBackground(Color.gray);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonComp1);

        JButton botonComp2 = new JButton("Fogon Complejo 2");
        botonComp2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonComp2.setBounds(370, 600, 200, 100);
        botonComp2.setBackground(Color.gray);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonComp2);

        JButton botonComp3 = new JButton("Fogon Complejo 3");
        botonComp3.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonComp3.setBounds(590, 600, 200, 100);
        botonComp3.setBackground(Color.gray);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonComp3);

        JButton botonComp4 = new JButton("Fogon Complejo 4");
        botonComp4.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 20));
        botonComp4.setBounds(810, 600, 200, 100);
        botonComp4.setBackground(Color.gray);
        //recordar que cambie de color si esta en uso o no
        panel.add(botonComp4);


        botonRap1.addActionListener(actionListenerBotonRap(botonRap1, 0));
        botonRap2.addActionListener(actionListenerBotonRap(botonRap2, 1));
        botonRap3.addActionListener(actionListenerBotonRap(botonRap3, 2));
        botonRap4.addActionListener(actionListenerBotonRap(botonRap4, 3));
        botonRap5.addActionListener(actionListenerBotonRap(botonRap5, 4));
        botonRap6.addActionListener(actionListenerBotonRap(botonRap6, 5));
        botonRap7.addActionListener(actionListenerBotonRap(botonRap7, 6));
        botonRap8.addActionListener(actionListenerBotonRap(botonRap8, 7));
        botonRap9.addActionListener(actionListenerBotonRap(botonRap9, 8));
        botonRap10.addActionListener(actionListenerBotonRap(botonRap10, 9));
        botonRap11.addActionListener(actionListenerBotonRap(botonRap11, 10));
        botonRap12.addActionListener(actionListenerBotonRap(botonRap12, 11));

        botonComp1.addActionListener(actionListenerBotonLen(botonComp1, 0));
        botonComp2.addActionListener(actionListenerBotonLen(botonComp2, 1));
        botonComp3.addActionListener(actionListenerBotonLen(botonComp3, 2));
        botonComp4.addActionListener(actionListenerBotonLen(botonComp4, 3));

        JPanel panelFogones = new JPanel();
        panelFogones.setBackground(new Color(1, 113, 143));
        panelFogones.setBounds(1150, 100, 325, 600);
        panel.add(panelFogones);
        panelFogones.setLayout(null);
        JLabel infoPedidos = new JLabel("Info Pedidos");
        infoPedidos.setForeground(Color.WHITE);
        infoPedidos.setFont(new Font("Times New Roman", 1, 20));
        infoPedidos.setBounds(120, 10, 200, 50);
        panelFogones.add(infoPedidos);

        textAreaPedi.setBackground(new Color(0, 176, 222));
        textAreaPedi.setBounds(10, 100, 300, 450);
        panelFogones.add(textAreaPedi);


    }

    public ActionListener actionListenerBotonRap(JButton botonRap, int numFog) {
        ActionListener validation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fogRapido[numFog] == null) {
                    if (botonRap.getBackground().equals(Color.PINK)) {

                    } else {
                        botonRap.setBackground(Color.PINK);
                    }
                    botonRap.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                String str = ModeloLogin.CocinaInterface.popColaRapida();
                                String[] arrystr = str.split(",");
                                PedidosDetalle pediDet = new PedidosDetalle(Integer.parseInt(arrystr[0]), Integer.parseInt(arrystr[1]), Integer.parseInt(arrystr[2]), Integer.parseInt(arrystr[3]), arrystr[4]);
                                fogRapido[numFog] = pediDet;
                            } catch (RemoteException ex) {
                                throw new RuntimeException(ex);
                            }
                            botonRap.setBackground(Color.orange);
                        }
                    });
                } else if (fogRapido[numFog] != null) {
                    botonRap.setBackground(Color.orange);
                    botonRap.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            list.add(fogRapido[numFog]);
                            fogRapido[numFog] = null;
                            botonRap.setBackground(Color.PINK);
                        }
                    });
                }

                textAreaPedi.setText("Fogon Rapido " + (numFog + 1) + ": " + fogRapido[numFog].getIdDetalle() + ", " + fogRapido[numFog].getIdProducto() + ", " + fogRapido[numFog].getCantidad());
            }
        };
        return validation;
    }

    public ActionListener actionListenerBotonLen(JButton botonRap, int numFog) {
        ActionListener validation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fogLento[numFog] == null) {
                    botonRap.setBackground(Color.gray);
                    botonRap.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                String str = ModeloLogin.CocinaInterface.popColaRapida();
                                String[] arrystr = str.split(",");
                                PedidosDetalle pediDet = new PedidosDetalle(Integer.parseInt(arrystr[0]), Integer.parseInt(arrystr[1]), Integer.parseInt(arrystr[2]), Integer.parseInt(arrystr[3]), arrystr[4]);
                                fogLento[numFog] = pediDet;
                            } catch (RemoteException ex) {
                                throw new RuntimeException(ex);
                            }
                            botonRap.setBackground(Color.GREEN);
                        }
                    });
                } else if (fogLento[numFog] != null) {
                    botonRap.setBackground(Color.GREEN);
                    botonRap.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            list.add(fogLento[numFog]);
                            fogLento[numFog] = null;
                            botonRap.setBackground(Color.gray);
                        }
                    });
                }
                textAreaPedi.setText("Fogon Lento " + (numFog + 1) + ": " + fogRapido[numFog].getIdDetalle() + ", " + fogRapido[numFog].getIdProducto() + ", " + fogRapido[numFog].getCantidad());
            }
        };
        return validation;
    }
}
