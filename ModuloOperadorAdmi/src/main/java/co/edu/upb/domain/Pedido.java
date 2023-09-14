package co.edu.upb.domain;

public class Pedido {
private  int nmpedido;
private int idClientes;
private String fecha;
private String estatus;

    public Pedido(int nmpedido, int idClientes, String fecha, String estatus) {
        this.nmpedido = nmpedido;
        this.idClientes = idClientes;
        this.fecha = fecha;
        this.estatus = estatus;
    }

    public Pedido(int idClientes, String fecha, String estatus) {
        this.idClientes = idClientes;
        this.fecha = fecha;
        this.estatus = estatus;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
