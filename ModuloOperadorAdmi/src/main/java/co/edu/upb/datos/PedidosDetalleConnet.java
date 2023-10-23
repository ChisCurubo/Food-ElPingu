package co.edu.upb.datos;

import co.edu.upb.Clasificacion.CocinaCola;
import co.edu.upb.domain.Clientes;
import co.edu.upb.domain.Menu;
import co.edu.upb.domain.Pedido;
import co.edu.upb.domain.PedidosDetalle;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.io.Serializable;
import java.sql.*;
/**
 * @author ChristianRodriguez
 * Clase de conexion a la tabla de pedido-detalle en la base de datos, comunica al servidor con la base de datos
 */


public class PedidosDetalleConnet implements Serializable {
    /**
     * Sentencias para las conexiones a la tabla de pedido-detalle
     */
    private static final String SQL_SELECT = "SELECT * FROM pingu.`pedidos-detalle`";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM pingu.`pedidos-detalle` WHERE `id-pedidos` = ? ";
    private static final String SQL_SELECT_WHERE_IDdetalle = "SELECT * FROM pingu.`pedidos-detalle` WHERE `id-detalle` = ? ";
    private static final String SQL_INSERT = "INSERT INTO pingu.`pedidos-detalle` (`id-pedidos`, `id-producto`, `cantidad`, `estatus-pedido` ) VALUES ( ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE pingu.`pedidos-detalle` SET `estatus-pedido` = ?, `cantidad` = ? , `id-producto` = ? WHERE `id-pedidos` =?";
    private static final String SQL_UPDATE_Estatus = "UPDATE pingu.`pedidos-detalle` SET `estatus-pedido` = ? WHERE `id-pedidos` =?";
    private static final String SQL_UPDATE_Product = "UPDATE pingu.`pedidos-detalle` SET `estatus-pedido` = ?, `cantidad` = ? , id-producto` = ? WHERE `id-pedidos` =?";
    private static final String SQL_DELETE = "DELETE FROM pingu.`pedidos-detalle` WHERE `id-pedidos` =?";
    /**
     * // Atributos de la clase
     * Cola de prioridad que es la cola de la cocina
     *
     */
    public DoubleLinkedList<PedidosDetalle> listPedDet = new DoubleLinkedList<>();
    public CocinaCola colaPrioridadCocina = new CocinaCola();

    /**
     * metodo select para uso de la cola de prioridad  como busqueda id-detalle
     * @param idPedido
     * @return
     */
    public PedidosDetalle selectIdDet(int idPedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        PedidosDetalle pedidosDetalle = new PedidosDetalle();
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_SELECT_WHERE_IDdetalle);
            stmt.setInt(1, idPedido);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pedidosDetalle.setIdDetalle(rs.getInt("id-detalle"));
                pedidosDetalle.setIdPedidos(rs.getInt("id-pedidos"));
                pedidosDetalle.setIdProducto(rs.getInt("id-producto"));
                pedidosDetalle.setCantidad(rs.getInt("cantidad"));
                pedidosDetalle.setEstatuPedido(rs.getString("estatus-pedido"));
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
        try {
            MenuConnect menCon = new MenuConnect();
            Menu menu = menCon.selectId(pedidosDetalle.getIdProducto());

            PedidoConnect pediConn = new PedidoConnect();
            Pedido pedi = pediConn.select(pedidosDetalle.getIdPedidos());

            ClientesConnection cliCon = new ClientesConnection();
            Clientes cli = cliCon.selectIdCliente(pedi.getIdClientes());

            colaPrioridadCocina.addToColaCocina(menu.getTiempoPrepRapi(),pedidosDetalle, cli);

        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return pedidosDetalle;
    }

    /**
     * Metodo select usando como busqueda id-pedidos
     * @param idPedido
     * @return
     */

    public PedidosDetalle select(int idPedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        PedidosDetalle pedidosDetalle = new PedidosDetalle();
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, idPedido);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pedidosDetalle.setIdProducto(rs.getInt("id-producto"));
                pedidosDetalle.setCantidad(rs.getInt("cantidad"));
                pedidosDetalle.setEstatuPedido(rs.getString("estatus-pedido"));
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
        return pedidosDetalle;
    }

    /**
     * Metodo insert de la clase PedidosDetalleConnet para la tabla de pedidos detalles
     * @param pedidosDetalle
     * @return
     */
    public int insert(PedidosDetalle pedidosDetalle) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, pedidosDetalle.getIdPedidos());
            stmt.setInt(2, pedidosDetalle.getIdProducto());
            stmt.setInt(3, pedidosDetalle.getCantidad());
            stmt.setString(4, pedidosDetalle.getEstatuPedido());
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
        MenuConnect menCon = new MenuConnect();
        Menu menu=  menCon.selectId(pedidosDetalle.getIdProducto());
        PedidoConnect pediConn = new PedidoConnect();
        Pedido pedi =pediConn.selectCient(pedidosDetalle.getIdPedidos());
        ClientesConnection cliCon = new ClientesConnection();
        Clientes cli = cliCon.selectIdCliente(pedi.getIdClientes());
        if(menu.getTiempoPrepRapi() == 1){
            CocinaCola.colaPriorRap.addToCola(cli.getTipoCliente(), pedidosDetalle);
        } else {
            CocinaCola.colaPrioriLento.addToCola(cli.getTipoCliente(),pedidosDetalle);
        }
        return registros;
    }

    /**
     * Actualizar la tabla de pedidos-dellate
     * @param pedidosDetalle
     * @return
     */
    public int update(PedidosDetalle pedidosDetalle) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pedidosDetalle.getEstatuPedido());
            stmt.setInt(2,pedidosDetalle.getCantidad());
            stmt.setInt(3, pedidosDetalle.getIdProducto());
            stmt.setInt(4,pedidosDetalle.getIdPedidos());

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
     * Actualizar solamente el estatus
     * @param pedidosDetalle
     * @return
     */
    public int updateEstatus(PedidosDetalle pedidosDetalle) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pedidosDetalle.getEstatuPedido());
            stmt.setInt(2,pedidosDetalle.getCantidad());
            stmt.setInt(3, pedidosDetalle.getIdProducto());
            stmt.setInt(4,pedidosDetalle.getIdPedidos());

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
     * borrar registros de la tabla
     * se le pide un objeto para estar seguro del registro que se borra
     * @param pedidosDetalle
     * @return
     */
    public int delete(PedidosDetalle pedidosDetalle) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pedidosDetalle.getIdPedidos());
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
