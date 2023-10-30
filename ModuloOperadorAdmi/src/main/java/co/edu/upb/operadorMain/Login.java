package co.edu.upb.operadorMain;

import co.edu.upb.Client.Client;
import co.edu.upb.Controlador.ControladorLogin;
import co.edu.upb.Modelo.ModeloLogin;
import co.edu.upb.Pantallas.Operador.InicioSesion;
import co.edu.upb.datos.ClientesConnection;
import co.edu.upb.datos.MenuConnect;
import co.edu.upb.datos.PedidoConnect;
import co.edu.upb.datos.PedidosDetalleConnet;
import co.edu.upb.domain.*;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
/**
 * Clase main
 *@author ChristianRodriguez
 */
public class Login {
    public static void main(String[] args) throws IOException {
        /*
        UsersConnect usersConnect = new UsersConnect();

        Users newUser = usersConnect.select("admin.pingu@gmail.com","admin1122" );
        if (newUser != null){
            System.out.println(newUser.getEmail());
            System.out.println(newUser.getTipo());
        }

         */
        /*
        //ControladorLogin inicioProgram = new ControladorLogin();
        ClientesConnection clientConn = new ClientesConnection();
        Clientes client = new Clientes();

        client = clientConn.select("301525845");
        if(client != null){
            System.out.println(client.getCorreo());
            System.out.println(client.getNombre());
        }

         */
        //ControladorLogin inicioProgram = new ControladorLogin();
/*
        ClientesConnection clien = new ClientesConnection();
        Clientes clientes = clien.select("301525845");

        PedidoConnect pedCon = new PedidoConnect();
        LocalDateTime locDa = LocalDateTime.now();
        Timestamp sqlDate = Timestamp.valueOf(locDa);

        Pedido pedi = new Pedido();
        pedi.setNmpedido(11);
        pedi = pedCon.select(pedi.getNmpedido());
        System.out.println(pedi.getNmpedido());

        MenuConnect menu =  new MenuConnect();
        Menu men = new Menu();
        men = menu.select("Hamburguesa ElPingu");
        System.out.println(men.getProduct());

        PedidosDetalleConnet pedidosDetalleConnet = new PedidosDetalleConnet();
        PedidosDetalle ped = new PedidosDetalle();
        ped.setEstatuPedido("Cola");
        ped.setCantidad(2);
        ped.setIdProducto(men.getIdProducto());
        men.setCamtProd(men.getCamtProd() - ped.getCantidad());
        menu.update(men);
        ped.setIdPedidos(pedi.getNmpedido());
        pedidosDetalleConnet.insert(ped);

 */

        /*PedidoConnect pedCon = new PedidoConnect();
        Pedido pedi;
        ClientesConnection clien = new ClientesConnection();
        Clientes clientes = clien.select("301525845");

        pedi = pedCon.selectCient(clientes.getIdClientes());
        System.out.println(pedi.getNmpedido());
        PedidosDetalleConnet pedidosDetalleConnet = new PedidosDetalleConnet();
        PedidosDetalle ped = new PedidosDetalle();
        ped.setCantidad(1);
        MenuConnect menu = new MenuConnect();
        Menu men = new Menu();
        ped.setIdProducto(menu.select("Hot Perro").getIdProducto());
        ped.setEstatuPedido("Domi");
        ped.setIdPedidos(pedi.getNmpedido());
        pedidosDetalleConnet.update(ped);*/

        /*ModeloLogin model = new ModeloLogin();
        Client cli = new Client("localhost", "5000", "serviceOperador");
        ControladorLogin conTrol = new ControladorLogin();*/
        ControladorLogin cont = new ControladorLogin();
        //Clientes clientes = new Clientes("Juan", "Carvajal", "35", "48", "Piedecuesta", "Piedecuesta", "30258792","jpjCarvajal@gmail", 1);
        //cli.bringCliente("30258792");
        //LocalDateTime locDa = LocalDateTime.now();
        //Timestamp sqlDate = Timestamp.valueOf(locDa);
        //Pedido pedi = new Pedido(Integer.parseInt(cli.bringCliente("30258792")), sqlDate, "Pedido");

           /* PedidosDetalle ped = new PedidosDetalle(Integer.parseInt(cli.selectPedido(Integer.parseInt(cli.bringCliente("30258792")))), Integer.parseInt(cli.selectProducto("Crazy Potato")),3,"Cola") ;
            cli.addPedidoDetalle(ped);*/
        //Users use = new Users(5, "IkerDomicilio@elPingu.com","Rappi12", 4,  "iker", "Casilla");
        //cli.editUser(use);
            /*Menu men = new Menu(5, "Pepito", 100, 1,18000,0);
            if(cli.editProducto(men)){
                System.out.println("si");
            }*/
            /*System.out.println(cli.verDblen());
            System.out.println("------------------");
            System.out.println(cli.verDbRap());

            System.out.println();*/
            /*if(cli.editClient(clientes)) {
                System.out.println("si");
            }*/

    }

        /*
        MenuConnect menu =  new MenuConnect();
        Menu men = new Menu();
        men.setProduct("Hamburguesa");
        men.setPrecio(23000);
        men.setCamtProd(125);
        men.setTiempoPrepRapi(5);
        men.setTiempoPrepLen(10);
        //menu.insert(men);
        Menu pruebaBus=menu.select("Hamburguesa");
        if (pruebaBus != null){
            System.out.println(pruebaBus.getProduct());
            System.out.println(pruebaBus.getPrecio());
        }

         */
}
