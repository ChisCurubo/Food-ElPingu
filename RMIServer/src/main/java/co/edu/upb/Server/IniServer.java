package co.edu.upb.Server;

import co.edu.upb.Services.MethotsCocina;
import co.edu.upb.Services.MethotsOperador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class IniServer {

    public static void main(String[] args) throws IOException {
        /*Properties config = new Properties();

        File archivo = new File("pom.xml");
        String dir = archivo.getCanonicalPath();
        dir = dir.substring(0, (dir.length() - 7));
        dir += "config.properties";

        try (FileInputStream fin = new FileInputStream(new File(dir))) {
            config.load(fin);
            servidor = new ClienteRMI((String) config.get("IP"), (String) config.get("PORT"), (String) config.get("SERVICENAME"));
        } catch (Exception e) {
        }*/
        Properties config = new Properties();

        PatallaServer pant = new PatallaServer();
        pant.setVisible(true);
        MethotsOperador cocina = new MethotsOperador();
        cocina.verDblen();

    }
}
