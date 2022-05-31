package business;

import java.time.LocalDate;
import java.util.*;

public class User {

    private String nome;

    private String email;

    private String password;

    private ArrayList<Leilao> meusLeiloes;

    private float reputacao;
    
    public User(String nome, String email, String password) {
        this.nome=nome;
        this.email=email;
        this.password=password;
        this.meusLeiloes=new ArrayList<Leilao>();
        this.reputacao=5;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
    
    public  ArrayList<Leilao> getMeusLeiloes() {
        return this.meusLeiloes;
    }
    
    public Leilao criaLeilao(User vendedor, String titulo, Artigo artigo) { 
    	Leilao L = new Leilao(vendedor, titulo, artigo);
    	this.meusLeiloes.add(L);
    	return L;
    }
    
    public void configLeilao(Leilao L, float base, LocalDate dataFinal) {
    	L.alteraConfig(base, dataFinal);
    }
    
    public void publicita(Leilao L) {
    	L.alteraEstado("publicado");
    }
    
    public String licitar(Licitacao licitacao) {
    	Leilao L = licitacao.getLeilao();
    	if (L.getEstado()=="publicado") {
        	return L.recebeLicitacao(licitacao);
    	}
    	else {
    		return "Licitação não aprovada - leilão não se encontra disponível";
    	}
    }
}