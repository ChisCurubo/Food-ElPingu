package co.edu.upb.Domi;

import co.edu.upb.domain.Clientes;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.colas.CilaPriiory;
import co.edu.upb.estructuras.colas.ColaPrioridadList;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.util.Iterator;

public class DomiCola {
    public static ColaPrioridadList<PedidosDetalle> colaDespacho = new ColaPrioridadList<>();

    public DomiCola(){
    }
    public static  boolean adDomiCOla(DoubleLinkedList<PedidosDetalle> listDet) {
        Iterator iter = listDet.iteratorObj();
        while (iter.hasNext()){
            PedidosDetalle pedi = (PedidosDetalle) iter.next();
            colaDespacho.push(pedi);
        }
        return true;
    }
    public static PedidosDetalle popDespachoDomi() {
       return colaDespacho.pop();
    }
    public static int size(){
        return colaDespacho.size();
    }
    public ColaPrioridadList<PedidosDetalle> getCola (){
        ColaPrioridadList<PedidosDetalle> pedi = colaDespacho;
        return  pedi;
    }


    public static boolean isEmptyCola(){
        return colaDespacho.isEmpty();
    }
    public static String imprimirCola(){
        return colaDespacho.print();
    }


}
