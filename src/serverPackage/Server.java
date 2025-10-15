package serverPackage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5050);
            System.out.println("Serveur prêt sur le port 5050. En attente d’un client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Un client est connecté !");

            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

            String op = br.readLine();
            System.out.println("Opération reçue du client : " + op);

            op = op.replaceAll("\\s+", "");

            double a = 0, b = 0;
            char operateur = ' ';
            int i = 0;
            StringBuilder nb1 = new StringBuilder();
            StringBuilder nb2 = new StringBuilder();

            while (i < op.length() && (Character.isDigit(op.charAt(i)) || op.charAt(i) == '.')) {
                nb1.append(op.charAt(i));
                i++;
            }
            if (i < op.length()) {
                operateur = op.charAt(i);
                i++;
            }
            while (i < op.length() && (Character.isDigit(op.charAt(i)) || op.charAt(i) == '.')) {
                nb2.append(op.charAt(i));
                i++;
            }
            if (nb1.length() == 0 || nb2.length() == 0) {
                pw.println("Erreur : opération invalide !");
            } else {
                a = Integer.parseInt(nb1.toString());
                b = Integer.parseInt(nb2.toString());
                double res = 0;
                switch (operateur) {
                    case '+':
                        res = a + b;
                        break;
                    case '-':
                        res = a - b;
                        break;
                    case '*':
                        res = a * b;
                        break;
                    case '/':
                        res = a / b;
                }
            pw.println("Résultat = " + res);
            System.out.println("Résultat envoyé au client : " + res);   
            }

            br.close();
            pw.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Connexion fermée. Serveur arrêté.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
