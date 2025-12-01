package rmiServer;

import rmiService.BanqueImpl;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class BanqueServer {
    public static void main(String[] args) {
        try {
            // 1. Démarrage du registre RMI
            LocateRegistry.createRegistry(1099);

            // 2. Chargement automatique de jndi.properties
            Context ctx = new InitialContext();

            // 3. Binding JNDI de l'objet distant
            BanqueImpl banque = new BanqueImpl();
            ctx.bind("BanqueService", banque);

            System.out.println("Serveur RMI démarré avec JNDI...");
        }
        catch (Exception e) {
            System.out.println("Erreur serveur : " + e.getMessage());
        }
    }
}
