package serverPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5050);
            System.out.println("Serveur prêt sur le port 5050. En attente d’un client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Un client est connecté !");

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            while (true) {
                int nb = dis.readInt(); // lire un entier envoyé par le client
                System.out.println("Serveur a reçu : " + nb);

                // condition d'arrêt
                if (nb == 0) {
                    System.out.println("Le client a envoyé 0 → fin de communication.");
                    break;
                }

                int resultat = nb * 5;
                System.out.println("Calcul : " + nb + " * 5 = " + resultat);

                dos.writeInt(resultat);
                dos.flush();
                System.out.println("Résultat envoyé au client : " + resultat);
            }

            // fermeture propre
            dis.close();
            dos.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Connexion fermée. Serveur arrêté.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
