package models;

import java.util.ArrayList;

public class Animal extends Especie {
    private String nome;
    private String genero;
    private String unidadeTratamento;
    private ArrayList<Sensor> sensores;

    private static ArrayList<Animal> animais = new ArrayList<>();

    public Animal(String especie, String habitat, String ameacas, String status, 
                  String nome, String genero, String unidadeTratamento) {
        super(especie, habitat, ameacas, status);
        this.nome = nome;
        this.genero = genero;
        this.unidadeTratamento = unidadeTratamento;
        this.sensores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUnidadeTratamento() {
        return unidadeTratamento;
    }

    public void setUnidadeTratamento(String unidadeTratamento) {
        this.unidadeTratamento = unidadeTratamento;
    }

    public ArrayList<Sensor> getSensores() {
        return sensores;
    }

    public void adicionarSensor(Sensor sensor) {
        sensores.add(sensor);
    }

    public void exibirSensores() {
        if (sensores.isEmpty()) {
            System.out.println("Nenhum sensor cadastrado.");
        } else {
            for (Sensor sensor : sensores) {
                sensor.mostrarDetalhes();
                System.out.println("------------------------------");
            }
        }
    }

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("Nome: " + nome);
        System.out.println("Gênero: " + genero);
        System.out.println("Unidade de Tratamento: " + unidadeTratamento);
        exibirSensores();
    }

    public static void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }

    public static ArrayList<Animal> getAnimais() {
        return animais;
    }
}
