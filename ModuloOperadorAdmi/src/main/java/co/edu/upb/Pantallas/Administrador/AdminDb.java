package co.edu.upb.Pantallas.Administrador;

import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.Pantallas.Operador.MenuOperador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
/**
 * Clase de Administrar base de datos
 *@author ChristianRodriguez
 */
public class AdminDb extends JFrame {
    public static void main(String[] args) {
        AdminDb men = new AdminDb();
    }

    public AdminDb() {
        initOperator();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("src/main/java/co/edu/upb/images/logo (Pequeño).jpg").getImage());
    }

    public void initOperator() {
        setTitle("Administra Data bese");
        setBounds(0, 0, 1500, 1000);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0, 0, 1500, 1000);
        panelFondo.setBackground(new Color(64, 93, 128));
        setContentPane(panelFondo);
        setLayout(null);
        JLabel label = new JLabel("Administrar Base de datos");
        label.setFont(new Font("Times News Roman", 1, 40));
        label.setForeground(Color.WHITE);
        label.setBounds(30, 50, 600, 100);
        panelFondo.add(label);

        JPanel panelFondoColaR = new JPanel();
        panelFondoColaR.setBounds(50, 200, 400, 500);
        panelFondoColaR.setBackground(new Color(110,149,0));
        panelFondoColaR.setLayout(null);
        panelFondo.add(panelFondoColaR);

        JTextArea areaColaRap = new JTextArea();
        areaColaRap.setBounds(10,50,380,420);
        areaColaRap.setFont(new Font("Arial", 1, 15));
        areaColaRap.setForeground(Color.BLACK);
        areaColaRap.setText(updatePanelRap());
        areaColaRap.setBackground(new Color(77, 101,0));
        panelFondoColaR.add(areaColaRap);

        JLabel labelNombreProduct = new JLabel("Cola Rapida Cocina ");
        labelNombreProduct.setBounds(100,10,300,50);
        labelNombreProduct.setFont(new Font("Arial", 1, 20));
        labelNombreProduct.setForeground(Color.WHITE);
        panelFondoColaR.add(labelNombreProduct);

        JPanel panelFondoColaL = new JPanel();
        panelFondoColaL.setBounds(525, 200, 400, 500);
        panelFondoColaL.setBackground(new Color(110,149,0));
        panelFondoColaL.setLayout(null);
        panelFondo.add(panelFondoColaL);
        JLabel labelCOlalenta = new JLabel("Cola Lenta Cocina ");
        labelCOlalenta.setBounds(100,10,300,50);
        labelCOlalenta.setFont(new Font("Arial", 1, 20));
        labelCOlalenta.setForeground(Color.WHITE);
        panelFondoColaL.add(labelCOlalenta);

        JTextArea areaColaLe = new JTextArea();
        areaColaLe.setBounds(10,50,380,420);
        areaColaLe.setFont(new Font("Arial", 1, 15));
        areaColaLe.setForeground(Color.BLACK);
        areaColaLe.setBackground(new Color(77, 101,0));
        areaColaLe.setText(updatePanelLen());
        panelFondoColaL.add(areaColaLe);

        JPanel panelFondoColaDomi = new JPanel();
        panelFondoColaDomi.setBounds(1000, 200, 400, 500);
        panelFondoColaDomi.setBackground(new Color(110,149,0));
        panelFondoColaDomi.setLayout(null);
        panelFondo.add(panelFondoColaDomi);

        JLabel ColaDomicilio = new JLabel("Cola Domicilio ");
        ColaDomicilio.setBounds(150,10,300,50);
        ColaDomicilio.setFont(new Font("Arial", 1, 20));
        ColaDomicilio.setForeground(Color.WHITE);
        panelFondoColaDomi.add(ColaDomicilio);

        JTextArea areaCola = new JTextArea();
        areaCola.setBounds(10,50,380,420);
        areaCola.setFont(new Font("Arial", 1, 15));
        areaCola.setForeground(Color.BLACK);
        areaCola.setBackground(new Color(77, 101,0));
        areaCola.setText(updatePanelCocina());
        panelFondoColaDomi.add(areaCola);

        JButton botRegresar = new JButton("Regresate:)");
        botRegresar.setBackground(new Color(153, 2, 68));
        botRegresar.setForeground(Color.WHITE);
        botRegresar.setFont(new Font("Times New Roman", 1, 30));
        botRegresar.setBounds(1200, 50, 200, 100);
        botRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MenuAdmin men = new MenuAdmin();
                men.setVisible(true);
            }
        });
        panelFondo.add(botRegresar);

    }
    public  String updatePanelRap (){
        String str = "";
        try {
            str = ModeloLogin.clienteOperador.verDbRap().toString();
            return str;
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    public  String updatePanelLen (){
        String str = "";
        try {
            str = ModeloLogin.clienteOperador.verDblen();
            return str;
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    public String  updatePanelCocina(){
        String str = "";
        try {
            str = ModeloLogin.clienteOperador.verColaDomi();
            return str;
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

}
