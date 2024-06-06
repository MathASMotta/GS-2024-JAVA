import models.Animal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        tituloMenu();
        menuPrincipal();
    }
    
    private static void tituloMenu(){
        System.out.println("=====================");
        System.out.println("-------Projeto-------");
        System.out.println("=====================");
    }

    private static void menuPrincipal() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Menu");
            System.out.println("1 - Cadastrar Animal");
            System.out.println("0 - Sair do Programa");
            System.out.println("Escolha uma opção: ");
            int opMenu = sc.nextInt();
            sc.nextLine();

            switch (opMenu) {
                case 1:
                    
                    break;
                
                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    break;
            }
        }
    }
}