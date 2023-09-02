package datos;
import java.sql.*;

public class Conexion {
    private static final String DB_URL_USERS ="jdbc:mysql://localhost:3306/pingu?useSSL=false";
    private static final String DB_USER= "root";
    private static final String DB_PASSWORD = "admin";
    public static Connection getConection() throws SQLException{
        return DriverManager.getConnection(DB_URL_USERS, DB_USER,DB_PASSWORD);
    }
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
