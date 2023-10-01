package co.edu.upb.Controlador;

import co.edu.upb.Client.Client;
import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.Pantallas.InicioSesion;
import co.edu.upb.domain.Clientes;

import java.rmi.RemoteException;

public class ControladorLogin {
    public ControladorLogin() {
        try {
            if (!ModeloLogin.clienteOperador.isConnected()) {
                InicioSesion ini = new InicioSesion();
                ModeloLogin modeloLogin = new ModeloLogin();
                ini.getBoton().addActionListener(modeloLogin.checkBoton(ini));
                try {
                    modeloLogin.algortmHammil();
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }else{
                System.out.println("NoseConeta");
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
