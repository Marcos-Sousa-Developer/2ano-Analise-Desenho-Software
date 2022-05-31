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

    public String getCategoria() {
        return this.categoria;
    }

    public  String getCondicao() {
        return this.condicao;
    }

    public void addDetalhes(String nome, String valor) {
    	detalhes.put(nome, valor);
    }
    
    public HashMap<String,String> getDetalhes() {
    	
    	return detalhes;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
}