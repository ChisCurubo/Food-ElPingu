package co.edu.upb.operador;

import Pantallas.InicioSesion;
import datos.MenuConnect;
import datos.UsersConnect;
import domain.Menu;
import domain.Users;

public class Login {
    public static void main(String[] args) {
        /*UsersConnect usersConnect = new UsersConnect();

        Users newUser = usersConnect.select("admin.pingu@gmail.com","admin1122" );
        if (newUser != null){
            System.out.println(newUser.getEmail());
            System.out.println(newUser.getTipo());
        }
        InicioSesion ini = new InicioSesion();
    }
         */
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
    }
}
