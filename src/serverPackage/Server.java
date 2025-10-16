package serverPackage;
import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) {
        try {
            InetAddress adresseLocale = InetAddress.getLocalHost();
            int port = 5050;

            System.out.println("Adresse IP du serveur : " + adresseLocale.getHostAddress());
            System.out.println("Serveur prêt sur le port " + port);

            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(adresseLocale, port));

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connecté !");

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            while (true) {
                String operation = dis.readUTF();
                if (operation.equalsIgnoreCase("exit")) {
                    System.out.println("Fin de la communication.");
                    break;
                }
                double a = dis.readDouble();
                double b = dis.readDouble();
                double resultat = 0;

                switch (operation) {
                    case "+":
                        resultat = a + b;
                        break;
                    case "-":
                        resultat = a - b;
                        break;
                    case "*":
                        resultat = a * b;
                        break;
                    case "/":
                        if (b == 0) {
                            dos.writeUTF("Erreur : Division par zéro !");
                            continue;
                        }
                        resultat = a / b;
                        break;
                    default:
                        dos.writeUTF("Opération inconnue !");
                        continue;
                }
                dos.writeUTF("Résultat : " + resultat);
                dos.flush();
            }

            dis.close();
            dos.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Serveur arrêté.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
