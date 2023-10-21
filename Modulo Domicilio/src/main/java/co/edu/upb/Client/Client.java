package co.edu.upb.Client;

import co.edu.upb.Interface.DomicilioInterface;
import co.edu.upb.domain.Clientes;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class Client implements DomicilioInterface {
    private DomicilioInterface service;
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

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean createGrafo() throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            return service.createGrafo();
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param punto
     * @return
     * @throws RemoteException
     */
    @Override
    public int rutaAPuntos(DoubleLinkedList<String> punto) throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            return service.rutaAPuntos(punto);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String getrVerticeDistanciaMayor() throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            return service.getrVerticeDistanciaMayor();
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * @param puntoFin
     * @return
     * @throws RemoteException
     */
    @Override
    public double calculateValDom(String puntoFin) throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            return service.calculateValDom(puntoFin);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @param puntoIni
     * @return
     * @throws RemoteException
     */
    @Override
    public DoubleLinkedList<String> rutaTotal(DoubleLinkedList<String> puntoIni) throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            return service.rutaTotal(puntoIni);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param pediDet
     * @return
     * @throws RemoteException
     */
    @Override
    public Clientes busqCliente(PedidosDetalle pediDet) throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            return service.busqCliente(pediDet);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public PedidosDetalle popsColaDespacho() throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            return service.popsColaDespacho();
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public int sizeCola() throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            return service.sizeCola();
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return 10000;
        }
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean isEmptyCola() throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            return service.isEmptyCola();
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
    public String imprimirCola() throws RemoteException {
        try {
            service = (DomicilioInterface) Naming.lookup(url);
            return service.imprimirCola();
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
