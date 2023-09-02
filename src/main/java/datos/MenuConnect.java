package datos;

import domain.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuConnect {
    private static final String SQL_SELECT = "SELECT * FROM pingu.productos";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM pingu.productos WHERE producto = ? ";
    private static final String SQL_INSERT = "INSERT INTO pingu.productos (producto, cantidad, tiempoprep , precio, tiemporapi ) VALUES ( ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE pingu.productos SET producto = ?, cantidad = ?, tiempoprep = ? , precio = ?, tiemporapi = ? WHERE idproducto =?";
    private static final String SQL_DELETE = "DELETE FROM pingu.productos WHERE idproducto =?";

    //Metodos  para dataBase

    public Menu select(String product) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Menu menu = new Menu();
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_SELECT_WHERE);
            stmt.setString(1, product);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                menu.setProduct(rs.getString("producto"));
                menu.setCamtProd(rs.getInt("cantidad"));
                menu.setTiempoPrepLen(rs.getInt("tiempoprep"));
                menu.setTiempoPrepRapi(rs.getInt("tiemporapi"));
                menu.setPrecio(rs.getDouble("precio"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return menu;
    }

    public int insert(Menu menu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, menu.getProduct());
            stmt.setInt(2, menu.getCamtProd());
            stmt.setInt(3, menu.getTiempoPrepLen());
            stmt.setDouble(4, menu.getPrecio());
            stmt.setInt(5, menu.getTiempoPrepRapi());
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

    public int update(Menu menu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, menu.getProduct());
            stmt.setInt(2, menu.getCamtProd());
            stmt.setInt(3, menu.getTiempoPrepLen());
            stmt.setDouble(4, menu.getPrecio());
            stmt.setInt(5, menu.getTiempoPrepRapi());
            stmt.setInt(6, menu.getIdProducto());
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

    public int delete(Menu menu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, menu.getIdProducto());
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

