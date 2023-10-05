package co.edu.upb.Pantallas;

import co.edu.upb.Clasificacion.CocinaCola;
import co.edu.upb.datos.PedidosDetalleConnet;
import co.edu.upb.domain.PedidosDetalle;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cocina extends JFrame {

    private JPanel panel;
    PedidosDetalle[] fogRapido = new PedidosDetalle[12];
    PedidosDetalle[] fogLento = new PedidosDetalle[4];
    private JLabel labelColaRap = new JLabel();
    JLabel labelCola = new JLabel();

    public static void main(String[] args) {
        Cocina co = new Cocina();
    }

    public Cocina() {
        initCocina();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initCocina() {
        CocinaCola cos = new CocinaCola();
        setTitle("Modulo Cocina");
        setBounds(0, 0, 1500, 1000);
        setLocationRelativeTo(null);
        setResizable(false);

        panel = new JPanel();
        panel.setBackground(Color.CYAN);
        setContentPane(panel);
        setLayout(null);

        JLabel jlabel = new JLabel("Bienvenido al modulo de cocina");
        jlabel.setHorizontalAlignment(SwingConstants.CENTER);
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

        JPanel panelet = new JPanel();
        PedidosDetalleConnet pdC = new PedidosDetalleConnet();
        int idPe = 5;
        for (int i = 0; i < 2; i++) {
            PedidosDetalle pdDe = pdC.selectIdDet(idPe);
            idPe++;
        }

        labelCola.setText("Cola de comida complejas : " + cos.imprimirColaLen());


        JPanel paneletRa = new JPanel();
        labelColaRap.setText("Cola de comida rapida : " + cos.imprimirColaRap());

        botonRap1.addActionListener(actionListenerBotonRap(botonRap1, cos, 0));
        botonRap2.addActionListener(actionListenerBotonRap(botonRap2, cos, 1));
        botonRap3.addActionListener(actionListenerBotonRap(botonRap3, cos, 2));
        botonRap4.addActionListener(actionListenerBotonRap(botonRap4, cos, 3));
        botonRap5.addActionListener(actionListenerBotonRap(botonRap5, cos, 4));
        botonRap6.addActionListener(actionListenerBotonRap(botonRap6, cos, 5));
        botonRap7.addActionListener(actionListenerBotonRap(botonRap7, cos, 6));
        botonRap8.addActionListener(actionListenerBotonRap(botonRap8, cos, 7));
        botonRap9.addActionListener(actionListenerBotonRap(botonRap9, cos, 8));
        botonRap10.addActionListener(actionListenerBotonRap(botonRap10, cos, 9));
        botonRap11.addActionListener(actionListenerBotonRap(botonRap11, cos, 10));
        botonRap12.addActionListener(actionListenerBotonRap(botonRap12, cos, 11));

        botonComp1.addActionListener(actionListenerBotonLen(botonComp1, cos, 0));
        botonComp2.addActionListener(actionListenerBotonLen(botonComp2, cos, 1));
        botonComp3.addActionListener(actionListenerBotonLen(botonComp3, cos, 2));
        botonComp4.addActionListener(actionListenerBotonLen(botonComp4, cos, 3));

        paneletRa.add(labelColaRap);
        panelet.add(labelCola);
        paneletRa.setBackground(Color.BLUE);
        paneletRa.setBounds(1140, 400, 350, 400);
        panel.add(paneletRa);
        //se imprime la lista
        panelet.setBackground(Color.gray);
        panelet.setBounds(1140, 0, 350, 400);
        panel.add(panelet);

    }

    public ActionListener actionListenerBotonRap(JButton botonRap, CocinaCola newCola, int numFog) {
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
                            fogRapido[numFog] = newCola.popOfColaCocina(1);
                            botonRap.setBackground(Color.orange);
                        }
                    });
                } else if (fogRapido[numFog] != null) {
                    botonRap.setBackground(Color.orange);
                    botonRap.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            fogRapido[numFog] = null;
                            botonRap.setBackground(Color.PINK);
                        }
                    });
                }
                labelColaRap.setText("Cola de comida rapida : " + newCola.imprimirColaRap());

            }
        };
        return validation;
    }

    public ActionListener actionListenerBotonLen(JButton botonRap, CocinaCola newCola, int numFog) {
        ActionListener validation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fogLento[numFog] == null) {
                    botonRap.setBackground(Color.gray);
                    botonRap.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            fogLento[numFog] = newCola.popOfColaCocina(0);
                            botonRap.setBackground(Color.GREEN);
                        }
                    });
                } else if (fogLento[numFog] != null) {
                    botonRap.setBackground(Color.GREEN);
                    botonRap.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            fogLento[numFog] = null;
                            botonRap.setBackground(Color.gray);
                        }
                    });
                }
                labelCola.setText("Cola de Lenta rapida : " + newCola.imprimirColaLen());

            }
        };
        return validation;
    }
}
