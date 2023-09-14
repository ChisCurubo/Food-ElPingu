package co.edu.upb.Controlador;

import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.Pantallas.InicioSesion;

public class ControladorLogin {
    public ControladorLogin(){
        InicioSesion ini = new InicioSesion();
        ModeloLogin modeloLogin = new ModeloLogin();
        ini.getBoton().addActionListener(modeloLogin.checkBoton(ini));
    }
}
