package co.edu.upb.Clasificacion;

import co.edu.upb.domain.Clientes;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.colas.CilaPriiory;

public class CocinaCola {
    public static CilaPriiory<PedidosDetalle> colaPriorRap = new CilaPriiory<>(2);
    public static CilaPriiory<PedidosDetalle> colaPrioriLento = new CilaPriiory<>(2);

    public CocinaCola() {
    }

    public boolean addToColaCocina(int tipoPlato, PedidosDetalle pedDet, Clientes client) {
        if (tipoPlato == 1) {
            return colaPriorRap.addToCola(client.getTipoCliente(), pedDet);
        } else if (tipoPlato == 0) {
            return colaPrioriLento.addToCola(client.getTipoCliente(), pedDet);
        }
        return false;
    }
    public PedidosDetalle popOfColaCocina(int tipoPlato) {
        if (tipoPlato == 1) {
            return colaPriorRap.popcola();
        } else if (tipoPlato == 0) {
            return colaPrioriLento.popcola();
        }
        return null;
    }
    public String imprimirColaLen(){
        return colaPrioriLento.toString();
    }
    public String imprimirColaRap(){
        return colaPriorRap.toString();
    }
}
