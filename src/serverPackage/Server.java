package serverPackage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) {
        try {
            // Liaison du socket serveur au port 1234 avec InetSocketAddress
            InetSocketAddress adresse = new InetSocketAddress(1234);
            DatagramSocket socket = new DatagramSocket(adresse);

            System.out.println("=>Serveur UDP lancé sur le port 1234!!");
            while (true) {
                // Préparer le buffer pour recevoir un message
                byte[] buffer = new byte[1024];
                DatagramPacket paquetRecu = new DatagramPacket(buffer, buffer.length);

                // Réception d’un message
                socket.receive(paquetRecu);

                // Extraction du message reçu
                int taille = paquetRecu.getLength();
                String msg = new String(paquetRecu.getData(), 0, taille);

                // Affichage des infos du client et du message
                System.out.println("Message reçu de : " + paquetRecu.getAddress().getHostAddress()+ " : " + paquetRecu.getPort());
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
