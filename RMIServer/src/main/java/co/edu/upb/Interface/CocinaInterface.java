package co.edu.upb.Interface;

import java.rmi.RemoteException;

public interface CocinaInterface {
    public String popColaLenta ()throws RemoteException;
    public String popColaRapida()throws RemoteException;
    public String[] retainPedido() throws RemoteException;
}
