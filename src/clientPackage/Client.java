package clientPackage;
import java.io.*;
import java.net.Socket;
public class Client {
	public static void main(String[] args) {
			try {
				System.out.println("Je suis un client pas encore connecté..");
				
				Socket socket= new Socket("127.0.0.1", 5050);
				System.out.println("Je suis un client connecté !");
				
				BufferedReader br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
				
				String response= br.readLine();
				System.out.println("Serveur: " + response);
				
				pw.println("Merci serveur, bien reçu !");
				
				br.close();
				pw.close();
				socket.close();
				System.out.println("Connexion fermée.");
			} catch (IOException e) {
				e.printStackTrace();
}
}
}