package co.edu.upb.datos;

import java.sql.*;

public class Conexion {
    /**
     * //conexiones a base de datos url para conexion
     */
    private static final String DB_URL_USERS = "jdbc:mysql://localhost:3306/pingu?useSSL=false";
    /**
     * // usuario para la entrada a la base de datos
     */
    private static final String DB_USER = "root";
    /**
     * // contraseña para el ingreso a la base de datos
     */

    private static final String DB_PASSWORD = "123456Vega";

    /**
     * // Metodo de connexion a la base de datos, recoje los atributos ateriores
     */

    public static Connection getConection() throws SQLException {
        return DriverManager.getConnection(DB_URL_USERS, DB_USER, DB_PASSWORD);
    }

    /**
     * // metodos de close para las conecciones, escrituras e insersiones a la base de datos
     */
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }


}
