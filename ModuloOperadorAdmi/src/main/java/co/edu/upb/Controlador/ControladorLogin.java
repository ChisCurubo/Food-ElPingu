package co.edu.upb.Controlador;

import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.Pantallas.InicioSesion;

import java.rmi.RemoteException;

public class ControladorLogin {
    public ControladorLogin(){
        InicioSesion ini = new InicioSesion();
        ModeloLogin modeloLogin = new ModeloLogin();
        ini.getBoton().addActionListener(modeloLogin.checkBoton(ini));
        try {
            modeloLogin.algortmHammil();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
