
package business;

import static org.junit.Assert.*;

import java.time.LocalDate;
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
	
	private Leilao l1;
	private Artigo ps4;
	private LocalDate data;
	private LocalDate dataFinal1;
	private LocalDate dataFinal2;
	private Licitacao licitacao1;
	private Licitacao licitacao2;
	private Licitacao licitacao3;
	
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
		
		ps4 = new Artigo("consola","nova","Playstation 4");
		
		l1 = new Leilao(0, "ps4", ps4, catalogUser);
		
		data = LocalDate.parse("2023-01-08");
		dataFinal1 = LocalDate.parse("2022-01-08");
		dataFinal2 = LocalDate.parse("2023-01-10");
		
		licitacao1 = new Licitacao(1,100);
		licitacao2 = new Licitacao(2,350);
		licitacao3 = new Licitacao(3,450);
		
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
	
	@Test
	public void leilao() { 
		
		System.out.println(l1.getVendedor());
		System.out.println(l1.getTitulo());
		System.out.println(l1.getMontanteInicial());
		System.out.println(l1.getEstado());
		System.out.println(l1.getDataFim());
		System.out.println(l1.getArtigo());
		
		
		
		l1.configLeilao(300, data);
		
		l1.publicita();
		
		System.out.println(l1.getMontanteInicial());
		System.out.println(l1.getEstado());
		System.out.println(l1.getDataFim());
		
		l1.recebeLicitacao(licitacao1);
		
		System.out.println(l1.getValorAtual());
		
		l1.recebeLicitacao(licitacao2);
		
		System.out.println(l1.getValorAtual());
		
		l1.recebeLicitacao(licitacao3);
		
		System.out.println(l1.getValorAtual());
		
		l1.terminaLeilao(dataFinal1);
		
		System.out.println(l1.getEstado());
		
		l1.terminaLeilao(dataFinal2);
		
		System.out.println(l1.getEstado());
		
		l1.arquivaLeilao();
		
		System.out.println(l1.getEstado());
		
	
	}
}
