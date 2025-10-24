package serverPackage;
import java.io.*;
import java.net.Socket;

public class ClientProcess extends Thread{
	Socket clientSocket;
	private int clientNumber;
	public ClientProcess (Socket socket, int number) {
		this.clientSocket= socket;
		this.clientNumber= number;
		}
	public void run() {
		try {
			System.out.println("Thread lancé pour le client no clientNumber");
			PrintWriter pw =new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader br= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			// Envoi du numéro d'ordre au client
			pw.println("Bienvenue, vous êtes le client n" + clientNumber);
			// Lecture d'un message éventuel du client
			String message= br.readLine();
			System.out.println("Client n°"+ clientNumber+":"+message);
			// Fermeture
			br.close();
			pw.close();
			clientSocket.close();
			System.out.println("Client n" + clientNumber + "déconnecté.");
		} catch (IOException e) {

		}
		}
}