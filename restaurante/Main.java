package restaurante;

import java.util.*;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDeEspera listaDeEspera = new ListaDeEspera();

        while (true) {
            System.out.println("\nEscolha uma opcao:");
            System.out.println("1 - Incluir pessoa na fila de espera");
            System.out.println("2 - Remover pessoa da fila de espera");
            System.out.println("3 - Buscar pessoa na fila de espera");
            System.out.println("4 - Mostrar toda a lista de espera");
            System.out.println("5 - Sair");

            System.out.print("Opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {

                System.out.print("\nDigite o nome do cliente: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o número de assentos: ");
                int lugares = scanner.nextInt();
                scanner.nextLine(); 
                RequisicaoDeMesa novaRequisicao = new RequisicaoDeMesa(nome, lugares, LocalTime.now());
                listaDeEspera.adicionarNaLista(novaRequisicao);
                System.out.println("Cliente adicionado com sucesso!");

            } else if (opcao == 2) {

                System.out.print("\nDigite o nome do cliente: ");
                String nome = scanner.nextLine();
                listaDeEspera.removerDaListaPorNome(nome);
                System.out.println("Cliente removido com sucesso!");

            } else if (opcao == 3) {

                System.out.print("\nDigite o nome do cliente: ");
                String nome = scanner.nextLine();
                System.out.println(listaDeEspera.imprimirCliente(nome));

            } else if (opcao == 4) {

                System.out.println("\nLista de espera: ");
                System.out.println(listaDeEspera.imprimirLista());

            } else if (opcao == 5){
                
                System.out.println("\nEncerrando programa.");
                break;
                
            } else {
                
                System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
