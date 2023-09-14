package co.edu.upb.Client;

import co.edu.upb.Interface.OperadorInterface;

import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class Client implements OperadorInterface {
    private OperadorInterface service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;

    public Client(String ip, String port, String serviceName) {
        this.service = null;
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
    }

    @Override
    public boolean login(String user, String password) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.login(user, password);


        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}