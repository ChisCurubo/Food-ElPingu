package co.edu.upb.datos;

import co.edu.upb.domain.Menu;
import co.edu.upb.estructuras.listas.DoubleLinkedList;
import co.edu.upb.estructuras.listas.DoubleListNode;

import java.io.Serializable;
import java.sql.*;
import java.util.Iterator;

public class MenuConnect implements Serializable {
    /**
     * // estas son las instruciones para la base de datos para la tabla de productos
     */

    private static final String SQL_SELECT = "SELECT * FROM pingu.productos";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM pingu.productos WHERE producto = ? ";
    private static final String SQL_SELECT_WHERE_ID = "SELECT producto FROM pingu.productos WHERE idproducto = ? ";
    private static final String SQL_SELECT_WHERE_ID_Tipo = "SELECT * FROM pingu.productos WHERE idproducto = ? ";
    private static final String SQL_INSERT = "INSERT INTO pingu.productos (producto, cantidad , precio, tiemporapi ) VALUES ( ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE pingu.productos SET producto = ?, cantidad = ?, tiempoprep = ? , precio = ?, tiemporapi = ? WHERE idproducto =?";
    private static final String SQL_DELETE = "DELETE FROM pingu.productos WHERE idproducto =?";



    public DoubleLinkedList<Menu> algrDistanciaHamming(String busqueda) {
        String platoSearch = busqueda;
        MenuConnect menuConnect = new MenuConnect();

        String plato = "";
        Menu menn;
        int idprod = 1;
        int size = menuConnect.selectSize();
        System.out.println(size);
        int cont = 0;
        DoubleLinkedList<Menu> listaProductos = new DoubleLinkedList<>();
        for (int i = 0; i < 8; i++) {
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
        listaProductos.imprimir();
        System.out.println("---------------------------------------");


        listaProductos = sortMenu(listaProductos);
        return listaProductos;
    }

    public DoubleLinkedList<Menu> distanciaCarvajal(String stringBusqueda) {
        DoubleLinkedList<Menu> listMen = new DoubleLinkedList<>();
        MenuConnect menuConnect = new MenuConnect();

        int size = menuConnect.selectSize();
        for (int j = 1; j <= size; j++) {
            Menu menn =  menuConnect.selectId(j);

            String[] palabras = menn.getProduct().split(" ");
            String[] stringProductoActual;
            if (palabras.length > 1) {
                stringProductoActual = new String[palabras.length + 1];
                System.arraycopy(palabras, 0, stringProductoActual, 0, palabras.length);
                stringProductoActual[palabras.length] = menn.getProduct();
            } else {
                stringProductoActual = palabras;
            }

            //Pasar busqueda a minusculas y quitar espacios
            stringBusqueda = stringBusqueda.toLowerCase().replace(" ", "");
            for (int i = 0; i < stringProductoActual.length; i++) {
                int igualdades = 0;
                int pos1 = 0;
                int pos2 = 0;
                //Pasar cada string del producto a minusculas para ser comparado
                stringProductoActual[i] = stringProductoActual[i].toLowerCase();
                //Definir limite de la iteracion a partir del string mas pequeño
                int limite = (stringBusqueda.length() > stringProductoActual[i].length()) ? stringProductoActual[i].length() : stringBusqueda.length();
                int iterador = 0;
                while (iterador < limite) {
                    //Comparar posicion con posicion (2-2)
                    if (stringBusqueda.charAt(pos1) == stringProductoActual[i].charAt(pos2)) {
                        igualdades++;
                        pos1++;
                        pos2++;
                    } else {
                        //Comprobar que existe una posicion siguiente
                        if ((pos2 + 1) < stringProductoActual[i].length()) {
                            //Comparar posicion con una adelante (2-3)
                            if (stringBusqueda.charAt(pos1) == stringProductoActual[i].charAt(pos2 + 1)) {
                                igualdades++;
                                pos1++;
                                pos2 += 2;
                                //Disminuir una iteracion si el stringBusqueda no es menor al string del producto
                                if (stringBusqueda.length() >= stringProductoActual[i].length()) {
                                    iterador++;
                                }
                            } else {
                                pos1++;
                                pos2++;
                            }
                        }
                    }
                    iterador++;
                }
                /* --- Determinar si la busqueda se parece al producto y agregarlo a los resultados ---
                Similitud = Dividir la cantidad de caracteres en las iguales para tener una proporción
                Sí la similitud es menor o igual a 1.5, si son similares.
                */

                if ((igualdades > 0) && ((double) stringBusqueda.length() / igualdades) <= 1.5) {
                    int distancia = stringBusqueda.length() / igualdades;
                    menn.setNumDistanciaHammil(distancia);
                    listMen.add(menn);
                    //Romper el ciclo en caso de encontrar una similitud con cualquiera de los strings de cada producto
                    break;
                }
            }
        }
        System.out.println("Resultado para: " + stringBusqueda);
        listMen.imprimir();
       return listMen;
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
        menFin.imprimir();
        return menFin;
    }

    public Menu[] toArrayMenu(DoubleLinkedList<Menu> menu) {
        Menu[] arryMen = new Menu[menu.size()];
        Iterator iter = menu.iterator();
        int cont = 0;
        while (iter.hasNext()) {
            DoubleListNode<Menu> menuNode = (DoubleListNode<Menu>) iter.next();
            arryMen[cont] = menuNode.getObject();
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
                menu.setIdProducto(rs.getInt("idproducto"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return menu;
    }

    public int selectSize() {
        Connection conn = null;
        PreparedStatement stmt = null;
        int size = 0;

        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_SELECT);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                size++;
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return size;
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

    public Menu selectId(int idproduct) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Menu menu = null;

        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_SELECT_WHERE_ID_Tipo);
            stmt.setInt(1, idproduct);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Create a Menu object and set its properties from the retrieved data
                menu = new Menu();
                menu.setIdProducto(rs.getInt("idproducto"));
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
            stmt.setDouble(3, menu.getPrecio());
            stmt.setInt(4, menu.getTiempoPrepRapi());
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

