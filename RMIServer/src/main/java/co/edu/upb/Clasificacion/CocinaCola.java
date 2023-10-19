package co.edu.upb.Clasificacion;

import co.edu.upb.domain.Clientes;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.colas.CilaPriiory;
import co.edu.upb.estructuras.colas.ColaPrioridadList;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.io.Serializable;
import java.util.Iterator;

public class CocinaCola implements Serializable {
    public static CilaPriiory<PedidosDetalle> colaPriorRap = new CilaPriiory<>(2);
    public static  CilaPriiory<PedidosDetalle> colaPrioriLento = new CilaPriiory<>(2);

    public static DoubleLinkedList<PedidosDetalle> pediDet = new DoubleLinkedList<>();

    public CocinaCola() {
    }

    public static   boolean addToColaCocina(int tipoPlato, PedidosDetalle pedDet, Clientes client) {
        if (tipoPlato == 1) {
            return colaPriorRap.addToCola(client.getTipoCliente(), pedDet);
        } else if (tipoPlato == 0) {
            return colaPrioriLento.addToCola(client.getTipoCliente(), pedDet);
        }
        return false;
    }
    public static PedidosDetalle popOfColaCocina(int tipoPlato) {
        if (tipoPlato == 1) {
            return colaPriorRap.popcola();
        } else if (tipoPlato == 0) {
            return colaPrioriLento.popcola();
        }
        return null;
    }
    public int size (){
        return colaPrioriLento.size();
    }
    public CilaPriiory<PedidosDetalle> getColaRap (){
        CilaPriiory<PedidosDetalle> pedi = colaPriorRap;
        return  pedi;
    }

    public CilaPriiory<PedidosDetalle> getColaLen (){
        CilaPriiory<PedidosDetalle> pedi = colaPrioriLento;
        return  pedi;
    }

    public String iterarCola (){
        //Iterator<PedidosDetalle> iter = colaPriorRap.
        return "";
    }
    public static String imprimirColaLen(){
        return colaPrioriLento.toString();
    }
    public  static String imprimirColaRap(){
        return colaPriorRap.toString();
    }

    public static boolean clonelist (DoubleLinkedList<PedidosDetalle> pediDetLis){
        pediDet = pediDetLis.cloneList();
        if(!pediDet.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
