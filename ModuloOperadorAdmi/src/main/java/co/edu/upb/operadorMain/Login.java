package co.edu.upb.operadorMain;

import co.edu.upb.Controlador.ControladorLogin;
import co.edu.upb.datos.ClientesConnection;
import co.edu.upb.datos.MenuConnect;
import co.edu.upb.datos.PedidoConnect;
import co.edu.upb.datos.PedidosDetalleConnet;
import co.edu.upb.domain.Clientes;
import co.edu.upb.domain.Menu;
import co.edu.upb.domain.Pedido;
import co.edu.upb.domain.PedidosDetalle;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalField;

public class Login {
    public static void main(String[] args) {
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
        PedidoConnect pedCon = new PedidoConnect();
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
        pedidosDetalleConnet.update(ped);
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
