package restaurante;

import java.util.*;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDeEspera listaDeEspera = new ListaDeEspera();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Incluir pessoa na fila de espera");
            System.out.println("2 - Remover pessoa da fila de espera");
            System.out.println("3 - Buscar pessoa na fila de espera");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {

                System.out.print("Digite o nome do cliente: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o número de assentos: ");
                int lugares = scanner.nextInt();
                scanner.nextLine(); 
                RequisicaoDeMesa novaRequisicao = new RequisicaoDeMesa(nome, lugares, LocalTime.now());
                listaDeEspera.adicionaNaLista(novaRequisicao);
                System.out.println("Cliente adicionado com sucesso!");

            } else if (opcao == 2) {

                System.out.print("Digite o nome do cliente: ");
                String nome = scanner.nextLine();
                listaDeEspera.removeDaListaPorNome(nome);
                System.out.println("Cliente removido com sucesso!");

            } else if (opcao == 3) {

                System.out.print("Digite o nome do cliente: ");
                String nome = scanner.nextLine();
                System.out.println(listaDeEspera.imprimeCliente(nome));

            } else if (opcao == 4) {

                System.out.println("Encerrando o programa.");
                break;

            } else {
                
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
