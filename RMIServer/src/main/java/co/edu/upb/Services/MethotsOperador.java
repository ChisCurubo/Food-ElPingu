package co.edu.upb.Services;

import co.edu.upb.Interface.OperadorInterface;
import co.edu.upb.datos.MenuConnect;
import co.edu.upb.datos.UsersConnect;
import co.edu.upb.domain.Menu;
import co.edu.upb.domain.Users;
import co.edu.upb.list.DoubleLinkedList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MethotsOperador extends UnicastRemoteObject implements OperadorInterface {

    public MethotsOperador() throws RemoteException {
    }

    @Override
    public boolean login(String user, String password) throws RemoteException {
        UsersConnect usersConnect = new UsersConnect();
        Users newUser = usersConnect.select(user, password);
        if (newUser.getEmail() != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String[] algortmoHammil(String platoSearch) throws RemoteException {
        MenuConnect menuConnect = new MenuConnect();
        String[] listMen = menuConnect.algrDistanciaHamming(platoSearch);
        if (listMen.length <= 0) {
            return null;
        } else {
            return listMen;
        }

    }
}

