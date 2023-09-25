package co.edu.upb.datos;

public class PedidosDetalleConnet {
    private static final String SQL_SELECT = "SELECT * FROM pingu.pedidos-detalles";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM pingu.pedidos-detalle WHERE id-pedido = ? ";
    private static final String SQL_INSERT = "INSERT INTO pingu.pedidos-detalles (id-pedidos, id-producto, cantidad, estatus-pedido ) VALUES ( ?, ?, ?,?)";
    private static final String SQL_UPDATE = "UPDATE pingu.pedidos-detalles SET estatus = ?, cantidad = ? , id-producto = ? WHERE id-pedido =?";
    private static final String SQL_DELETE = "DELETE FROM pingu.pedidos-detalles WHERE id-pedido =?";
}
