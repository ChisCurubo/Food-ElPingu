package co.edu.upb.Server;


import co.edu.upb.Interface.CocinaInterface;
import co.edu.upb.Interface.OperadorInterface;
import co.edu.upb.Services.MethotsCocina;
import co.edu.upb.Services.MethotsOperador;

import java.io.Serializable;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
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
    public boolean deployServices() {
        try {
            deployServiceOperador("Operador", "5000", "serviceOperador");
           //deployServiceAdministrador("Administrador", "5001", "serviceAdmin");
            deployServiceCocina("Cocina", "5002", "serviceCocina");
            //deployServiceDomicilio("Domicilio", "5003", "serviceDomicilio");
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            return false;
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
}
