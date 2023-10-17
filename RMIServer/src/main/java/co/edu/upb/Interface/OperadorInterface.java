package co.edu.upb.Interface;

import co.edu.upb.domain.*;
import co.edu.upb.estructuras.colas.CilaPriiory;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OperadorInterface extends Remote {
    public int login(String email, String contra) throws RemoteException;
    public DoubleLinkedList<Menu> algortmoHammil(String platoSearch)throws RemoteException;
    public boolean addCliente (Clientes clie)throws RemoteException;
    public String bringCliente(String num)throws  RemoteException;
    public String bringClienteCompleate(String num) throws RemoteException;
    public boolean editClient ( Clientes clie)throws RemoteException;
    public boolean addPedidoDetalle(PedidosDetalle pedidosDetalle) throws RemoteException;
    public  boolean editPedidoDetalle(PedidosDetalle pedidosDetalle) throws RemoteException;
    public boolean addPedido (Pedido pedi)throws  RemoteException;
    public String selectPedido(int pedi) throws RemoteException;
    public String selectPedidoCliente(int idCliente) throws RemoteException;
    public boolean addUser (Users use)throws RemoteException;
    public Users selectUser(String str)throws RemoteException;
    public boolean editUser(Users user) throws RemoteException;
    public  boolean addProducto ( Menu men)throws RemoteException;
    public boolean editProducto(Menu men) throws RemoteException;
    public String selectProducto ( String men ) throws RemoteException;
    public CilaPriiory<PedidosDetalle> verDblen() throws RemoteException;
    public CilaPriiory<PedidosDetalle> verDbRap() throws RemoteException;
}
