package clientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Je suis un client pas encore connecté…");

            Socket socket = new Socket("127.0.0.1", 5050);
            System.out.println("Je suis un client connecté !");

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            Scanner sc = new Scanner(System.in);

            int nb;
            do {
                System.out.print("Entrez un entier (0 pour quitter) : ");
                nb = sc.nextInt();

                dos.writeInt(nb);
                dos.flush();

                if (nb != 0) {
                    int resultat = dis.readInt();
                    System.out.println("Résultat reçu du serveur : " + resultat);
                } else {
                    System.out.println("Fin de la communication demandée.");
                }

            } while (nb != 0);

            // fermeture propre
            sc.close();
            dis.close();
            dos.close();
            socket.close();
            System.out.println("Connexion fermée.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
