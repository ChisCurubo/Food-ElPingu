package co.edu.upb.Client;

import co.edu.upb.Interface.OperadorInterface;
import co.edu.upb.domain.*;
import co.edu.upb.estructuras.colas.CilaPriiory;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class Client implements OperadorInterface {
    private OperadorInterface service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;
    private static final long serialVersionUID = 3621271727859909664L;

    public Client(String ip, String port, String serviceName) {
        this.service = null;
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
    }

    public boolean isConnected() throws RemoteException {
        try {
            Naming.lookup(url);
            return true;
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

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
}