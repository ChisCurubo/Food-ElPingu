package co.edu.upb.Interface;

import co.edu.upb.domain.Menu;
import co.edu.upb.list.DoubleLinkedList;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OperadorInterface extends Remote {
    public boolean login(String email, String contra) throws RemoteException;
    public String[] algortmoHammil(String platoSearch)throws RemoteException;
}
