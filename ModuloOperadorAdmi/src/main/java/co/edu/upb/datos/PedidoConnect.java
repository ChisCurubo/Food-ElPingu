package co.edu.upb.datos;

public class PedidoConnect {
    private static final String SQL_SELECT = "SELECT * FROM pingu.pedidos";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM pingu.pedidos WHERE nmpedido = ? ";
    private static final String SQL_INSERT = "INSERT INTO pingu.pedidos (fecha, estatus, idclientes ) VALUES ( ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE pingu.pedidos SET estatus = ? WHERE nmpedido =?";
    private static final String SQL_DELETE = "DELETE FROM pingu.pedidos WHERE nmpedido =?";
}
