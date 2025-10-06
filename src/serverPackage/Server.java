package serverPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            // La première étape : création du serveur
            ServerSocket serverSocket = new ServerSocket(5000); // port du serveur
            System.out.println("Je suis un serveur en attente de la connexion d'un client...");

            // La deuxième étape : attendre et accepter la connexion d’un client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Un client est connecté !");

            // La dernière étape : fermer les sockets
            clientSocket.close();
            serverSocket.close();
            System.out.println("Connexion fermée. Serveur arrêté.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
