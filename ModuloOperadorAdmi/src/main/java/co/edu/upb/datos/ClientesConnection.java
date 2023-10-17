package co.edu.upb.datos;

import co.edu.upb.domain.Clientes;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientesConnection implements Serializable {
    private static final String SQL_SELECT = "SELECT * FROM pingu.clientes";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM pingu.clientes WHERE telefono = ? ";
    private static final String SQL_INSERT = "INSERT INTO pingu.clientes (nombre, apellido, calle , carrera, barrio, municipio, telefono, correo, tipocliente ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE pingu.clientes SET nombre = ?, apellido = ?, calle = ? , carrera = ?, barrio = ?, municipio = ?, telefono = ? , correo = ?, tipocliente =? WHERE idclientes =?";
    private static final String SQL_DELETE = "DELETE FROM pingu.clientes WHERE idclientes =?";


    /**
     * // Metodo de sect para comprobar el producto, se hace una busqueda en la base de datos.
     *
     * @param telefono
     * @return
     */

    public Clientes select(String telefono) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Clientes client = new Clientes();
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_SELECT_WHERE);
            stmt.setString(1, telefono);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                client.setNombre(rs.getString("nombre"));
                client.setApellido(rs.getString("apellido"));
                client.setCalle(rs.getString("calle"));
                client.setCarrera(rs.getString("carrera"));
                client.setBarrio(rs.getString("barrio"));
                client.setMunicipio(rs.getString("municipio"));
                client.setTelefono(rs.getString("telefono"));
                client.setCorreo(rs.getString("correo"));
                client.setIdClientes(rs.getInt("idclientes"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return client;
    }

    /**
     * // metodo para insertar un nuevo producto al menu
     *
     * @param client
     * @return
     */
    public int insert(Clientes client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, client.getNombre());
            stmt.setString(2, client.getApellido());
            stmt.setString(3, client.getCalle());
            stmt.setString(4, client.getCarrera());
            stmt.setString(5, client.getBarrio());
            stmt.setString(6, client.getMunicipio());
            stmt.setString(7, client.getTelefono());
            stmt.setString(8, client.getCorreo());
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
    public int update(Clientes client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, client.getNombre());
            stmt.setString(2, client.getApellido());
            stmt.setString(3, client.getCalle());
            stmt.setString(4, client.getCarrera());
            stmt.setString(5, client.getBarrio());
            stmt.setString(6, client.getMunicipio());
            stmt.setString(7, client.getTelefono());
            stmt.setString(8, client.getCorreo());
            stmt.setInt(9, client.getIdClientes());
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
    public int delete(Clientes client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, client.getIdClientes());
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
