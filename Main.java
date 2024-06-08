import models.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar animal");
            System.out.println("2. Cadastrar espécie");
            System.out.println("3. Adicionar sensor a um animal");
            System.out.println("4. Exibir animais cadastrados");
            System.out.println("5. Exibir espécies cadastradas");
            System.out.println("6. Gerar relatório");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next(); // Consumir entrada inválida
                System.out.print("Escolha uma opção: ");
            }
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha
            
            switch (opcao) {
                case 1:
                    cadastrarAnimal(scanner);
                    break;
                case 2:
                    cadastrarEspecie(scanner);
                    break;
                case 3:
                    adicionarSensorAnimal(scanner);
                    break;
                case 4:
                    exibirAnimais();
                    break;
                case 5:
                    exibirEspecies();
                    break;
                case 6:
                    gerarRelatorio();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void cadastrarAnimal(Scanner scanner) {
        String nome = obterEntradaValida(scanner, "Nome do animal: ");
        String genero = obterEntradaValida(scanner, "Gênero: ");
        String unidadeTratamento = obterEntradaValida(scanner, "Unidade de tratamento: ");
        String especieNome = obterEntradaValida(scanner, "Nome da Espécie: ");

        Especie especie = Especie.encontrarEspecie(especieNome);
        if (especie == null) {
            System.out.println("Esta espécie ainda não foi cadastrada!");
            System.out.println("Cadastre a espécie primeiro.");
            cadastrarEspecie(scanner, especieNome);
            especie = Especie.encontrarEspecie(especieNome);
        }

        Animal animal = new Animal(especie.getEspecie(), especie.getHabitat(), especie.getAmeacas(), especie.getStatus(), 
                                   nome, genero, unidadeTratamento);

        Animal.adicionarAnimal(animal);
        System.out.println("Animal cadastrado com sucesso!");
    }

    private static void exibirAnimais() {
        if (Animal.getAnimais().isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
        } else {
            for (Animal animal : Animal.getAnimais()) { 
                System.out.println("---- Animal ----");
                animal.mostrarDetalhes();
                System.out.println("------------------------------");
            }
        }
    }

    private static void cadastrarEspecie(Scanner scanner) {
        String nome = obterEntradaValida(scanner, "Nome da Espécie: ");
        cadastrarEspecie(scanner, nome);
    }

    private static void cadastrarEspecie(Scanner scanner, String nomeEspecie) {
        System.out.println("Cadastrando espécie: " + nomeEspecie);
        String habitat = obterEntradaValida(scanner, "Habitat: ");
        String ameacas = obterEntradaValida(scanner, "Ameaças: ");
        String status = obterEntradaValida(scanner, "Status de Preservação: ");

        Especie especie = new Especie(nomeEspecie, habitat, ameacas, status);
        Especie.adicionarEspecie(especie);

        System.out.println("Espécie cadastrada com sucesso!");
    }

    private static void exibirEspecies() {
        if (Especie.getEspecies().isEmpty()) {
            System.out.println("Nenhuma espécie cadastrada.");
        } else {
            for (Especie especie : Especie.getEspecies()) {
                System.out.println("---- Espécie ----");
                especie.mostrarDetalhes();
                System.out.println("------------------------------");
            }
        }
    }

    private static void adicionarSensorAnimal(Scanner scanner) {
        String nomeAnimal = obterEntradaValida(scanner, "Nome do animal ao qual deseja adicionar um sensor: ");

        Animal animal = null;
        for (Animal a : Animal.getAnimais()) {
            if (a.getNome().equalsIgnoreCase(nomeAnimal)) {
                animal = a;
                break;
            }
        }

        if (animal == null) {
            System.out.println("Animal não encontrado.");
            return;
        }

        String identificador;
        do {
            identificador = obterEntradaValida(scanner, "Identificador do sensor (até 4 caracteres): ");
            if (identificador.length() > 4) {
                System.out.println("Identificador muito longo. Deve ter até 4 caracteres.");
            }
        } while (identificador.length() > 4);

        String tipo = obterEntradaValida(scanner, "Tipo de sensor: ");
        String status = obterEntradaValida(scanner, "Status do sensor: ");

        Sensor sensor = new Sensor(tipo, status, identificador);
        animal.adicionarSensor(sensor);
        System.out.println("Sensor adicionado com sucesso!");
    }

    private static void gerarRelatorio() {
        if (Especie.getEspecies().isEmpty()) {
            System.out.println("Nenhuma espécie cadastrada para fazer relatório.");
            return;
        }

        Map<String, Integer> especieCount = new HashMap<>();
        Map<String, String> especieStatus = new HashMap<>();

        for (Animal animal : Animal.getAnimais()) {
            String especieNome = animal.getEspecie();
            especieCount.put(especieNome, especieCount.getOrDefault(especieNome, 0) + 1);
            for (Sensor sensor : animal.getSensores()) {
                especieStatus.put(animal.getNome(), sensor.getStatus());
            }
        }

        for (Especie especie : Especie.getEspecies()) {
            String especieNome = especie.getEspecie();
            int count = especieCount.getOrDefault(especieNome, 0);
            System.out.println("Espécie: " + especieNome);
            System.out.println("Quantidade de animais: " + count);
            System.out.println("Status dos animais:");
            for (Animal animal : Animal.getAnimais()) {
                if (animal.getEspecie().equals(especieNome)) {
                    System.out.println("  Animal: " + animal.getNome() + " - Status: " + especieStatus.get(animal.getNome()));
                }
            }
            System.out.println("------------------------------");
        }
    }

    private static String obterEntradaValida(Scanner scanner, String mensagem) {
        String entrada;
        boolean valida;
        do {
            System.out.print(mensagem);
            entrada = scanner.nextLine();
            valida = entrada.matches("[a-zA-Z ]+");
            if (!valida) {
                System.out.println("Entrada inválida. Por favor, insira apenas letras e espaços.");
            }
        } while (!valida);
        return entrada;
    }
}
