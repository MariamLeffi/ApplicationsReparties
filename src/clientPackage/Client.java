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

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));            
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));            
            
            Scanner sc = new Scanner(System.in);

            String op;
         // Validation avant envoi
            while (true) {
                System.out.print("Donner une opération valide : ");
                op = sc.nextLine().trim();

                // Vérifie le format de l’opération
                if (op.matches("^\\s*\\d+\\s*[-+*/]\\s*\\d+\\s*$")) {
                    // Vérifie si c’est une division par 0
                    if ((op.contains("/0"))||(op.contains("/ 0"))) {
                        System.out.println("Division par zéro interdite !");
                        continue;
                    }
                    break; // format correct
                } else {
                    System.out.println("Format invalide !");
                }
            }
            pw.println(op);
            pw.flush();

            String reponse = br.readLine();
            System.out.println("Réponse du serveur : " + reponse);

            sc.close();
            br.close();
            pw.close();
            socket.close();
            System.out.println("Connexion fermée.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
