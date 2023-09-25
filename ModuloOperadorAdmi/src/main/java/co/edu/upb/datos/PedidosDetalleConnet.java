package co.edu.upb.datos;

import co.edu.upb.domain.Pedido;
import co.edu.upb.domain.PedidosDetalle;

import java.sql.*;

public class PedidosDetalleConnet {
    private static final String SQL_SELECT = "SELECT * FROM pingu.`pedidos-detalle`";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM pingu.`pedidos-detalle` WHERE `id-pedidos` = ? ";
    private static final String SQL_INSERT = "INSERT INTO pingu.`pedidos-detalle` (`id-pedidos`, `id-producto`, `cantidad`, `estatus-pedido` ) VALUES ( ?, ?, ?, ?)";
   // INSERT INTO `table-detalles` (`id-pedidos`, `id-producto`, `cantidad`, `estatus-pedido`) VALUES (?, ?, ?, ?)"
    private static final String SQL_UPDATE = "UPDATE pingu.`pedidos-detalle` SET `estatus-pedido` = ?, `cantidad` = ? , `id-producto` = ? WHERE `id-pedidos` =?";
    private static final String SQL_UPDATE_Estatus = "UPDATE pingu.`pedidos-detalle` SET `estatus-pedido` = ? WHERE `id-pedidos` =?";
    private static final String SQL_UPDATE_Product = "UPDATE pingu.`pedidos-detalle` SET `estatus-pedido` = ?, `cantidad` = ? , id-producto` = ? WHERE `id-pedidos` =?";
    private static final String SQL_DELETE = "DELETE FROM pingu.`pedidos-detalle` WHERE `id-pedidos` =?";

    public PedidosDetalle select(int idPedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        PedidosDetalle client = new PedidosDetalle();
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, idPedido);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                client.setIdProducto(rs.getInt("id-producto"));
                client.setCantidad(rs.getInt("cantidad"));
                client.setEstatuPedido(rs.getString("estatus-pedido"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle the foreign key constraint violation
            System.err.println("Foreign key constraint violation: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException ex) {
            // Handle other SQL exceptions
            ex.printStackTrace();
        }
        return client;
    }

    /**
     * // metodo para insertar un nuevo producto al menu
     *
     * @param client
     * @return
     */
    public int insert(PedidosDetalle client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, client.getIdPedidos());
            stmt.setInt(2, client.getIdProducto());
            stmt.setInt(3, client.getCantidad());
            stmt.setString(4, client.getEstatuPedido());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    /**
     * // actualizar un producto del menu
     *
     * @param client
     * @return
     */
    public int update(PedidosDetalle client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, client.getEstatuPedido());
            stmt.setInt(2,client.getCantidad());
            stmt.setInt(3, client.getIdProducto());
            stmt.setInt(4,client.getIdPedidos());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    public int updateEstatus(PedidosDetalle client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, client.getEstatuPedido());
            stmt.setInt(2,client.getCantidad());
            stmt.setInt(3, client.getIdProducto());
            stmt.setInt(4,client.getIdPedidos());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    /**
     * // borrar un producto del menu
     *
     * @param client
     * @return
     */
    public int delete(PedidosDetalle client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, client.getIdPedidos());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
