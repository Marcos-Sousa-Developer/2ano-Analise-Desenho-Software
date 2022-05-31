package client;

import java.time.LocalDate;

import java.util.*;

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
		
		// uso das classes do pacote business

		User Comprador = new User("Gabriel", "g@sapo.pt", "tomilho");
		User Comprador2 = new User("Leitao", "l@sapo.pt", "lomilho");
		User Vendedor = new User("Rafael", "r@sapo.pt", "romilho");
		User Vendedor2 = new User("Micona", "m@sapo.pt", "momilho");

		
		Artigo Armario = new Artigo("Mobilia", "má", Arrays.asList("bmw", "azul", "madeirada"), "Guarda roupa");
		
		LocalDate dAtual = LocalDate.parse("2020-01-08");
		LocalDate dAtual2 = LocalDate.parse("2020-03-08");
		LocalDate dFinal = LocalDate.parse("2021-01-08");
		LocalDate dFinal2 = LocalDate.parse("2021-01-07");
		LocalDate dFinal3 = LocalDate.parse("2027-01-07");

		
		Leilao Leilao1 = Vendedor.criaLeilao(Vendedor, "Leilona", Armario);
		Vendedor.configLeilao(Leilao1, 500, dFinal);
		System.out.println(Leilao1.getEstado());
		Vendedor.publicita(Leilao1);
		System.out.println(Leilao1.getEstado());
		System.out.println(Vendedor.getMeusLeiloes());

		
		Licitacao Licitacao1 = new Licitacao(Comprador, Leilao1, 550, dAtual);
		Licitacao Licitacao2 = new Licitacao(Comprador2, Leilao1, 950, dAtual2);
		
		
		String Resultado = Comprador.licitar(Licitacao1);
		System.out.println(Resultado);
		System.out.println(Leilao1.getLicitacaoAtual().getMontante());
		
		
		String Resultado2 = Comprador.licitar(Licitacao2);
		System.out.println(Resultado2);
		System.out.println(Leilao1.getLicitacaoAtual().getMontante());
		
		Leilao1.terminaLeilao(dFinal2);
		System.out.println(Leilao1.getEstado());
		
		Leilao1.terminaLeilao(dFinal3);
		System.out.println(Leilao1.getEstado());

	}
}
