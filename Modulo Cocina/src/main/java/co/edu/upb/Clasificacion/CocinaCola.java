package co.edu.upb.Clasificacion;

import co.edu.upb.datos.Conexion;
import co.edu.upb.domain.Clientes;
import co.edu.upb.domain.Menu;
import co.edu.upb.domain.Pedido;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.colas.CilaPriiory;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author ChristianRodriguez
 * Clase de la cola de la cocina, y sus metodos para añadir e imprimir
 */

public class CocinaCola {
    /**
     * Atributos los cuales son colas de prioridad.
     * para esta divicion se uso 2 colas para procesar la información
     */
    public static CilaPriiory<PedidosDetalle> colaPriorRap = new CilaPriiory<>(2);
    public static CilaPriiory<PedidosDetalle> colaPrioriLento = new CilaPriiory<>(2);


    /**
     * Constructor de la cola
     */
    public CocinaCola() {
    }

    /**
     * Metodo para añadir a las colas de prioridad
     * @param tipoPlato
     * @param pedDet
     * @param client
     * @return
     */
    public boolean addToColaCocina(int tipoPlato, PedidosDetalle pedDet, Clientes client) {
        if (tipoPlato == 1) {
            return colaPriorRap.addToCola(client.getTipoCliente(), pedDet);
        } else if (tipoPlato == 0) {
            return colaPrioriLento.addToCola(client.getTipoCliente(), pedDet);
        }
        return false;
    }

    /**
     * Metodo para extarer pedidos detalle de la cola de prioridad
     * @param tipoPlato
     * @return
     */
    public PedidosDetalle popOfColaCocina(int tipoPlato) {
        if (tipoPlato == 1) {
            return colaPriorRap.popcola();
        } else if (tipoPlato == 0) {
            return colaPrioriLento.popcola();
        }
        return null;
    }

    /**
     * Metodo para imprimir la cola de prioridad de los fogones lentos
     * @return
     */
    public String imprimirColaLen(){
        return colaPrioriLento.imprimir();
    }

    /**
     * Metodo para imprimir la cola de prioridad de fogones rapidos
     * @return
     */
    public String imprimirColaRap(){
        return colaPriorRap.imprimir();
    }
}
