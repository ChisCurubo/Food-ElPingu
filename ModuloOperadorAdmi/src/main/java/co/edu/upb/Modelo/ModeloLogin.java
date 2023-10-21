package co.edu.upb.Modelo;

import co.edu.upb.Client.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

import co.edu.upb.Pantallas.Administrador.MenuAdmin;
import co.edu.upb.Pantallas.Operador.AddPedido;
import co.edu.upb.Pantallas.Operador.InicioSesion;
import co.edu.upb.Pantallas.Operador.MenuOperador;

public class ModeloLogin {
    public  static Client clienteOperador;

    public ModeloLogin() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\ModuloOperadorAdmi\\config.properties")));
            clienteOperador = new Client((String) properties.get("IP"), (String) properties.get("PORT"),
                    (String) properties.get("SERVICENAME"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String contra = "";
    public static String email = "";

    public ActionListener checkBoton(InicioSesion ini) {
        ActionListener validation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ini.getTextCorreo().getText().length() > 0 && ini.getPswField().getText().length() > 0) {
                        String em = ini.getTextCorreo().getText();
                        email = em;
                        String ps = ini.getPswField().getText();
                        contra = ps;
                        int can = clienteOperador.login(em, ps);
                        if (can == 0) {
                            ini.setVisible(false);
                            MenuOperador menu = new MenuOperador();
                            menu.setVisible(true);
                        } else if (can == 1) {
                            ini.setVisible(false);
                            MenuAdmin menu = new MenuAdmin();
                            menu.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "no es el usuario o la contaseña");
                            ini.getTextCorreo().setText("");
                            ini.getPswField().setText("");
                            ini.getTextCorreo().requestFocusInWindow();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Esta vacio");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        return validation;
    }

    public ActionListener checkBotonMenuOpera(AddPedido ini) {
        ActionListener validation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (true) {

                    } else {
                        JOptionPane.showMessageDialog(null, "Esta vacio");
                    }
                } catch (
                        Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        return validation;
    }

    public void algortmHammil() throws RemoteException {
        String platoBusqueda = "Perro";
        clienteOperador.algortmoHammil(platoBusqueda);
    }
}
