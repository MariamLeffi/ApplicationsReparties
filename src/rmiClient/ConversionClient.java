package rmiClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmiService.IConversion;

public class ConversionClient {
	public static void main(String[] args) {
		 try {
			 
			 Registry registry = LocateRegistry.getRegistry(1090);
		     IConversion stub = (IConversion) registry.lookup("lr");
			 double result = stub.convertirMontant(500);
			 System.out.println("Résultat de la conversion : " + result);
			 } catch (Exception e) {
			 e.printStackTrace();
			 }
			 }

		 }

