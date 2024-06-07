package models;

import java.util.ArrayList;

public class Especie {
    private String especie;
    private String habitat;
    private String ameacas;
    private String status;

    private static ArrayList<Especie> especies = new ArrayList<>();

    public Especie(String especie, String habitat, String ameacas, String status) {
        this.especie = especie;
        this.habitat = habitat;
        this.ameacas = ameacas;
        this.status = status;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getAmeacas() {
        return ameacas;
    }

    public void setAmeacas(String ameacas) {
        this.ameacas = ameacas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void mostrarDetalhes() {
        System.out.println("Espécie: " + especie);
        System.out.println("Habitat: " + habitat);
        System.out.println("Ameaças: " + ameacas);
        System.out.println("Status de Preservação: " + status);
    }

    public static void adicionarEspecie(Especie especie) {
        especies.add(especie);
    }

    public static ArrayList<Especie> getEspecies() {
        return especies;
    }

    public static Especie encontrarEspecie(String nome) {
        for (Especie especie : especies) {
            if (especie.getEspecie().equalsIgnoreCase(nome)) {
                return especie;
            }
        }
        return null;
    }
}
