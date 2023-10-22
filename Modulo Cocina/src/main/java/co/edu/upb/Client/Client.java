package co.edu.upb.Client;

import co.edu.upb.Interface.CocinaInterface;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

/**
 * @author ChristianRodriguez
 * Clase que implementa la interfaz de CocinaInterface, esta clase permite la comunicacion entre modulo y servidor
 */

public class Client implements CocinaInterface {
    /**
     * Atributos de la clase , el atributo service permite acceder a la interfaz y comununicarse con el servidor
     */
    private CocinaInterface service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;
    DoubleLinkedList<PedidosDetalle> pedi = new DoubleLinkedList<>();

    /**
     *  Contructor para inicializar el servicio
     * @param ip
     * @param port
     * @param serviceName
     */
    public Client(String ip, String port, String serviceName) {
        this.service = null;
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
    }
    /**
     * Metodo para saber si esta activo el servidor
     * @return
     * @throws RemoteException
     */
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
     * Metodo para extraer de la cola de prioridad del fogon lento, devuelve un Pedido detalle
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
     * Metodo para extraer de la cola de prioridad del fogon rapido, devuelve Pedidos Detalle
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
     * Metodo para retain pedido // no usado
     * @return
     * @throws RemoteException
     */
    @Override
    public String[] retainPedido() throws RemoteException {
        return new String[0];
    }

    /**
     * metodo para mandar el de la cola de prioridad al modulo del domicilio
     * @param listPedidos
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean sendToDomi(DoubleLinkedList<PedidosDetalle> listPedidos) throws RemoteException {
        try{
            service = (CocinaInterface) Naming.lookup(url);
            return service.sendToDomi(listPedidos);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }
}