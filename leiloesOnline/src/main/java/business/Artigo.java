package business;

import java.util.*;

public class Artigo {

    private String categoria;

    private String condicao;

    private HashMap<String,String> detalhes = new HashMap<String,String>();
    
    private String descricao;
    
    public Artigo(String categoria, String condicao, String descricao) {
        this.categoria=categoria;
        this.condicao=condicao;
        this.descricao=descricao;
    }

    /** obtém a categoria do artigo
     * @return categoria do artigo
	*/
    public String getCategoria() {
        return this.categoria;
    }
    
    /** obtém a condicao do artigo
     * @return condicao do artigo
	*/
    public  String getCondicao() {
        return this.condicao;
    }

    /** adiciona detalhes ao artigo
     * 	@param nome - nome do detalhe
     * 	@param valor - valor do detalhe
	*/
    public void addDetalhes(String nome, String valor) {
    	detalhes.put(nome, valor);
    }
    
    /** obtém os detalhes do artigo
     * @return detalhes do artigo
	*/
    public HashMap<String,String> getDetalhes() {
    	return detalhes;
    }

    /** obtém a descrição do artigo
     * @return descrição do artigo
	*/
    public String getDescricao() {
        return this.descricao;
    }
    
}