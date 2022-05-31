package business;

import java.time.LocalDate;

import java.util.*;

public class Licitacao {

    private User comprador;

    private Leilao leilao;

    private float montante;
    
    private LocalDate data;

    public Licitacao(User comprador, Leilao leilao, float montante, LocalDate data) {
        this.comprador=comprador;
        this.leilao=leilao;
        this.montante=montante;
        this.data=data;
    }

    public User getComprador() {
        return this.comprador;
    }

    public Leilao getLeilao() {
        return this.leilao;
    }

    public float getMontante() {
        return this.montante;
    }
    
    public LocalDate getData() {
        return this.data;
    }
    
}
