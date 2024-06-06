import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCadastroAnimalMarinho {
    private static ArrayList<AnimalMarinho> animais = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar animal marinho");
            System.out.println("2. Exibir animais cadastrados");
            System.out.println("3. Sair");
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
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
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
        System.out.print("Espécie: ");
        String especie = scanner.nextLine();

        AnimalMarinho animal;
        if (especie.equalsIgnoreCase("Tartaruga Marinha")) {
            animal = new TartarugaMarinha(nome, genero, unidadeTratamento, estadoSaude);
        } else {
            // Adicionar outras espécies conforme necessário
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
}
