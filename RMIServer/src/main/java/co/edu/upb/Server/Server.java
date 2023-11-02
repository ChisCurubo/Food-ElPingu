package co.edu.upb.Server;


import co.edu.upb.Interface.CocinaInterface;
import co.edu.upb.Interface.DomicilioInterface;
import co.edu.upb.Interface.OperadorInterface;
import co.edu.upb.Services.MethotsCocina;
import co.edu.upb.Services.MethotsDomicilio;
import co.edu.upb.Services.MethotsOperador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server{

    public String ip;
    public String port;
    public String serviceName;
    public String url;

    public Server(String ip, String port, String serviceName) {
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "//" + ip + ":" + port + "/" + serviceName;
    }

    public Server(String ip) {
        this.ip = ip;
    }

    public Server () throws IOException{
         File archivo = new File("config.properties");
        String dir = archivo.getCanonicalPath();
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(new File(dir)));
            this.ip = (String) properties.get("IP");
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public boolean deployServices() throws IOException {
        File archivo = new File("config.properties");
        String dir = archivo.getCanonicalPath();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(dir)));
            deployServiceOperador(
                    "Operador",
                    (String) properties.get("PORT"),
                    (String) properties.get("SERVICENAME"));

           /* deployServiceAdministrador(
                    "Admin",
                    (String) properties.get("PORT1"),
                    (String) properties.get("SERVICENAME1"));*/

            deployServiceCocina(
                    "Cocina",
                    (String) properties.get("PORT2"),
                    (String) properties.get("SERVICENAME2"));

            deployServiceDomicilio(
                    "Domicilio",
                    (String) properties.get("PORT3"),
                    (String) properties.get("SERVICENAME3"));

            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean deployServiceOperador(String serviceType, String port, String serviceName) {
        boolean ack = false;
        if (ip == null | port == null | serviceName == null) return ack;
        try {
            System.setProperty( "java.rmi.server.hostname", ip);
            String url = "//" + ip + ":" + port + "/" + serviceName;
            LocateRegistry.createRegistry(Integer.parseInt(port));  //port
            OperadorInterface service = new MethotsOperador();
            Naming.rebind(url, service);
            System.out.println("Service:" +serviceType +": on");
            ack = true;
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        } finally {
            return ack;
        }
    }

    public boolean deployServiceCocina(String serviceType, String port, String serviceName) {
        boolean ack = false;
        if (ip == null | port == null | serviceName == null) return ack;
        try {
            System.setProperty( "java.rmi.server.hostname", ip);
            String url = "//" + ip + ":" + port + "/" + serviceName;
            LocateRegistry.createRegistry(Integer.parseInt(port));  //port
            CocinaInterface service = new MethotsCocina();
            Naming.rebind(url, service);
            System.out.println("Service:" +serviceType +": on");
            ack = true;
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        } finally {
            return ack;
        }
    }

    public boolean deployServiceDomicilio(String serviceType, String port, String serviceName) {
        boolean ack = false;
        if (ip == null | port == null | serviceName == null) return ack;
        try {
            System.setProperty( "java.rmi.server.hostname", ip);
            String url = "//" + ip + ":" + port + "/" + serviceName;
            LocateRegistry.createRegistry(Integer.parseInt(port));  //port
            DomicilioInterface service = new MethotsDomicilio();
            Naming.rebind(url, service);
            System.out.println("Service:" +serviceType +": on");
            ack = true;
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        } finally {
            return ack;
        }
    }
}
