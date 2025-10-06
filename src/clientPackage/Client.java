package clientPackage;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            // La première étape :
            System.out.println("Je suis un client pas encore connecté…");

            // Connexion au serveur (adresse locale + port 5000)
            Socket socket = new Socket("192.168.56.1", 5000);

            // La deuxième étape :
            System.out.println("Je suis un client connecté !");

            // La dernière étape : Fermer le socket
            socket.close();
            System.out.println("Connexion fermée.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
