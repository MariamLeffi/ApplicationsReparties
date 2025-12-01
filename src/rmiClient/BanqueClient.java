package rmiClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import rmiService.IBanque;
import metier.Compte;

public class BanqueClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IBanque stub = (IBanque) registry.lookup("BanqueService");

            Scanner sc = new Scanner(System.in);

            System.out.println("Connecté au service BanqueService.");

            while (true) {

                System.out.println("1 - Créer un compte");
                System.out.println("2 - Consulter un compte");
                System.out.println("0 - Quitter");
                System.out.print("Choix: ");

                String choix = sc.nextLine();   // TOUJOURS nextLine()

                switch (choix) {
                    case "1":
                        System.out.print("Code (int): ");
                        int code = Integer.parseInt(sc.nextLine());

                        System.out.print("Solde initial (double): ");
                        double solde = Double.parseDouble(sc.nextLine());

                        Compte c = new Compte(code, solde);
                        String res = stub.creerCompte(c);
                        System.out.println(res);
                        break;

                    case "2":
                        System.out.print("Code (int): ");
                        int code2 = Integer.parseInt(sc.nextLine());

                        String info = stub.getInfoCompte(code2);
                        System.out.println(info);
                        break;

                    case "0":
                        System.out.println("Au revoir !");
                        return;

                    default:
                        System.out.println("Choix invalide !");
                }

                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Erreur client : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
