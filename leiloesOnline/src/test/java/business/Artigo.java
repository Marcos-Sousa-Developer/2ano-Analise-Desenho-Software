package business;

import java.util.*;

public class Artigo {

    private String categoria;

    private String condicao;

    private List<String> detalhes;
    
    private String descricao;
    
    public Artigo(String categoria, String condicao, List<String> detalhes, String descricao) {
        this.categoria=categoria;
        this.condicao=condicao;
        this.detalhes=detalhes;
        this.descricao=descricao;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public  String getCondicao() {
        return this.condicao;
    }

    public List<String> getDetalhes() {
        return this.detalhes;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
}
