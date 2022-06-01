package client;

import java.util.ArrayList;
import java.util.HashMap;

import business.*;

/**
 * Cliente simples
 *	
 * @author ...
 * @version ...
 * 
 */
public class SimpleClient {

	/**
	 * A simple interaction with the application services
	 * 
	 * @param args Command line parameters
	 */
	public static void main(String[] args) {
		
		User Comprador = new User("Gabriel", "g@sapo.pt", "tomilho");
        User Comprador2 = new User("Leitao", "l@sapo.pt", "lomilho");
        User Vendedor = new User("Rafael", "r@sapo.pt", "romilho");
        User Vendedor2 = new User("Micona", "m@sapo.pt", "momilho");
		
		// uso das classes do pacote business
		
		CatalogUser catalogUser = new CatalogUser();  
		
		CriarUser newuser0 = new CriarUser("Marcos","0@gmail.com","cr7goat");
		CriarUser newuser1 = new CriarUser("Gabriel","1@gmail.com","cr7goat");
		CriarUser newuser2 = new CriarUser("Gabrie2","2@gmail.com","cr7goat");
		
		catalogUser.addUser(newuser0);
		catalogUser.addUser(newuser1);
		catalogUser.addUser(newuser2);
		
		ArrayList<HashMap<Integer, String>> users = catalogUser.getUsers();
		
		System.out.println(catalogUser.getUser(0));
		
		System.out.println(users);

	}
}
