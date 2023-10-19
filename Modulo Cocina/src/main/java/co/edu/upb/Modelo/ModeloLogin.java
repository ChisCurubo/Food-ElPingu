package co.edu.upb.Modelo;

import co.edu.upb.Client.Client;
import co.edu.upb.Pantallas.Operador.InicioSesion;
import co.edu.upb.Pantallas.Operador.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class ModeloLogin {
    public static Client CocinaInterface = new Client("localhost", "5002", "serviceCocina");

    public ModeloLogin() {

    }


}
