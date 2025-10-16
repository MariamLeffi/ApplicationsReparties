package serverPackage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import PackageCommun.Operation;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5050);
            System.out.println("Serveur prêt sur le port 5050. En attente d’un client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Un client est connecté !");

            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());

            Object obj = ois.readObject();

            if (obj instanceof Operation) {
                Operation op = (Operation) obj;

                double resultat = 0;
                switch (op.getOperateur()) {
                    case '+': resultat = op.getOp1() + op.getOp2(); break;
                    case '-': resultat = op.getOp1() - op.getOp2(); break;
                    case '*': resultat = op.getOp1() * op.getOp2(); break;
                    case '/':
                        if (op.getOp2() == 0) {
                            System.out.println("Erreur : division par zéro !");
                        } else {
                            resultat = op.getOp1() / op.getOp2();
                        }
                        break;
                    default:
                        System.out.println("Opérateur invalide !");
                }

                System.out.println("Calcul reçu : " + op.getOp1() + " " + op.getOperateur() + " " + op.getOp2() + " = " + resultat);

                // renvoyer le résultat
                oos.writeDouble(resultat);
                oos.flush();
            }
            
         // fermeture 
            ois.close();
            oos.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Connexion fermée. Serveur arrêté.");
        } catch (IOException e) {}
        catch (ClassNotFoundException e) {}
    }
}
