package co.edu.upb.operadorMain;

import co.edu.upb.Controlador.ControladorLogin;
import co.edu.upb.datos.MenuConnect;

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
        ControladorLogin inicioProgram = new ControladorLogin();

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
