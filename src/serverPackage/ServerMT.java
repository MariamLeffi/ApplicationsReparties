package serverPackage;
import java.io.*;
import java.net.*;

public class ServerMT extends Thread {
		// Compteur global de clients
		private static int clientCount = 0;
		public static void main(String[] args) {
			new ServerMT().start();
			}
		public void run() {
			try (ServerSocket serverSocket= new ServerSocket(5050)) {
				System.out.println("Serveur en attente de clients...");
				while (true) {
					Socket clientSocket= serverSocket.accept();
					clientCount++;
					System.out.println("\n => Nouveau client connecté! ");
					System.out.println("Adresse IP:"+ clientSocket.getRemoteSocketAddress());
					System.out.println("Client n°" + clientCount);
					// Crée un thread pour gérer ce client
					new ClientProcess (clientSocket, clientCount).start();
				}
			} catch (IOException e) {
			e.printStackTrace();
			}
			}}