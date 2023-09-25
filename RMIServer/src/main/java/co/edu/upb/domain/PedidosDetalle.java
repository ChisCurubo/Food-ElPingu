package co.edu.upb.domain;

public class PedidosDetalle {
    private int idDetalle;
    private  int idPedidos;
    private int idProducto;
    private int cantidad ;
    private String estatuPedido;

    public PedidosDetalle(int idDetalle, int idPedidos, int idProducto, int cantidad, String estatuPedido) {
        this.idDetalle = idDetalle;
        this.idPedidos = idPedidos;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.estatuPedido = estatuPedido;
    }

    public PedidosDetalle(int idPedidos, int idProducto, int cantidad, String estatuPedido) {
        this.idPedidos = idPedidos;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.estatuPedido = estatuPedido;
    }

    public PedidosDetalle() {

    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(int idPedidos) {
        this.idPedidos = idPedidos;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstatuPedido() {
        return estatuPedido;
    }

    public void setEstatuPedido(String estatuPedido) {
        this.estatuPedido = estatuPedido;
    }
}

