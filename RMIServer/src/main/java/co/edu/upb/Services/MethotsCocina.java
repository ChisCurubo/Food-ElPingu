package co.edu.upb.Services;

import co.edu.upb.Clasificacion.CocinaCola;
import co.edu.upb.Interface.CocinaInterface;
import co.edu.upb.datos.PedidosDetalleConnet;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.rmi.RemoteException;

public class MethotsCocina implements CocinaInterface {
    public MethotsCocina() throws RemoteException {
    }
    DoubleLinkedList<PedidosDetalle> pedi = new DoubleLinkedList<>();

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String popColaLenta() throws RemoteException {
        CocinaCola cocina = new CocinaCola();
        PedidosDetalle ped = cocina.popOfColaCocina(0);
        ped.setEstatuPedido("Cocina");
        PedidosDetalleConnet pedCon = new PedidosDetalleConnet();
        pedCon.updateEstatus(ped);
        pedi.add(ped);
        String str = ped.getIdDetalle() + "," + ped.getIdPedidos() + "," + ped.getIdProducto() + "," + ped.getCantidad() + "," + ped.getEstatuPedido();
        return str;
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String popColaRapida() throws RemoteException {
        CocinaCola cocina = new CocinaCola();
        PedidosDetalle ped = cocina.popOfColaCocina(1);
        ped.setEstatuPedido("Cocina");
        PedidosDetalleConnet pedCon = new PedidosDetalleConnet();
        pedCon.updateEstatus(ped);
        pedi.add(ped);
        String str = ped.getIdDetalle() + "," + ped.getIdPedidos() + "," + ped.getIdProducto() + "," + ped.getCantidad() + "," + ped.getEstatuPedido();
        return str;
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String[] retainPedido() throws RemoteException {
        return new String[0];
    }
}
