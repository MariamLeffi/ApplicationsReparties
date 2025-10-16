package clientPackage;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Entrez l’adresse IP du serveur : ");
            String ipServeur = sc.nextLine();

            Socket socket = new Socket(ipServeur, 5050);
            System.out.println("Connecté au serveur " + ipServeur);

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            while (true) {
                System.out.println("\n=== MENU CALCULATRICE ===");
                System.out.println("1. Addition (+)");
                System.out.println("2. Soustraction (-)");
                System.out.println("3. Multiplication (*)");
                System.out.println("4. Division (/)");
                System.out.println("0. Quitter");
                System.out.print("Votre choix : ");

                int choix = sc.nextInt();
                if (choix == 0) {
                    dos.writeUTF("exit");
                    break;
                }

                String op = switch (choix) {
                    case 1 -> "+";
                    case 2 -> "-";
                    case 3 -> "*";
                    case 4 -> "/";
                    default -> "?";
                };

                dos.writeUTF(op);

                System.out.print("Entrez le premier nombre : ");
                double a = sc.nextDouble();
                System.out.print("Entrez le deuxième nombre : ");
                double b = sc.nextDouble();

                dos.writeDouble(a);
                dos.writeDouble(b);
                dos.flush();

                String resultat = dis.readUTF();
                System.out.println(resultat);
            }

            sc.close();
            dis.close();
            dos.close();
            socket.close();
            System.out.println("Connexion fermée.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
