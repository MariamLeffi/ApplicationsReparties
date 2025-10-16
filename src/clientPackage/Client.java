package clientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import PackageCommun.Operation;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Je suis un client pas encore connecté…");

            Socket socket = new Socket("127.0.0.1", 5050);
            System.out.println("Je suis un client connecté !");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            Scanner sc = new Scanner(System.in);
            System.out.print("Entrez le premier opérande : ");
            double op1 = sc.nextDouble();

            System.out.print("Entrez l’opérateur (+, -, *, /) : ");
            char operateur = sc.next().charAt(0);

            System.out.print("Entrez le deuxième opérande : ");
            double op2 = sc.nextDouble();

            // création de l’objet à envoyer
            Operation operation = new Operation(op1, operateur, op2);

            // envoi de l’objet
            oos.writeObject(operation);
            oos.flush();

            // réception du résultat
            double resultat = ois.readDouble();
            System.out.println("Résultat reçu du serveur : " + resultat);
            

         // fermeture 
            sc.close();
            ois.close();
            oos.close();
            socket.close();
            System.out.println("Connexion fermée.");

        } catch (IOException e) {}
           
        
    }
}
