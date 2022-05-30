package business;

import java.time.LocalDate;

import java.util.*;

public class Leilao {

    private User vendedor;

    private String titulo;

    private LocalDate dataFim;
    
    private float montanteInicial;
    
    private Licitacao licitacaoAtual; //REVER 9999999999999999999999999999999

    private String estado; //REVER 9999999999999999999999999999999 definir estado inicial, verificar estado ao receber licitacao, alterar estado
    
    private Artigo artigo;
    
    public Leilao(User vendedor, String titulo, LocalDate dataFim, float montanteInicial, String estado, Artigo artigo) {
        this.vendedor=vendedor;
        this.titulo=titulo;
        this.dataFim=dataFim;
        this.montanteInicial=montanteInicial;
        this.licitacaoAtual=null;
        this.estado=estado;
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
    
    public String recebeLicitacao(Licitacao licitacao) {
    	float montanteLicitacao = licitacao.getMontante();
    	LocalDate dataLicitacao = licitacao.getData();
    	
    	if (this.licitacaoAtual == null) {
    		if (montanteLicitacao > this.montanteInicial) {
    			if (dataLicitacao.isBefore(this.dataFim) || dataLicitacao.isEqual(this.dataFim)) { //REVER 0000000000000000000000000000000000
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
    			if (dataLicitacao.isBefore(this.dataFim) || dataLicitacao.isEqual(this.dataFim)) { //REVER 0000000000000000000000000000000000
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
