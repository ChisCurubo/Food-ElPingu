package co.edu.upb.Client;

import co.edu.upb.Interface.CocinaInterface;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class Client implements CocinaInterface {
    private CocinaInterface service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;
    DoubleLinkedList<PedidosDetalle> pedi = new DoubleLinkedList<>();

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

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public PedidosDetalle popColaLenta() throws RemoteException {
        try{
            service = (CocinaInterface) Naming.lookup(url);
            return service.popColaLenta();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public PedidosDetalle popColaRapida() throws RemoteException {
        try{
            service = (CocinaInterface) Naming.lookup(url);
            return service.popColaRapida();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String[] retainPedido() throws RemoteException {
        return new String[0];
    }
}