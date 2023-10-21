package co.edu.upb.Interface;

import co.edu.upb.domain.Clientes;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DomicilioInterface extends Remote {
    public boolean createGrafo() throws RemoteException;
    public int rutaAPuntos(DoubleLinkedList<String> punto) throws RemoteException;
    public String getrVerticeDistanciaMayor() throws RemoteException;
    public double calculateValDom(String puntoFin)throws  RemoteException;
    public DoubleLinkedList<String> rutaTotal(DoubleLinkedList<String> puntoIni) throws RemoteException;
    public Clientes busqCliente(PedidosDetalle pediDet) throws RemoteException;


}
