package business;

import java.time.LocalDate;

import java.util.*;

public class Leilao {

    private User vendedor;

    private String titulo;

    private LocalDate dataFim;
    
    private float montanteInicial;
    
    private Licitacao licitacaoAtual; 

    private String estado; //REVER 9999999999999999999999999999999 definir estado inicial, verificar estado ao receber licitacao, alterar estado
    
    private Artigo artigo;
    
    public Leilao(User vendedor, String titulo, Artigo artigo) {
        this.vendedor=vendedor;
        this.titulo=titulo;
        this.licitacaoAtual=null;
        this.estado="criado";
        this.artigo=artigo;
    }

    public User getVendedor() {
        return this.vendedor;
    }
    
    public String getTitulo() {
        return this.titulo;
    }

    public LocalDate getDataFim() {
        return this.dataFim;
    }

    public float getMontanteInicial() {
        return this.montanteInicial;
    }
    
    public Licitacao getLicitacaoAtual() {
        return this.licitacaoAtual;
    }
    
    public String getEstado() {
        return this.estado;
    }

    public Artigo getArtigo() {
        return this.artigo;
    }
    
    public void alteraConfig(float base, LocalDate dataFinal) {
    	this.montanteInicial=base;
    	this.dataFim=dataFinal;
    }
    
    public void alteraEstado(String estado) { 
    	this.estado=estado;
    }
    
    public void terminaLeilao() { 
    	if (this.meusLeiloes.contains(L)) {
        	L.alteraEstado("encerrado");
    	}
    	else {
    		System.out.println("N�o � poss�vel encerrar este leil�o");
    	}
    }
    
    public String recebeLicitacao(Licitacao licitacao) {
    	float montanteLicitacao = licitacao.getMontante();
    	LocalDate dataLicitacao = licitacao.getData();
    	
    	if (this.licitacaoAtual == null) {
    		if (montanteLicitacao > this.montanteInicial) {
    			if (dataLicitacao.isBefore(this.dataFim) || dataLicitacao.isEqual(this.dataFim)) { 
    				this.licitacaoAtual = licitacao;
    				return "Licita��o aprovada";
    			} 
    			else {
    				return "Licita��o n�o aprovada - passou da data limite";
    			}
    		}
    		else {
				return "Licita��o n�o aprovada - montante inferior ao atual";
			}	
    	}
    	else {
    		if (montanteLicitacao > this.licitacaoAtual.getMontante()) {
    			if (dataLicitacao.isBefore(this.dataFim) || dataLicitacao.isEqual(this.dataFim)) { 
    				this.licitacaoAtual = licitacao;
    				return "Licita��o aprovada";
    			} 
    			else {
    				return "Licita��o n�o aprovada - passou da data limite";
    			}
    		}
    		else {
				return "Licita��o n�o aprovada - montante inferior ao atual";
			}	
		}
    }
}
