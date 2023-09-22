package co.edu.upb.datos;

import co.edu.upb.domain.Menu;
import co.edu.upb.list.DoubleLinkedList;
import co.edu.upb.list.DoubleListNode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class MenuConnect {
    private static final String SQL_SELECT = "SELECT * FROM pingu.productos";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM pingu.productos WHERE producto = ? ";
    private static final String SQL_SELECT_WHERE_ID = "SELECT producto FROM pingu.productos WHERE idproducto = ? ";
    private static final String SQL_INSERT = "INSERT INTO pingu.productos (producto, cantidad, tiempoprep , precio, tiemporapi ) VALUES ( ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE pingu.productos SET producto = ?, cantidad = ?, tiempoprep = ? , precio = ?, tiemporapi = ? WHERE idproducto =?";
    private static final String SQL_DELETE = "DELETE FROM pingu.productos WHERE idproducto =?";

    public String [] algrDistanciaHamming(String busqueda) {
        String platoSearch = busqueda;
        String plato = "";
        Menu menn;
        int idprod = 1;
        int cont = 0;
        DoubleLinkedList<Menu> listaProductos = new DoubleLinkedList<>();
        for (int i = 0; i < 7; i++) {
            plato = selectIdAlgortm(idprod);
            menn = new Menu();
            idprod++;
            cont = 0;
            for (int j = 0; j < platoSearch.length(); j++) {
                if (platoSearch.charAt(j) == plato.charAt(j)) {
                    cont++;
                }
            }
            menn.setNumDistanciaHammil(cont);
            menn.setProduct(plato);
            listaProductos.add(menn);
        }


        listaProductos = sortMenu(listaProductos);
        String[] resString = toArrayString(listaProductos);
        return resString;
    }

    public DoubleLinkedList<Menu> sortMenu(DoubleLinkedList<Menu> menupe) {
        DoubleLinkedList<Menu> menFin = new DoubleLinkedList<>();
        Menu[] arryLis = toArrayMenu(menupe);
        for (int gap = arryLis.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arryLis.length; i++) {
                Menu tempVal = arryLis[i];
                int j = i;
                while (j >= gap && arryLis[j - gap].getNumDistanciaHammil() <= tempVal.getNumDistanciaHammil()) {
                    arryLis[j] = arryLis[j - gap];
                    j -= gap;
                }
                arryLis[j] = tempVal;
            }
        }
        menFin.add(arryLis);
        return menFin;
    }

    private Menu[] toArrayMenu(DoubleLinkedList<Menu> menu) {
        Menu[] arryMen = new Menu[menu.size()];
        Iterator iter = menu.iterator();
        int cont = 0;
        while (iter.hasNext()){
            DoubleListNode<Menu> menuNode = (DoubleListNode<Menu>) iter.next();
            arryMen[cont] = menuNode.getObject();
            cont++;
        }
        return arryMen;
    }
    private String[] toArrayString(DoubleLinkedList<Menu> menu) {
        String[] arryMen = new String[menu.size()];
        Iterator iter = menu.iterator();
        int cont = 0;
        while (iter.hasNext()){
            DoubleListNode<Menu> menuNode = (DoubleListNode<Menu>) iter.next();
            arryMen[cont] = menuNode.getObject().getProduct();
            cont++;
        }
        return arryMen;
    }

/*
    T[] arryLis = toArray();
                for (int gap = arryLis.length / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < arryLis.length; i++) {
            T tempVal = arryLis[i];
            int j = i;
            while (j >= gap && Integer.parseInt(arryLis[j - gap].toString()) <= Integer.parseInt(tempVal.toString())) {
                arryLis[j] = arryLis[j - gap];
                j -= gap;
            }
            arryLis[j] = tempVal;
        }
    }
    clear();
    add(arryLis);

 */

//Metodos  para dataBase

    /**
     * // Metodo de sect para comprobar el producto, se hace una busqueda en la base de datos.
     *
     * @param product
     * @return
     */

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

    public String selectIdAlgortm(int idproduct) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String product = "";
        Menu menu = new Menu();
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_SELECT_WHERE_ID);
            stmt.setInt(1, idproduct);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                menu.setProduct(rs.getString("producto"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return menu.getProduct();
    }

    /**
     * // metodo para insertar un nuevo producto al menu
     *
     * @param menu
     * @return
     */
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

    /**
     * // actualizar un producto del menu
     *
     * @param menu
     * @return
     */
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

    /**
     * // borrar un producto del menu
     *
     * @param menu
     * @return
     */
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
