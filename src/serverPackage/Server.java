package serverPackage;

import java.io.IOException;
import java.net.*;
import java.util.HashSet;
import java.util.Set;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(new InetSocketAddress(1234));
            System.out.println("=== Serveur UDP lancé sur le port 1234 ===");

            Set<SocketAddress> clients = new HashSet<>();

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket paquetRecu = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquetRecu);

                String msg = new String(paquetRecu.getData(), 0, paquetRecu.getLength());
                SocketAddress clientAddr = paquetRecu.getSocketAddress();

                // Ajouter le client si c'est un nouvel expéditeur
                clients.add(clientAddr);

                System.out.println("Message reçu de " + paquetRecu.getAddress().getHostAddress()
                                   + ":" + paquetRecu.getPort() + " -> " + msg);

                // Diffuser le message à tous les autres clients
                for (SocketAddress addr : clients) {
                    if (!addr.equals(clientAddr)) {
                        DatagramPacket paquetDiff = new DatagramPacket(
                                msg.getBytes(),
                                msg.length(),
                                ((InetSocketAddress) addr).getAddress(),
                                ((InetSocketAddress) addr).getPort()
                        );
                        socket.send(paquetDiff);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
