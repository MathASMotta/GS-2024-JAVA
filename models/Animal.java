package models;

import java.util.ArrayList;

public class Animal {
    private String nome;
    private Gen genero;
    private String espécie; 
    private String unidade;


    public enum Gen {
        Macho,
        Femea
    }
}
