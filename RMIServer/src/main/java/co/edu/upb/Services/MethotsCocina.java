package co.edu.upb.Services;

import co.edu.upb.Clasificacion.CocinaCola;
import co.edu.upb.Domi.DomiCola;
import co.edu.upb.Interface.CocinaInterface;
import co.edu.upb.datos.PedidosDetalleConnet;
import co.edu.upb.domain.Clientes;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MethotsCocina extends UnicastRemoteObject implements CocinaInterface {
    public MethotsCocina() throws RemoteException {
    }

    DoubleLinkedList<PedidosDetalle> pedi = new DoubleLinkedList<>();

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public PedidosDetalle popColaLenta() throws RemoteException {
        try {
            /*PedidosDetalle ped = CocinaCola.popOfColaCocina(0);
            ped.setEstatuPedido("Cocina");
            PedidosDetalleConnet pedCon = new PedidosDetalleConnet();
            pedCon.updateEstatus(ped);
            pedi.add(ped);
            String str = ped.getIdDetalle() + "," + ped.getIdPedidos() + "," + ped.getIdProducto() + "," + ped.getCantidad() + "," + ped.getEstatuPedido();
            System.out.println(str);
            return ped;*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public PedidosDetalle popColaRapida() throws RemoteException {
        try {
            /*PedidosDetalle ped = CocinaCola.popOfColaCocina(1);
            ped.setEstatuPedido("Cocina");
            PedidosDetalleConnet pedCon = new PedidosDetalleConnet();
            pedCon.updateEstatus(ped);
            pedi.add(ped);
            String str = ped.getIdDetalle() + "," + ped.getIdPedidos() + "," + ped.getIdProducto() + "," + ped.getCantidad() + "," + ped.getEstatuPedido();
            System.out.println(str);
            return ped;*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String[] retainPedido() throws RemoteException {
        return new String[0];
    }

    /**
     * @param listPedidos
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean sendToDomi(DoubleLinkedList<PedidosDetalle> listPedidos) throws RemoteException {
        return DomiCola.adDomiCOla(listPedidos) ;
    }

   /* private boolean pruebaCocina() {
        PedidosDetalle pedi = new PedidosDetalle(11, 2, 3, "Cocinando");
        Clientes clie = new Clientes("Juan", "Carvajal", "35", "48", "Piedecuesta", "Piedecuesta", "30258792", "jpjCarvajal@gmail", 1);
        if (CocinaCola.addToColaCocina(1, pedi, clie)) {
            System.out.println("ingreso");
            return true;
        }
        return false;
    }*/
}
