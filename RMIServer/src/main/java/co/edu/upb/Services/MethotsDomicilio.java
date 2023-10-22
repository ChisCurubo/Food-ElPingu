package co.edu.upb.Services;

import co.edu.upb.Domi.DomiCola;
import co.edu.upb.Domi.Grafo;
import co.edu.upb.Interface.DomicilioInterface;
import co.edu.upb.datos.ClientesConnection;
import co.edu.upb.datos.PedidoConnect;
import co.edu.upb.domain.Clientes;
import co.edu.upb.domain.Pedido;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;

public class MethotsDomicilio extends UnicastRemoteObject implements DomicilioInterface {

    private static String restaurante = "PROVENZA";
    public MethotsDomicilio() throws RemoteException {
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean createGrafo() throws RemoteException {
        Grafo grafo = new Grafo();
        grafo.createGrafo();
        if (grafo.crearConexionesGrafo()) {
            return true;
        } else {
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
        int ditance = 0;
        int distance2 = 0;
        Iterator iter = punto.iteratorObj();
        while (iter.hasNext()) {
            String valTemp = (String) iter.next();
            distance2 = Grafo.dijkstrasAlgorithm(Grafo.switchStrInt("PROVENZA"), Grafo.switchStrInt(valTemp));
            if (ditance >= distance2) {
                ditance = distance2;
                Grafo.vertice = valTemp;
            } else if (ditance < distance2) {
                ditance = distance2;
                Grafo.vertice = valTemp;
            }
        }
        return ditance;
    }

    @Override
    public String getrVerticeDistanciaMayor() {
        return Grafo.vertice;
    }

    public double calculateValDom(String puntoFin) {
        int distance = Grafo.dijkstrasAlgorithm(Grafo.switchStrInt("PROVENZA"), Grafo.switchStrInt(puntoFin));
        double valorDomi = Grafo.taza * distance;
        if (valorDomi <= Grafo.valMinDom) {
            return Grafo.valMinDom;
        } else {
            return valorDomi;
        }
    }

    /**
     * @param punto
     * @return
     * @throws RemoteException
     */
    @Override
    public DoubleLinkedList<String> rutaTotal(DoubleLinkedList<String> punto) throws RemoteException {
        String pInin = "PROVENZA";
        DoubleLinkedList<String> listRut = new DoubleLinkedList<>();
        Iterator iter = punto.iteratorObj();
        while (iter.hasNext()) {
            String valTem = (String) iter.next();
            int[] rutaTemp = Grafo.dijkstrasAlgorithmArry(Grafo.switchStrInt(pInin), Grafo.switchStrInt(valTem));
            String[] rsStr = Grafo.switcFor(rutaTemp);
            listRut.add(rsStr);
            pInin = valTem;
        }
        return listRut;
    }

    /**
     * @param pediDet
     * @return
     * @throws RemoteException
     */
    @Override
    public Clientes busqCliente(PedidosDetalle pediDet) throws RemoteException {
        PedidoConnect pedidoConnect = new PedidoConnect();
        Pedido pedi = pedidoConnect.select(pediDet.getIdPedidos());
        ClientesConnection cliCon = new ClientesConnection();
        Clientes cli = cliCon.selectIdCliente(pedi.getIdClientes());
        return cli;
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public PedidosDetalle popsColaDespacho() throws RemoteException {
        return DomiCola.popDespachoDomi();
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public int sizeCola() throws RemoteException {
        return DomiCola.size();
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean isEmptyCola() throws RemoteException {
        return DomiCola.isEmptyCola();
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String imprimirCola() throws RemoteException {
        return DomiCola.imprimirCola();
    }
}
