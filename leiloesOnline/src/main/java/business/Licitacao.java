package business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.*;

public class Licitacao {

    private int IDcomprador;

    private float montante;
    
    private LocalDate data;

    public Licitacao(int IDcomprador, float montante) {
        this.IDcomprador= IDcomprador;
        this.montante=montante;
        this.data=data;
    }

    public int getComprador() {
        return this.IDcomprador;
    }

    public float getMontante() {
        return this.montante;
    }
    
    public LocalDate getData() {
    	
    	LocalDate date = LocalDate.now();
    			
    	this.data = date;
    	
        return this.data;
    }
    
}
