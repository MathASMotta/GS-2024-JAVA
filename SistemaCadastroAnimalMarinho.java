import models.AnimalMarinho;
//import models.TartarugaMarinha;
import models.Especie;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCadastroAnimalMarinho {
    private static ArrayList<AnimalMarinho> animais = new ArrayList<>();
    private static ArrayList<Especie> especies = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar animal marinho");
            System.out.println("2. Exibir animais cadastrados");
            System.out.println("3. Cadastrar espécie");
            System.out.println("4. Exibir espécies cadastradas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    cadastrarAnimal(scanner);
                    break;
                case 2:
                    exibirAnimais();
                    break;
                case 3:
                    cadastrarEspecie(scanner);
                    break;
                case 4:
                    exibirEspecies();
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
        System.out.print("Nome do animal: ");
        String nome = scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Unidade de tratamento: ");
        String unidadeTratamento = scanner.nextLine();
        System.out.print("Estado de saúde: ");
        String estadoSaude = scanner.nextLine();

        // Aqui, podemos adicionar lógica para verificar a espécie e criar a instância apropriada
        System.out.print("Espécie: "); //
        String especie = scanner.nextLine();

        AnimalMarinho animal;
        Especie encontrarEspecie = encontrarEspecie(especie);
        if (encontrarEspecie != null) {
            animal = new AnimalMarinho(nome, genero, especie, unidadeTratamento, estadoSaude);
        } else {
            System.out.println("Está espécie ainda não foi cadastrada!");
            System.out.println("Cadastre a espécie e, logo após, o cadastro do animal será finalizado!");
            cadastrarEspecie(scanner);
            animal = new AnimalMarinho(nome, genero, especie, unidadeTratamento, estadoSaude);
        }

        animais.add(animal);
        System.out.println("Animal cadastrado com sucesso!");
    }

    private static void exibirAnimais() {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
        } else {
            for (AnimalMarinho animal : animais) {
                animal.mostrarDetalhes();
                System.out.println("------------------------------");
            }
        }
    }

    private static void cadastrarEspecie(Scanner scanner) {
        System.out.println("Nome da Espécie: ");
        String nome = scanner.nextLine();
        System.out.println("Habitat: ");
        String habitat = scanner.nextLine();
        System.out.println("Ameaças: ");
        String ameacas = scanner.nextLine();
        System.out.println("Status de Preservação: ");
        String status = scanner.nextLine();

        Especie especie = new Especie(nome, habitat, ameacas, status);
        especies.add(especie);

        System.err.println("Espécie cadastrada com sucesso!");
    }

    private static void exibirEspecies() {
        if (especies.isEmpty()) {
            System.err.println("Nenhuma espécie cadastrada.");
        } else {
            for (Especie especie : especies) {
                especie.mostrarDetalhes();
                System.out.println("------------------------------");
            }
        }
    }

    private static Especie encontrarEspecie(String nome) {
        for (Especie especie : especies) {
            if (especie.getEspecie().equalsIgnoreCase(nome)) {
                return especie;
            }
        }
        return null;
    }

}
