package co.edu.upb.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OperadorInterface extends Remote {
    public boolean login(String email, String contra) throws RemoteException;
}
