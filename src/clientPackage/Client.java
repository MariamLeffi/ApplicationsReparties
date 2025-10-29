package clientPackage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner sc = new Scanner(System.in);

            System.out.println("Client UDP connecté !!");
            System.out.print("Entrez votre nom d'utilisateur : ");
            String username = sc.nextLine();

            while (true) {
                System.out.print("Entrez un message (ou 'exit' pour quitter) : ");
                String message = sc.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Fermeture du client");
                    break;
                }

                // Préfixer le message avec le nom d'utilisateur
                String msgComplet = "[" + username + "] : " + message;
                byte[] buffer = msgComplet.getBytes();

                // Création du datagramme à envoyer
                DatagramPacket paquet = new DatagramPacket(buffer,buffer.length,InetAddress.getByName("localhost"),1234);
                       
                // Envoi du message au serveur
                socket.send(paquet);
            }

            sc.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
