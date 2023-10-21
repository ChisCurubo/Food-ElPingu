package co.edu.upb.Modelo;

import co.edu.upb.Client.Client;
import co.edu.upb.Pantallas.Operador.InicioSesion;
import co.edu.upb.Pantallas.Operador.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

public class ModeloLogin {
    public static Client CocinaInterface ;

    public ModeloLogin() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("config.properties")));
            CocinaInterface = new Client((String) properties.get("IP"), (String) properties.get("PORT3"),
                    (String) properties.get("SERVICENAME2"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
