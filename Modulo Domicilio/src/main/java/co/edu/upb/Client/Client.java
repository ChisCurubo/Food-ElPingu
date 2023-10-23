package co.edu.upb.Client;

import co.edu.upb.Interface.DomicilioInterface;
import co.edu.upb.domain.Clientes;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

/**
 * @author ChristianRodriguez
 * Clase que implementa la interfaz de DomicilioInterface
 */

public class Client implements DomicilioInterface {
    private static final long serialVersionUID = 3621271727859909664L;
    /**
     * Atributos de la clase , el atributo service permite acceder a la interfaz y comununicarse con el servidor
     */
    private DomicilioInterface service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;

    /**
     * Contructor para inicializar el servicio
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
     * Crear el grafo para recorrerlo
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
     * metodo para saber la distancia maxima y por cual vertice se despachara el domicilio
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
     * Identifica el vertice donde se comenzara// teniendo en cuenta que comienza por el mas lejano
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
     * Metodo que calcula el valor del domicilio
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
     * Metodo que recorre todo el domicilio y manda la ruta
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
     * Bussca al cliente al que le pertenece el pedido
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
     * Metodo que hace pop a la cola de despacho
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
     * Metodo que retorna el tamaño de la cola
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
     * Revisa si la cola no esta vacia para evitar exepciones y errores
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
     * Metodo que imprime la cola de despacho de domicilio
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
