package co.edu.upb.Interface;

import co.edu.upb.domain.PedidosDetalle;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CocinaInterface extends Remote {
    public PedidosDetalle popColaLenta ()throws RemoteException;
    public PedidosDetalle popColaRapida()throws RemoteException;
    public String[] retainPedido() throws RemoteException;
}
