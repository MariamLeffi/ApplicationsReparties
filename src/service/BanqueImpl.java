package service;

import java.util.ArrayList;
import java.util.List;
import CorbaBanque.Compte;
import CorbaBanque.IBanqueRemotePOA;

public class BanqueImpl extends IBanqueRemotePOA {

    private List<Compte> comptes;
    public BanqueImpl() {
        comptes = new ArrayList<>();
    }
    @Override
    public void creerCompte(Compte cpte) {
        comptes.add(cpte);
        System.out.println(" Compte créé : code = " + cpte.code + ", solde = " + cpte.solde);
    }
    @Override
    public Compte[] getComptes() {
        System.out.println("Liste des comptes demandée (" + comptes.size() + " comptes)");
        Compte[] tab = new Compte[comptes.size()];
        return comptes.toArray(tab);
    }
    @Override
    public double conversion(float mt) {
        double taux = 3.2; // Exemple : 1 € = 3.2 DT
        double res = mt * taux;
        System.out.println(" Conversion de " + mt + " EUR = " + res + " DT");
        return res;
    }
	@Override
	public void verser(float mt, int code) {
		for (Compte c : comptes) {
            if (c.code == code) {
                c.solde += mt;
                System.out.println(" Versement de " + mt + " effectué sur le compte " + code);
                return;
            }
        }
        System.out.println(" Compte " + code + " introuvable !");
    }
	@Override
	public void retirer(float mt, int code) {
		for (Compte c : comptes) {
            if (c.code == code) {
                if (c.solde >= mt) {
                    c.solde -= mt;
                    System.out.println("Retrait de " + mt + " effectué sur le compte " + code);
                } else {
                    System.out.println("Solde insuffisant pour le compte " + code);
                }
                return;
            }
        }
        System.out.println("Compte " + code + " introuvable !");
    }
	@Override
	public Compte getCompte(int code) {
		for (Compte c : comptes) {
            if (c.code == code) {
                System.out.println("Compte trouvé : code = " + c.code + ", solde = " + c.solde);
                return c;
            }
        }
        System.out.println("Aucun compte trouvé avec le code " + code);
        return null;
	}
}
