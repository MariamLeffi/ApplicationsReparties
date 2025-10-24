package clientPackage;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import OpPackage.Operation;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Je suis un client pas encore connecté…");

            Socket socket = new Socket("127.0.0.1", 5050);
            System.out.println("Je suis un client connecté !");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            Scanner sc = new Scanner(System.in);
            double op1 = 0, op2 = 0;
            char operateur;

            while (true) {
                try {
                    System.out.print("Entrez le premier opérande : ");
                    op1 = sc.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Entrée invalide, veuillez saisir un nombre.");
                    sc.nextLine();
                }
            }

            while (true) {
                System.out.print("Entrez l’opérateur (+, -, *, /) : ");
                String input = sc.next();
                if (input.length() == 1 && "+-*/".contains(input)) {
                    operateur = input.charAt(0);
                    break;
                } else {
                    System.out.println("Opérateur invalide.");
                }
            }

            while (true) {
                try {
                    System.out.print("Entrez le deuxième opérande : ");
                    op2 = sc.nextDouble();
                    if (operateur == '/' && op2 == 0) {
                        System.out.println("Division par zéro interdite.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Entrée invalide, veuillez saisir un nombre.");
                    sc.nextLine();
                }
            }

            Operation operation = new Operation(op1, operateur, op2);
            oos.writeObject(operation);
            oos.flush();

            double resultat = ois.readDouble();
            System.out.println("Résultat reçu du serveur : " + resultat);
            
            sc.close();
            oos.close();
            ois.close();
            socket.close();
            System.out.println("Connexion fermée.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
