package rmiServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiService.BanqueImpl;
import rmiService.IBanque;

public class BanqueServer {
    
    public static void main(String[] args) {
        try {
            // Créer l'instance du service distant
            IBanque banque = new BanqueImpl();
            
            // Créer le registre RMI sur le port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Enregistrer l'objet distant dans le registre
            registry.rebind("BanqueService", banque);
            
            System.out.println("Serveur RMI Banque démarré avec succès");
            System.out.println("En attente de connexions clients...");
            
        } catch (Exception e) {
            System.err.println("Erreur lors du démarrage du serveur : ");
            e.printStackTrace();
        }
    }
}