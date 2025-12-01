package rmiClient;

import rmiService.IBanque;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Scanner;

public class BanqueClient {
    public static void main(String[] args) {
        try {
            // 1. Lookup via JNDI
            Context ctx = new InitialContext();
            IBanque stub = (IBanque) ctx.lookup("BanqueService");

            System.out.println("Connecté au service BanqueService.");

            Scanner sc = new Scanner(System.in);

            while(true) {
                System.out.println("1 - Créer un compte");
                System.out.println("2 - Consulter un compte");
                System.out.println("0 - Quitter");
                System.out.print("Choix: ");

                int ch = Integer.parseInt(sc.nextLine());

                if(ch == 1) {
                    System.out.print("Code: ");
                    int code = Integer.parseInt(sc.nextLine());

                    System.out.print("Solde initial: ");
                    double solde = Double.parseDouble(sc.nextLine());

                    metier.Compte c = new metier.Compte(code, solde);

                    System.out.println(stub.creerCompte(c));
                }
                else if(ch == 2) {
                    System.out.print("Code du compte: ");
                    int code = Integer.parseInt(sc.nextLine());

                    System.out.println(stub.getInfoCompte(code));
                }
                else if(ch == 0) {
                    System.out.println("Au revoir.");
                    break;
                }
            }

        } catch(Exception e) {
            System.out.println("Erreur client : " + e.getMessage());
        }
    }
}
