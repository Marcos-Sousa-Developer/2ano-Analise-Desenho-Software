package business;

import java.util.*;

public class User {

    private String nome;

    private String email;

    private String password;


    public User(String nome, String email, String password) {
        this.nome=nome;
        this.email=email;
        this.password=password;
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
    
    public String licitar(Licitacao licitacao) {
    	Leilao L = licitacao.getLeilao();
    	return L.recebeLicitacao(licitacao);
    }
}