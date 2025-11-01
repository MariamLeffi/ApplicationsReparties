package clientPackage;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serveurIP = InetAddress.getByName("localhost");
            int serveurPort = 1234;

            Scanner sc = new Scanner(System.in);
            System.out.print("Entrez votre nom d'utilisateur : ");
            String username = sc.nextLine();

            // Thread pour recevoir les messages
            Thread receiver = new Thread(() -> {
                byte[] buffer = new byte[1024];
                while (true) {
                    try {
                        DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
                        socket.receive(paquet);
                        String msg = new String(paquet.getData(), 0, paquet.getLength());
                        System.out.println("\n" + msg);
                        System.out.print("> ");
                    } catch (IOException e) {
                        break;
                    }
                }
            });
            receiver.start();

            // Thread principal pour envoyer des messages
            while (true) {
                System.out.print("> ");
                String message = sc.nextLine();
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Déconnexion du client...");
                    socket.close();
                    break;
                }
                String msgComplet = "[" + username + "] : " + message;
                DatagramPacket paquet = new DatagramPacket(msgComplet.getBytes(), msgComplet.length(),
                        serveurIP, serveurPort);
                socket.send(paquet);
            }

            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
