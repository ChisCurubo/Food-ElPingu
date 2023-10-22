package co.edu.upb.Modelo;

import co.edu.upb.Client.Client;
import co.edu.upb.Interface.DomicilioInterface;
import co.edu.upb.Pantallas.Operador.AddPedido;
import co.edu.upb.Pantallas.Operador.InicioSesion;
import co.edu.upb.Pantallas.Operador.MenuOperador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

/**
 *@author ChristianRodriguez
 * Clase de puente entre las interfaces , funcionalidad para comunicar a la inter faz y poder concetar con el servidor
 */

public class ModeloLogin {
    public  static Client  DomicilioInterface;

    /**
     * Se inicializa un objeto static  de la siguiente manera
     */
    static { Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Modulo Domicilio\\config.properties")));
            DomicilioInterface = new Client((String) properties.get("IP"), (String) properties.get("PORT3"),
                    (String) properties.get("SERVICENAME3"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }}

    /**
     * Si se utiliza un objeto cada vez que se instancie se deberia hacer asi
     */
    public ModeloLogin() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("D:\\CursoJava\\Programacion\\Estructuras\\ProyectRes\\ProyectoElPinguEdit\\Modulo Domicilio\\config.properties")));
            DomicilioInterface = new Client((String) properties.get("IP"), (String) properties.get("PORT3"),
                    (String) properties.get("SERVICENAME3"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String contra = "";
    public static String email = "";


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
}
