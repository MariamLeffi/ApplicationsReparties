package corbaClient;

import javax.naming.InitialContext;
import CorbaBanque.Compte;
import CorbaBanque.IBanqueRemote;
import CorbaBanque.IBanqueRemoteHelper;

public class BanqueClient {
	
		public static void main(String[] args) {
		try {
				InitialContext ctx = new InitialContext();
				Object ref = ctx.lookup("BK");
				IBanqueRemote stub=IBanqueRemoteHelper.narrow((org.omg.CORBA.Object)ref);
				System.out.println(stub.conversion(600));
		 	}catch (Exception e) { e.printStackTrace(); }
		 }
} 