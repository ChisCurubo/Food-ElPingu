package co.edu.upb.Client;

import co.edu.upb.Interface.OperadorInterface;
import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.domain.*;
import co.edu.upb.estructuras.colas.CilaPriiory;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
/**
 * @author ChristianRodriguez
 * Clase que implementa la interfaz de CocinaInterface, esta clase permite la comunicacion entre modulo y servidor
 */
public class Client implements OperadorInterface {
    /**
     * Atributos de la clase , el atributo service permite acceder a la interfaz y comununicarse con el servidor
     */
    private OperadorInterface service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;
    private static final long serialVersionUID = 3621271727859909664L;

    /**
     *  Contructor para inicializar el servicio
     * @param ip
     * @param port
     * @param serviceName
     */

    public Client(String ip, String port, String serviceName) {
        this.service = null;
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
    }
    /**
     * Metodo para saber si esta activo el servidor
     * @return
     * @throws RemoteException
     */
    public boolean isConnected() throws RemoteException {
        try {
            Naming.lookup(url);
            return true;
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo del login  del usuario , en este devolvera un entero que funcionara como una bandera para el ingres
     * Ademas el email registrado queda logeado, y eso permite comprobar los permisos del usuario
     * @param user
     * @param password
     * @return
     * @throws RemoteException
     */

    @Override
    public int login(String user, String password) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.login(user, password);

        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return 1000;
        }
    }

    /**
     * Metodo de algortmo de distancia de Hamillil, este consta  de comparar cadenas de string y contar las semejasas eentre estas.
     * Sin embargo se realizo modificaciones al algortmo que funcionara mejor.
     * @param platoSearch
     * @return
     * @throws RemoteException
     */
    @Override
    public DoubleLinkedList<Menu> algortmoHammil(String platoSearch) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            DoubleLinkedList<Menu> algotList = service.algortmoHammil(platoSearch);
            return algotList;
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Metodo para añadir clientes a la base de datos, y añadir clientes nuevos
     * @param clie
     * @return
     * @throws RemoteException
     */

    @Override
    public boolean addCliente(Clientes clie) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.addCliente(clie);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para hacer un select a la base datos segun el id del pedido
     * @param num
     * @return
     * @throws RemoteException
     */
    @Override
    public String bringCliente(String num) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.bringCliente(num);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * MEtodo que trae el cliente, pero en vez de traerlo como un objeto lo trae como String
     * @param num
     * @return
     * @throws RemoteException
     */
    @Override
    public String bringClienteCompleate(String num) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.bringClienteCompleate(num);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para editar Clientes en la base de datos
     * Devuelve un boolean si lo añadio bien true, si no false
     * @param clie
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean editClient(Clientes clie) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.editClient(clie);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para añadir un nuevo pedidoDetalle a la base de datos, ademas en el mismo metodo lo añade a la cola de prioridad de cocina
     * devuelve true si lo hizo, false si no
     * @param pedidosDetalle
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean addPedidoDetalle(PedidosDetalle pedidosDetalle) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.addPedidoDetalle(pedidosDetalle);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para editar un pedidoDetalle (osea un pedido del cliente)
     * devuelve true si fue editado, y false si no.
     * @param pedidosDetalle
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean editPedidoDetalle(PedidosDetalle pedidosDetalle) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.editPedidoDetalle(pedidosDetalle);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para crear/ añadir un pedido a la base de datos
     * Devuelve  true si lo hizo, false si no
     * @param pedi
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean addPedido(Pedido pedi) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.addPedido(pedi);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para hacer select a la tabla de pedidos detalle, trae la informacion en forma de string
     * @param pedi
     * @return
     * @throws RemoteException
     */
    @Override
    public String selectPedido(int pedi) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.selectPedido(pedi);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Realiza el select a la tabla de clientes , solo que este trae el cliente serializado
     * como parametro usa el id del cliente
     * @param id
     * @return
     * @throws RemoteException
     */
    @Override
    public Clientes selctCliennte(int id) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.selctCliennte(id);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo que realiza el selct de la tabla pedidos , mediante el id
     * devuelve un objeto tipo pedido
     * @param pedi
     * @return
     * @throws RemoteException
     */
    @Override
    public Pedido selectIdPedido(int pedi) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.selectIdPedido(pedi);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Select a la tabla pedidos pero por el id del cliente
     * Devuelve un string
     * @param idCliente
     * @return
     * @throws RemoteException
     */
    @Override
    public String selectPedidoCliente(int idCliente) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.selectPedidoCliente(idCliente);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para añaddir un nuevo usuario a la tabla usuarios
     * devuelve true si lo inserto, false si no
     * @param use
     * @return
     * @throws RemoteException
     */

    @Override
    public boolean addUser(Users use) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.addUser(use);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para selecionar un usuario de la tabla
     * devuelve un objeto tipo USers
     * @param str
     * @return
     * @throws RemoteException
     */
    @Override
    public Users selectUser(String str) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.selectUser(str);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para editar usuario de la tabla
     * devueve true si lo editp, false si no
     * @param user
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean editUser(Users user) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.editUser(user);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para añadir productos a la tabla de products
     * Devuelve true si lo añade, fasle si no
     * @param men
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean addProducto(Menu men) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.addProducto(men);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * metodo para editar El producto,
     * devuelve true si lo hizo , false si no
     * @param men
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean editProducto(Menu men) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.editProducto(men);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Select de un producto, para tarer el producto por id de este
     * @param id
     * @return
     * @throws RemoteException
     */
    @Override
    public Menu selectProuctId(int id) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.selectProuctId(id);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Hace select pero dependiendo del  nombre del producto
     * @param men
     * @return
     * @throws RemoteException
     */
    @Override
    public String selectProducto(String men) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.selectProducto(men);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Trae la cola lenta de la cocina , para poder observar el proceso dentro
     * @return
     * @throws RemoteException
     */
    public String verDblen() throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.verDblen();
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Trae la cola rapida de la cocina , para poder observar el proceso dentro, y manipularla
     * @return
     * @throws RemoteException
     */
    public String verDbRap() throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.verDbRap();
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Empaqueta todo el pedido de un cliente y lo envia al servidor
     * @param pedi
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean listPedido(DoubleLinkedList<PedidosDetalle> pedi) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.listPedido(pedi);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Recoge el valor del domicilio segun la ubicacion del cliente
     * @return
     * @throws RemoteException
     */
    @Override
    public double getrValorDomiOp(String punto) throws RemoteException {
       try {
           service = (OperadorInterface) Naming.lookup(url);
           return service.getrValorDomiOp(punto);
       }catch (NotBoundException e) {
           throw new RuntimeException(e);
       } catch (MalformedURLException e) {
           throw new RuntimeException(e);
       }
    }

    /**
     * Crea el grafo para ser recorrido
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean createGrafo() throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.createGrafo();
        }catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Trae la cola del domicilio para supervisar el estaddo de esta
     * @return
     * @throws RemoteException
     */
    @Override
    public String verColaDomi() throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.verColaDomi();
        }catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Trae el producto mas pedido del cliente
     * @return
     * @throws RemoteException
     */
    @Override
    public Menu getMostPedidoClient(int id) throws RemoteException {
        try {
            service = (OperadorInterface) Naming.lookup(url);
            return service.getMostPedidoClient(id);
        }catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}