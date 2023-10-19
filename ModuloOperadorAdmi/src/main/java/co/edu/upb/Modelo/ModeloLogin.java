package co.edu.upb.Modelo;

import co.edu.upb.Client.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import co.edu.upb.Pantallas.Administrador.MenuAdmin;
import co.edu.upb.Pantallas.Operador.AddPedido;
import co.edu.upb.Pantallas.Operador.InicioSesion;
import co.edu.upb.Pantallas.Operador.MenuOperador;

public class ModeloLogin {
    public static Client clienteOperador = new Client("localhost", "5000", "serviceOperador");

    public ModeloLogin() {

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
                    if(true){

                } else{
                    JOptionPane.showMessageDialog(null, "Esta vacio");
                }
            } catch(
            Exception ex)

            {
                ex.printStackTrace();
            }
        }
    }

    ;

        return validation;
}

    public void algortmHammil() throws RemoteException {
        String platoBusqueda = "Perro";
        clienteOperador.algortmoHammil(platoBusqueda);
    }
}
