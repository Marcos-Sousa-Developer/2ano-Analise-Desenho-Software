
 package business;

import java.time.LocalDate;

import java.util.*;

public class Leilao {

	private int IDvendedor;
	private String titulo;
	private Artigo artigo;
	private LocalDate dataFim;
	private float montanteInicial; 
	private LocalDate dataUltimaLicitacao;
	private CatalogUser users;
	private float valorAtual; 
	private int IDComprador;
	
	//Estado inicial do leilão (INATIVO)
	private String estado = "INATIVO"; 
	
    
    public Leilao(int IDvendedor, String titulo, Artigo artigo, CatalogUser users) {
    	
        this.IDvendedor= IDvendedor;
        this.titulo=titulo;
        this.artigo=artigo;
        this.users = users;
    }
    
    public int getVendedor() {
        return this.IDvendedor;
    }
    
    //titulo Leilão
    public String getTitulo() {
        return this.titulo;
    }
    
    public LocalDate getDataFim() {
        return this.dataFim;
    }
    
    public float getMontanteInicial() {
        return this.montanteInicial;
    }
    
    
    public String getEstado() {
        return this.estado;
    }
    
    public Artigo getArtigo() {
        return this.artigo;
    }
    
    /** configura o leilao
	 * @param base - montante inicial do leilao
	 * @param dataFinal - data final do leilao
	*/
    public void configLeilao(float base, LocalDate dataFinal) {
    	this.montanteInicial=base;
    	this.dataFim=dataFinal;
    }
    
    public void publicita() {
    	this.estado = "ATIVO";
    }
    
    public void arquivaLeilao() { 
    	this.estado="ARQUIVADO";
    }
    
    /** termina o Leilao
	 * @param data - data atual
	*/
    public void terminaLeilao(LocalDate data) { 
    	
    	if (data.isAfter(this.dataFim)) {
    		this.estado="encerrado";
    		
    		this.users.getUser(this.IDComprador).userPossivelAvaliar(this.users.getUser(this.IDvendedor));
    		
    		this.users.getUser(this.IDvendedor).userPossivelAvaliar(this.users.getUser(this.IDComprador));
    	}
    }
    
    /** recebe uma Licitacao
	 * @param licitacao - licitacao do user
	*/
    public void recebeLicitacao(Licitacao licitacao) {
    	
    	if (licitacao.getMontante() > this.valorAtual) {
    		
    		this.valorAtual = licitacao.getMontante();
    		
    		dataUltimaLicitacao = licitacao.getData();
    		
    		this.IDComprador = licitacao.getComprador();
    		
    	}
    	
    	
    }
      
}