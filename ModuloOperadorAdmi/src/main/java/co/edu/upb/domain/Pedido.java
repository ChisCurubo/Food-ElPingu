package co.edu.upb.domain;

import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Pedido implements Serializable {
    private int nmpedido;
    private int idClientes;
    private Timestamp fecha;
    private String estatus;

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
