package serverPackage;

import java.io.*;
import java.net.*;

public class ServerMT extends Thread {

    private static int clientNumber = 0;
    public static int totalOperations = 0;

    public static synchronized void incrementOperations() {
        totalOperations++;
        System.out.println("→ Total d'opérations traitées : " + totalOperations);
    }

    public static void main(String[] args) {
        new ServerMT().start();
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(5050)) {
            System.out.println("Serveur en attente de clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientNumber++;

                System.out.println("\n=> Nouveau client connecté !");
                System.out.println("Client n°" + clientNumber);
                System.out.println("Adresse IP : " + clientSocket.getInetAddress().getHostAddress());
                System.out.println("Thread lancé pour le client n°" + clientNumber);

                new ClientProcess(clientSocket, clientNumber).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
