package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import metier.Compte;

public class BanqueImpl extends UnicastRemoteObject implements IBanque {
    
    private static final long serialVersionUID = 1L;
    
    // stocker les comptes 
    private Map<Integer, Compte> comptes;
    
    public BanqueImpl() throws RemoteException {
        super();
        comptes = new HashMap<>();
    }
    
    @Override
    public String creerCompte(Compte c) throws RemoteException {
        if (c == null) {
            return "Erreur : Compte null";
        }
        
        if (comptes.containsKey(c.getCode())) {
            return "Erreur : Un compte avec le code " + c.getCode() + " existe déjà";
        }
        
        comptes.put(c.getCode(), c);
        System.out.println("Compte créé : " + c);
        return "Compte créé avec succès : Code=" + c.getCode() + ", Solde=" + c.getSolde();
    }
    
    @Override
    public String getInfoCompte(int code) throws RemoteException {
        Compte compte = comptes.get(code);
        
        if (compte == null) {
            return "Erreur : Aucun compte trouvé avec le code " + code;
        }
        
        System.out.println("Consultation du compte : " + code);
        return compte.toString();
    }
}