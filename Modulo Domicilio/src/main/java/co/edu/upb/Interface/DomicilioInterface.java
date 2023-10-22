package co.edu.upb.Interface;

import co.edu.upb.domain.Clientes;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaz en el modulo de domicilio , en las cuales se encontraran los metodos que se utilizaran  en este modulo
 * @author ChristianRodriguez
 */
public interface DomicilioInterface extends Remote {
    public boolean createGrafo() throws RemoteException;
    public int rutaAPuntos(DoubleLinkedList<String> punto) throws RemoteException;
    public String getrVerticeDistanciaMayor() throws RemoteException;
    public double calculateValDom(String puntoFin)throws  RemoteException;
    public DoubleLinkedList<String> rutaTotal(DoubleLinkedList<String> puntoIni) throws RemoteException;
    public Clientes busqCliente(PedidosDetalle pediDet) throws RemoteException;
    public PedidosDetalle popsColaDespacho()throws RemoteException;
    public int sizeCola ()throws RemoteException;
    public boolean isEmptyCola ()throws RemoteException;
    public String imprimirCola() throws RemoteException;



}
