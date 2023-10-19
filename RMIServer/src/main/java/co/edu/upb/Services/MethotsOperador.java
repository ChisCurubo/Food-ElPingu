package co.edu.upb.Services;

import co.edu.upb.Clasificacion.CocinaCola;
import co.edu.upb.Interface.OperadorInterface;
import co.edu.upb.datos.*;
import co.edu.upb.domain.*;
import co.edu.upb.estructuras.colas.CilaPriiory;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MethotsOperador extends UnicastRemoteObject implements OperadorInterface {
    private static final long serialVersionUID = 3621271727859909664L;

    public MethotsOperador() throws RemoteException {
    }

    @Override
    public int login(String user, String password) throws RemoteException {
        UsersConnect usersConnect = new UsersConnect();
        Users newUser = usersConnect.select(user, password);
        if (newUser.getEmail() != null) {
            return newUser.getTipo();
        } else {
            return 1000;
        }
    }

    @Override
    public DoubleLinkedList<Menu> algortmoHammil(String platoSearch) throws RemoteException {
        try {
            MenuConnect menuConnect = new MenuConnect();
            DoubleLinkedList<Menu> listMen = menuConnect.distanciaCarvajal(platoSearch);
            return listMen;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean addCliente(Clientes clie) throws RemoteException {
        try {
            ClientesConnection cliCon = new ClientesConnection();
            cliCon.insert(clie);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String bringCliente(String num) throws RemoteException {
        ClientesConnection conCli = new ClientesConnection();
        Clientes clientes = conCli.select(num);
        String resStri = String.valueOf(clientes.getIdClientes());
        return resStri;
    }

    @Override
    public String bringClienteCompleate(String num) throws RemoteException {
        ClientesConnection conCli = new ClientesConnection();
        Clientes clientes = conCli.select(num);
        String resStri = String.valueOf(clientes.getIdClientes()) + "," + clientes.getNombre() + "," + clientes.getApellido() + "," + clientes.getCalle() + "," + clientes.getCarrera() + "," + clientes.getBarrio()
                + "," + clientes.getMunicipio() + "," + clientes.getTelefono() + "," + clientes.getCorreo() + "," + String.valueOf(clientes.getTipoCliente());

        return resStri;
    }

    @Override
    public boolean editClient(Clientes clie) throws RemoteException {
        ClientesConnection con = new ClientesConnection();
        if (con.update(clie) != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addPedidoDetalle(PedidosDetalle pedidosDetalle) throws RemoteException {
        try {
            PedidosDetalleConnet pediConn = new PedidosDetalleConnet();
            pediConn.insert(pedidosDetalle);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editPedidoDetalle(PedidosDetalle pedidosDetalle) throws RemoteException {
        try {
            PedidosDetalleConnet pediConn = new PedidosDetalleConnet();
            if (pediConn.update(pedidosDetalle) != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @param pedi
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean addPedido(Pedido pedi) throws RemoteException {
        try {
            PedidoConnect pediCon = new PedidoConnect();
            pediCon.insert(pedi);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @param idCliente
     * @return
     * @throws RemoteException
     */
    @Override
    public String selectPedido(int idCliente) throws RemoteException {
        try {
            PedidoConnect pediCon = new PedidoConnect();
            Pedido pedilo = pediCon.selectCient(idCliente);
            return String.valueOf(pedilo.getNmpedido());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @param pedi
     * @return
     * @throws RemoteException
     */
    @Override
    public Pedido selectIdPedido(int pedi) throws RemoteException {
        try {
            PedidoConnect pediCon = new PedidoConnect();
            Pedido pedilo = pediCon.select(pedi);
            return pedilo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param id
     * @return
     * @throws RemoteException
     */
    @Override
    public Clientes selctCliennte(int id) throws RemoteException {
        try {
            ClientesConnection cliCon = new ClientesConnection();
            Clientes cli = cliCon.selectIdCliente(id);
            if (cli != null) {
                return cli;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String selectPedidoCliente(int idCliente) throws RemoteException {
        try {
            PedidoConnect pediCon = new PedidoConnect();
            Pedido pedilo = pediCon.selectCient(idCliente);
            return String.valueOf(pedilo.getNmpedido());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public boolean addUser(Users use) throws RemoteException {
        try {
            UsersConnect userq = new UsersConnect();
            userq.insert(use);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @param str
     * @return
     * @throws RemoteException
     */
    @Override
    public Users selectUser(String str) throws RemoteException {
        try {
            UsersConnect userq = new UsersConnect();
            Users user = userq.selectEmail(str);
            if (user.getEmail() != null) {
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean editUser(Users user) throws RemoteException {
        try {
            UsersConnect pediConn = new UsersConnect();
            pediConn.insert(user);
            if (pediConn.update(user) != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addProducto(Menu men) throws RemoteException {
        try {
            MenuConnect menup = new MenuConnect();
            menup.insert(men);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editProducto(Menu men) throws RemoteException {
        try {
            MenuConnect menup = new MenuConnect();
            if (menup.update(men) != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @param men
     * @return
     * @throws RemoteException
     */
    @Override
    public String selectProducto(String men) throws RemoteException {
        try {
            MenuConnect menCon = new MenuConnect();
            String str = String.valueOf(menCon.select(men).getIdProducto());
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @param id
     * @return
     * @throws RemoteException
     */
    @Override
    public Menu selectProuctId(int id) throws RemoteException {
        try {
            MenuConnect menCon = new MenuConnect();
            Menu men = menCon.selectId(id);
            return men;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String verDblen() throws RemoteException {
        try {
            CocinaCola menCon = new CocinaCola();
            MenuConnect men = new MenuConnect();
            PedidosDetalleConnet pedidosDetalle = new PedidosDetalleConnet();
            ClientesConnection cliCon = new ClientesConnection();
            //menCon.addToColaCocina(men.selectId(8).getTiempoPrepRapi(), pedidosDetalle.selectIdDet(6), cliCon.selectIdCliente(2));


            return CocinaCola.imprimirColaLen();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public String verDbRap() throws RemoteException {
        try {
            CocinaCola menCon = new CocinaCola();
            MenuConnect men = new MenuConnect();
            PedidosDetalleConnet pedidosDetalle = new PedidosDetalleConnet();
            ClientesConnection cliCon = new ClientesConnection();
            //menCon.addToColaCocina(1, new PedidosDetalle(11,2,3,"Cola"), cliCon.selectIdCliente(1));
            return CocinaCola.imprimirColaRap();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param pedi
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean listPedido(DoubleLinkedList<PedidosDetalle> pedi) throws RemoteException {
        try {
            CocinaCola.clonelist(pedi);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}


