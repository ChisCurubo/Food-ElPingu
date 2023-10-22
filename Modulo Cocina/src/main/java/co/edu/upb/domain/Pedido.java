package co.edu.upb.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Clase pedido  la cual sera un conector entre le cliente y pedidos detalle. Esta corresponde a la tabla pedidos en la base de datos
 *
 * @author ChristianRodriguez
 */
public class Pedido implements Serializable {
    /**
     * Atributos de la clase pedidos
     */
    private int nmpedido;
    private int idClientes;
    private Timestamp fecha;
    private String estatus;
    /**
     * Constructores de la clase
     * @param nmpedido
     * @param idClientes
     * @param fecha
     * @param estatus
     */

    public Pedido(int nmpedido, int idClientes, Timestamp fecha, String estatus) {
        this.nmpedido = nmpedido;
        this.idClientes = idClientes;
        this.fecha = fecha;
        this.estatus = estatus;
    }

    public Pedido(int idClientes, Timestamp fecha, String estatus) {
        this.idClientes = idClientes;
        this.fecha = fecha;
        this.estatus = estatus;
    }

    public Pedido() {

    }
    /**
     * Getters y setters de la clase, y de sus atributos
     * @return
     */

    public int getNmpedido() {
        return nmpedido;
    }

    public void setNmpedido(int nmpedido) {
        this.nmpedido = nmpedido;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
