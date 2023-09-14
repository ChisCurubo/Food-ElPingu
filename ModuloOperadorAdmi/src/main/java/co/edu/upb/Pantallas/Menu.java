package co.edu.upb.Pantallas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * Pantalla menu
 */
public class Menu extends JFrame {
    private JPanel contentPane;
    JLabel lblMenu;
    JScrollPane scrollPane;
    JPanel miPanel;
    JPanel miPanel1;
    private JLabel lblNewLabel1;
    private JLabel lblpapasALa;
    private JLabel lblChoripapa;
    private JLabel lblpapasALa_2;
    private JPanel miPanel1_1;
    private JLabel lblPerroTradicional;
    private JLabel lblsalchichaAmericanaPapa;
    private JLabel lblPerroEspecial;
    private JLabel lblpapasALa_3;
    private JLabel lblPapasRancheras;
    private JLabel lblpapasALa_4;
    private JLabel lblHamburguesas;
    private JLabel lblHamburguesaTradicional;
    private JLabel lblpapasALa_5;
    private JLabel lblHamburguesaRanchera;
    private JLabel lblpapasALa_6;
    private JLabel lblHamburguesaDobleDoble;
    private JLabel lblpapasALa_7;
    private JLabel lblSalchipapas;
    private JLabel lblPerrosCalientes;
    private JLabel lblPerroDobleCarne;
    private JLabel lblpapasALa_1;
    private JLabel lblBebidas;
    private JLabel lblCocaCola;
    private JLabel lblGaseosas;
    private JLabel lblLimonadas;

    public Menu() {
        ComponentesDePagina();
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    /**
     * Metodo para inilizacion de componentes
     */

    public void ComponentesDePagina() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(-7, -4, 1920, 1320);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        miPanel = new JPanel();
        miPanel.setBackground(new Color(200, 20, 0));
        miPanel.setBounds(0, 0, 1540, 70);
        contentPane.add(miPanel);
        miPanel.setLayout(null);

        lblMenu = new JLabel("MENU");
        lblMenu.setBackground(new Color(178, 34, 34));
        lblMenu.setBounds(668, 10, 210, 60);
        lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
        lblMenu.setFont(new Font("Harlow Solid Italic", Font.BOLD | Font.ITALIC, 42));
        miPanel.add(lblMenu);

        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setEnabled(false);
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\pabra\\Downloads\\pngwing.com (4) (1).png"));
        btnNewButton_1.setBounds(26, 10, 50, 50);
        miPanel.add(btnNewButton_1);

        miPanel1 = new JPanel();
        miPanel1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        miPanel1.setBackground(new Color(255, 147, 38));
        miPanel1.setBounds(46, 106, 700, 666);
        contentPane.add(miPanel1);
        miPanel1.setLayout(null);

        lblNewLabel1 = new JLabel("Salchipapa sencilla  $11.500");
        lblNewLabel1.setBounds(28, 90, 228, 23);
        lblNewLabel1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
        miPanel1.add(lblNewLabel1);

        lblpapasALa = new JLabel("(papas a la francesa, \r\nsalchicha americana, salsa tartara y queso rallado)");
        lblpapasALa.setBounds(28, 124, 520, 23);
        lblpapasALa.setVerticalAlignment(SwingConstants.TOP);
        lblpapasALa.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 16));
        miPanel1.add(lblpapasALa);

        lblChoripapa = new JLabel("Choripapa  $13.500");
        lblChoripapa.setBounds(28, 170, 228, 23);
        lblChoripapa.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
        miPanel1.add(lblChoripapa);

        lblpapasALa_2 = new JLabel("(papas a la francesa, chorizo antioqueño, salsa tartara y queso rallado)");
        lblpapasALa_2.setBounds(28, 204, 520, 23);
        lblpapasALa_2.setVerticalAlignment(SwingConstants.TOP);
        lblpapasALa_2.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 16));
        miPanel1.add(lblpapasALa_2);

        lblPapasRancheras = new JLabel("Papas rancheras  $ 16.500");
        lblPapasRancheras.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
        lblPapasRancheras.setBounds(28, 248, 228, 23);
        miPanel1.add(lblPapasRancheras);

        lblpapasALa_4 = new JLabel("(papas a la francesa, pollo y carne desmechados, maíz, tocineta, salsa tártara y queso doble crema)");
        lblpapasALa_4.setVerticalAlignment(SwingConstants.TOP);
        lblpapasALa_4.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 16));
        lblpapasALa_4.setBounds(28, 280, 629, 23);
        miPanel1.add(lblpapasALa_4);

        lblHamburguesas = new JLabel("Hamburguesas");
        lblHamburguesas.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
        lblHamburguesas.setBounds(10, 344, 228, 23);
        miPanel1.add(lblHamburguesas);

        lblHamburguesaTradicional = new JLabel("Hamburguesa tradicional  $ 14.500");
        lblHamburguesaTradicional.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
        lblHamburguesaTradicional.setBounds(28, 388, 323, 23);
        miPanel1.add(lblHamburguesaTradicional);

        lblpapasALa_5 = new JLabel("(150g de carne de res, queso mozarella, lechuga y tomates frescos)");
        lblpapasALa_5.setVerticalAlignment(SwingConstants.TOP);
        lblpapasALa_5.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 16));
        lblpapasALa_5.setBounds(28, 421, 419, 23);
        miPanel1.add(lblpapasALa_5);

        lblHamburguesaRanchera = new JLabel("Hamburguesa ranchera = $ 19.500");
        lblHamburguesaRanchera.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
        lblHamburguesaRanchera.setBounds(28, 475, 349, 23);
        miPanel1.add(lblHamburguesaRanchera);

        lblpapasALa_6 = new JLabel("(150g de carne de res, queso mozarella, cábano, jamón, lechuga y tomates frescos)");
        lblpapasALa_6.setVerticalAlignment(SwingConstants.TOP);
        lblpapasALa_6.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 16));
        lblpapasALa_6.setBounds(28, 508, 530, 23);
        miPanel1.add(lblpapasALa_6);

        lblHamburguesaDobleDoble = new JLabel("Hamburguesa doble doble  $ 29.500");
        lblHamburguesaDobleDoble.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
        lblHamburguesaDobleDoble.setBounds(28, 555, 349, 23);
        miPanel1.add(lblHamburguesaDobleDoble);

        lblpapasALa_7 = new JLabel("(300g de carne de res, doble queso mozarella, lechuga y tomates frescos)");
        lblpapasALa_7.setVerticalAlignment(SwingConstants.TOP);
        lblpapasALa_7.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 16));
        lblpapasALa_7.setBounds(28, 588, 580, 23);
        miPanel1.add(lblpapasALa_7);

        lblSalchipapas = new JLabel("Salchipapas");
        lblSalchipapas.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
        lblSalchipapas.setBounds(10, 48, 228, 23);
        miPanel1.add(lblSalchipapas);

        miPanel1_1 = new JPanel();
        miPanel1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        miPanel1_1.setBackground(new Color(255, 147, 38));
        miPanel1_1.setLayout(null);
        miPanel1_1.setBounds(796, 106, 700, 666);
        contentPane.add(miPanel1_1);

        lblPerroTradicional = new JLabel("Perro tradicional  $ 11.500");
        lblPerroTradicional.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
        lblPerroTradicional.setBounds(28, 90, 228, 23);
        miPanel1_1.add(lblPerroTradicional);

        lblsalchichaAmericanaPapa = new JLabel(" (salchicha americana, papa molida, jamón y queso mozarella)");
        lblsalchichaAmericanaPapa.setVerticalAlignment(SwingConstants.TOP);
        lblsalchichaAmericanaPapa.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 16));
        lblsalchichaAmericanaPapa.setBounds(28, 124, 520, 23);
        miPanel1_1.add(lblsalchichaAmericanaPapa);

        lblPerroEspecial = new JLabel("Perro especial  $ 17.500");
        lblPerroEspecial.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
        lblPerroEspecial.setBounds(28, 170, 228, 23);
        miPanel1_1.add(lblPerroEspecial);

        lblpapasALa_3 = new JLabel("(salchicha americana, papa molida, trozos de tocineta, jamón y queso mozarella)\n");
        lblpapasALa_3.setVerticalAlignment(SwingConstants.TOP);
        lblpapasALa_3.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 16));
        lblpapasALa_3.setBounds(28, 204, 520, 23);
        miPanel1_1.add(lblpapasALa_3);

        lblPerrosCalientes = new JLabel("Perros Calientes");
        lblPerrosCalientes.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
        lblPerrosCalientes.setBounds(10, 48, 228, 23);
        miPanel1_1.add(lblPerrosCalientes);

        lblPerroDobleCarne = new JLabel("Perro doble carne  $ 14.500");
        lblPerroDobleCarne.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
        lblPerroDobleCarne.setBounds(28, 248, 228, 23);
        miPanel1_1.add(lblPerroDobleCarne);

        lblpapasALa_1 = new JLabel(" (doble salchicha americana, papa molida, jamón y queso mozarella)");
        lblpapasALa_1.setVerticalAlignment(SwingConstants.TOP);
        lblpapasALa_1.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 16));
        lblpapasALa_1.setBounds(28, 280, 520, 23);
        miPanel1_1.add(lblpapasALa_1);

        lblBebidas = new JLabel("Bebidas");
        lblBebidas.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
        lblBebidas.setBounds(10, 344, 228, 23);
        miPanel1_1.add(lblBebidas);

        lblCocaCola = new JLabel(" Milo\r\n  $7.000");
        lblCocaCola.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
        lblCocaCola.setBounds(28, 389, 228, 23);
        miPanel1_1.add(lblCocaCola);

        lblGaseosas = new JLabel(" Gaseosas  $4.500");
        lblGaseosas.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
        lblGaseosas.setBounds(28, 418, 228, 23);
        miPanel1_1.add(lblGaseosas);

        lblLimonadas = new JLabel(" Limonadas  $5.500");
        lblLimonadas.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
        lblLimonadas.setBounds(28, 451, 228, 23);
        miPanel1_1.add(lblLimonadas);

        JButton btnNewButton = new JButton("Seguir con la compra >");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(200, 20, 0));
        btnNewButton.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 16));
        btnNewButton.setBounds(421, 572, 228, 38);
        miPanel1_1.add(btnNewButton);
    }

    public JLabel getLblpapasALa() {
        return lblpapasALa;
    }
}

