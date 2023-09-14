package co.edu.upb.Server;

public class IniServer {

    public static void main(String[] args) {
        Server serverDeploi = new Server("localhost","5000","serviceOperador");
        serverDeploi.deployServiceOperador();
        System.out.println("service on");
    }
}
