
package business;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

// cf. API em http://junit.org/junit4/javadoc/latest/
// comentar os imports desnecessarios
import org.junit.BeforeClass;
import org.junit.Before; 
import org.junit.Test;
import org.junit.AfterClass;

public class LeilaoTest {
	
	private CriarUser newuser0;
	private CriarUser newuser1;
	private CriarUser newuser2;
	private CriarUser newuser3;
	
	private CatalogUser catalogUser = new CatalogUser();
	
	@Before   // run before each test
	public void setup() {
		
		newuser0 = new CriarUser("Marcos","0@gmail.com","cr7goat");
		newuser1 = new CriarUser("Gabriel","1@gmail.com","cr8goat");
		newuser2 = new CriarUser("Rafael", "2@sapo.pt", "cr9goat");
		newuser3 = new CriarUser("Miguel", "3@sapo.pt", "cr10goat"); 
		
		catalogUser.addUser(newuser0);
		catalogUser.addUser(newuser1);
		catalogUser.addUser(newuser2);
		catalogUser.addUser(newuser3);
	}
	
	@Test
	public void obterTodosUsers() {
		assertEquals(catalogUser.getUsers().size(),4);
	}

	@Test
	public void getUser() { 
		
		assertEquals(catalogUser.getUser(0).getID(), 0);
		assertEquals(catalogUser.getUser(1).getID(), 1);
		assertEquals(catalogUser.getUser(2).getID(), 2);
		assertEquals(catalogUser.getUser(3).getID(), 3);
	}
	
}
