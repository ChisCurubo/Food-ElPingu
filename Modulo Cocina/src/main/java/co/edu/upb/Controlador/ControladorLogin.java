package co.edu.upb.Controlador;

import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.Pantallas.Operador.InicioSesion;

import java.rmi.RemoteException;
/**
 * @author ChristianRodriguez
 * Clase para el inicio del programa
 */
public class ControladorLogin {
    public ControladorLogin() {
        try {
            if (!ModeloLogin.CocinaInterface.isConnected()) {
                InicioSesion ini = new InicioSesion();
                ModeloLogin modeloLogin = new ModeloLogin();

            }else{
                System.out.println("NoseConeta");
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
