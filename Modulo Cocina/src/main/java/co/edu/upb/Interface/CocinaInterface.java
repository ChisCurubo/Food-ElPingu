package co.edu.upb.Interface;

import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *@author ChristianRodriguez
 * Esta es la interfaz del modulo cocina, en las cuales se encontraran los metodos que se utilizan en el modulo cocina
 */
public interface CocinaInterface extends Remote {

    public PedidosDetalle popColaLenta() throws RemoteException;

    public PedidosDetalle popColaRapida() throws RemoteException;

    public String[] retainPedido() throws RemoteException;
    public boolean  sendToDomi(DoubleLinkedList<PedidosDetalle> listPedidos) throws RemoteException;

}
