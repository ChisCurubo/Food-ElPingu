package co.edu.upb.Modelo;

import co.edu.upb.Client.Client;
import co.edu.upb.Pantallas.InicioSesion;
import co.edu.upb.Pantallas.Menu;
import co.edu.upb.list.DoubleLinkedList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class ModeloLogin {
    public static Client clienteOperador = new Client("localhost", "5000", "serviceOperador");

    public ModeloLogin() {

    }

    public ActionListener checkBoton(InicioSesion ini) {
        ActionListener validation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ini.getTextCorreo().getText().length() > 0 && ini.getPswField().getText().length() > 0) {
                        String em = ini.getTextCorreo().getText();
                        String ps = ini.getPswField().getText();

                        if (clienteOperador.login(em, ps)) {
                            ini.setVisible(false);
                            Menu menu = new Menu();
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
    public void algortmHammil() throws RemoteException {
        String platoBusqueda = "Hamb";
        clienteOperador.algortmoHammil(platoBusqueda);
    }
}
