package business;

import java.time.LocalDate;
import java.util.*;

public class User {

    private String nome;

    private String email;

    private String password;

    private ArrayList<Leilao> meusLeiloes;
    
    private ArrayList<User> reputacoesDisponiveis;

    private float reputacao;
    
    public User(String nome, String email, String password) {
        this.nome=nome;
        this.email=email;
        this.password=password;
        this.meusLeiloes=new ArrayList<Leilao>();
        this.reputacoesDisponiveis=new ArrayList<User>();
        this.reputacao=5;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
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
    
    public void formularioReputacao(User user, float avaliacao) {
    	if (this.reputacoesDisponiveis.contains(user)) {
        	user.alteraReputacao(avaliacao);
        	this.reputacoesDisponiveis.remove(user);
    	}
    }
    
    public void alteraReputacao(float reputacaoNova) {
    	this.reputacao=(this.reputacao + reputacaoNova)/2;
    }
    
    public void adicionaReputacoesDisponiveis(User user) {
    	this.reputacoesDisponiveis.add(user);
    }
    
    
    
    
    
    
}