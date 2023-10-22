package co.edu.upb.datos;

import co.edu.upb.domain.Pedido;

import java.io.Serializable;
import java.sql.*;

/**
 * @author ChristianRodriguez
 * Clase de conexion a la tabla de pedidos en la base de datos, comunica al servidor con la base de datos
 */

public class PedidoConnect implements Serializable {
    /**
     * Sentencias para la conexion a la tabla de pedido
     */
    private static final String SQL_SELECT = "SELECT * FROM pingu.pedidos";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM pingu.pedidos WHERE nmpedido = ? ";
    private static final String SQL_SELECT_WHERE_Client = "SELECT * FROM pingu.pedidos WHERE idclientes = ? ";
    private static final String SQL_INSERT = "INSERT INTO pingu.pedidos (fechas, estatus, idclientes ) VALUES ( ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE pingu.pedidos SET estatus = ?, fechas =? WHERE nmpedido =?";
    private static final String SQL_DELETE = "DELETE FROM pingu.pedidos WHERE nmpedido =?";

    /**
     * Metodo de select
     * @param numped
     * @return Pedido
     */
    public Pedido select(int numped) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Pedido client = new Pedido();
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, numped);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                client.setFecha(rs.getTimestamp("fechas"));
                client.setEstatus(rs.getString("estatus"));
                client.setIdClientes(rs.getInt("idclientes"));
                client.setNmpedido(rs.getInt("nmpedido"));
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
     * Metodo select pero con idClientes
     * @param numped
     * @return
     */
    public Pedido selectCient(int numped) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Pedido client = new Pedido();
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_SELECT_WHERE_Client);
            stmt.setInt(1, numped);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                client.setFecha(rs.getTimestamp("fechas"));
                client.setEstatus(rs.getString("estatus"));
                client.setIdClientes(rs.getInt("idclientes"));
                client.setNmpedido(rs.getInt("nmpedido"));
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
    public int insert(Pedido client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setTimestamp(1, client.getFecha());
            stmt.setString(2, client.getEstatus());
            stmt.setInt(3, client.getIdClientes());
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
    public int update(Pedido client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, client.getEstatus());// Establece el nuevo valor del campo 'estatus'
            stmt.setTimestamp(2,client.getFecha());
            stmt.setInt(3, client.getNmpedido()); // Utiliza 'nmpedido' como condición

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
    public int delete(Pedido client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, client.getNmpedido());
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
