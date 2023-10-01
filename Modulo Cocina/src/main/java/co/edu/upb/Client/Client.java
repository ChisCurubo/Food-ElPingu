package co.edu.upb.Client;

import co.edu.upb.Interface.OperadorInterface;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

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

    public boolean isConnected() throws RemoteException {
        try {
            Naming.lookup(url);
            return true;
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
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

    @Override
    public String[] algortmoHammil(String platoSearch) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            String[] algotList = service.algortmoHammil(platoSearch);
            DoubleLinkedList<String> listStrinProduct = new DoubleLinkedList<>();
            listStrinProduct.add(algotList);
            listStrinProduct.imprimir();
            return algotList;
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}