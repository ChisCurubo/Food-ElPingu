package co.edu.upb.datos;

import co.edu.upb.domain.Users;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsersConnect<T>  implements Serializable {
    /**
     * // estas son las instruciones para la base de datos para la tabla de usuarios
     */

    private static final String SQL_SELECT = "SELECT * FROM pingu.usuarios";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM pingu.usuarios WHERE email = ?  AND pwd = ? ";
    private static final String SQL_SELECT_WHERE_Clien = "SELECT * FROM pingu.usuarios WHERE email = ? ";
    private static final String SQL_INSERT = "INSERT INTO pingu.usuarios (email, pwd, tipo , nombre , apellido) VALUES ( ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE pingu.usuarios SET email = ?, pwd = ?, tipo = ? , nombre = ?, apellido = ? WHERE ID =?";
    private static final String SQL_DELETE = "DELETE FROM pingu.usuarios WHERE ID =?";

    //Metodos  para dataBase

    /**
     * // Metodo de sect para comprobar el usuario y contraseña, se hace una busqueda en la base de datos.
     * //devuelve el usuario lleno si lo encontro si no es nulo
     *
     * @param emailEn
     * @param pswEN
     * @return
     */

    public Users select(String emailEn, String pswEN) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Users user = new Users();
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_SELECT_WHERE);
            stmt.setString(1, emailEn);
            stmt.setString(2, pswEN);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setEmail(rs.getString("email"));
                user.setPwd(rs.getString("pwd"));
                user.setTipo(rs.getInt("tipo"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return user;
    }
    public Users selectEmail(String emailEn) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Users user = new Users();
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_SELECT_WHERE_Clien);
            stmt.setString(1, emailEn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setEmail(rs.getString("email"));
                user.setPwd(rs.getString("pwd"));
                user.setTipo(rs.getInt("tipo"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return user;
    }

    /**
     * insertar nuevo usuario usuaruio a la base de datos
     *
     * @param user
     * @return
     */
    public int insert(Users user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPwd());
            stmt.setInt(3, user.getTipo());
            stmt.setString(4, user.getNombre());
            stmt.setString(5, user.getApellido());
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
     * // acualizar info del usuario
     *
     * @param user
     * @return
     */

    public int update(Users user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPwd());
            stmt.setInt(3, user.getTipo());
            stmt.setString(4, user.getNombre());
            stmt.setString(5, user.getApellido());
            stmt.setInt(6, user.getID());

            // Log the SQL statement before executing it
            System.out.println("Executing SQL statement: " + stmt.toString());

            registros = stmt.executeUpdate();
            System.out.println("Records updated: " + registros);
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
     * // borrar un usuario
     *
     * @param user
     * @return
     */

    public int delete(Users user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, user.getID());
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
