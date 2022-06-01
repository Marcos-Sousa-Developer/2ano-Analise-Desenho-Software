package business;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	
	private CriarUser newuser0;
	private CriarUser newuser1;
	private CriarUser newuser2;
	private CriarUser newuser3;
	
	private CatalogUser catalogUser = new CatalogUser(); 
	
	private CatalogLeilao catalogLeilao = new CatalogLeilao(); 
	
	@Before
	//Testa criar um user
	public void testcriaUser() {
		
		//Criar novos users
		newuser0 = new CriarUser("Marcos","0@gmail.com","cr7goat");
		newuser1 = new CriarUser("Gabriel","1@gmail.com","cr8goat");
		newuser2 = new CriarUser("Rafael", "2@sapo.pt", "cr9goat");
		newuser3 = new CriarUser("Miguel", "3@sapo.pt", "cr10goat"); 
		
		//Adicionar um novo user ao catolg de Users
		catalogUser.addUser(newuser0); 
		catalogUser.addUser(newuser1);
		catalogUser.addUser(newuser2);
		catalogUser.addUser(newuser3);
		
	}
	
	@Test
	//Testa obter o nome do User
	public void testgetNome() {
		User user = catalogUser.getUser(0);
		assertEquals(user.getNome(), "Marcos");
	}
	
	@Test
	//Testa obter o email do User
	public void testgetEmail() {
		User user = catalogUser.getUser(0);
		assertEquals(user.getEmail(), "0@gmail.com");
	}
	
	@Test
	//Testa obter o email do User
	public void testgetID() {
		User user = catalogUser.getUser(1);
		assertEquals(user.getID(), 1);
	}
	
	@Test 
	//Testa criar um artigo, obter artigos criados, obter artigo criado e adicionar detalhes a um artigo
	 
	public void testArtigoUser() {
		
		User user = catalogUser.getUser(2); 
		
		String categoria = "Consola"; 
		String condicao = "Usado"; 
		String descricao = "Consola usada mas em bom estado";
		
		//criar artigo
		user.criaArtigo(categoria,condicao, descricao);
		
		//obter artigos criados
		assertEquals(user.getArtigosCriados().size(), 1); 
		
		//obter artigo
		assertEquals(user.getArtigo(0), user.getArtigosCriados().get(0)); 
		
		//adicionarDetalhes
		HashMap<String,String> detalhes = new HashMap<String,String>(); 
		
		detalhes.put("Marca", "Sony");
		
		user.adicionaDetalhes(0, "Marca", "Sony"); 
		
		assertEquals(user.getArtigo(0).getDetalhes(), detalhes);  		
	}
	
	@Test 
	public void testCatalogLeilao() {
		
		
		User vendedor = catalogUser.getUser(3); 
		User comprador = catalogUser.getUser(2); 
		
		vendedor.addCatalogLeilao(catalogLeilao);
		comprador.addCatalogLeilao(catalogLeilao);
		
		vendedor.addCatalogUser(catalogUser);
		
		vendedor.criaArtigo("Consola","Usado", "Consola usada mas em bom estado");
		
		vendedor.criaLeilao("Consola", 0);
		
		vendedor.getOutrosLeiloes();
		
		System.out.println(comprador.getOutrosLeiloes());
		
		vendedor.getMeusLeiloes();
		
		LocalDate data = LocalDate.parse("2023-01-08");
		
		vendedor.configLeilao(vendedor.getMeuLeilao(0), 100, data);
		
		vendedor.publicita(vendedor.getMeuLeilao(0));
		
		comprador.getOutroLeilao(0);
		
		//comprador.licitar(comprador.getOutroLeilao(0), 300);
		
		//vendedor.userPossivelAvaliar(comprador);
		
		//vendedor.getUsersPossivelAvaliar();
		
		//vendedor.formularioReputacao(comprador, 4);
		
		//comprador.alteraReputacao(4);
		
		//comprador.toString();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}