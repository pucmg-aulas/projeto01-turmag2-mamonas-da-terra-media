package restaurante;

import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ArrayList<RequisicaoDeMesa> requisicoes = new ArrayList<>(); 
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mesa> mesas = new ArrayList<Mesa>(); 
        mesas.add(new Mesa(4, true));  
        mesas.add(new Mesa(6, true));  
        mesas.add(new Mesa(8, true)); 

        ListaDeEspera listaDeEspera = new ListaDeEspera(mesas);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Incluir pessoa na fila de espera por mesa");
            System.out.println("2 - Remover pessoa da fila de espera");
            System.out.println("3 - Buscar pessoa na fila de espera");
            System.out.println("4 - Mostrar toda a lista de espera");
            System.out.println("5 - Mostrar disponibilidade das mesas");
            System.out.println("6 - Imprimir Menu");
            System.out.println("7 - Fazer Pedido ");
            System.out.println("8 - Pedir a conta ");
            System.out.println("9 - Sair");


            System.out.print("Opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {

                System.out.print("\nDigite o nome do cliente: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o número de lugares: ");
                int lugares = scanner.nextInt();
                scanner.nextLine();

                Mesa mesaDisponivel = mesas.stream()
                    .filter(mesa -> mesa.isDisponivel() && mesa.getNumeroAssentos() >= lugares)
                    .sorted(Comparator.comparingInt(Mesa::getNumeroAssentos))
                    .findFirst()
                    .orElse(null);

                if (mesaDisponivel != null) {
                    RequisicaoDeMesa requisicao = new RequisicaoDeMesa(nome, lugares, LocalTime.now(), mesaDisponivel);
                    listaDeEspera.adicionarNaLista(requisicao);
                    requisicoes.add(requisicao); 
                    System.out.println("Cliente adicionado com sucesso!");
                } else {
                    System.out.println("Nenhuma mesa disponível no momento.");
                }

            } else if (opcao == 2) {
                System.out.print("\nDigite o nome do cliente a ser removido: ");
                String nome = scanner.nextLine();
                listaDeEspera.removerDaListaPorNome(nome);
                requisicoes.removeIf(rm -> rm.getNomeCliente().equals(nome)); // Remove também da lista de requisicoes
                System.out.println("Cliente removido com sucesso!");

            } else if (opcao == 3) {

                System.out.print("\nDigite o nome do cliente para busca: ");
                String nome = scanner.nextLine();
                System.out.println(listaDeEspera.imprimirCliente(nome));

            } else if (opcao == 4) {

                System.out.println("\nLista de espera atual:");
                System.out.println(listaDeEspera.imprimirLista());

            } else if (opcao == 5) {

                System.out.println("\nDisponibilidade das Mesas:");
                mesas.forEach(mesa -> System.out.println("Mesa " + mesa.getNumeroAssentos() + " lugares: " + (mesa.isDisponivel() ? "Disponível" : "Ocupada")));

            } else if (opcao == 6) {

                System.out.println(menu.imprimirMenu());

            } else if (opcao == 7) {

                System.out.println("Escolha a Mesa: ");
                requisicoes.forEach(requisicao -> System.out.println("Mesa: " + requisicao.getNomeCliente()));
                String nome = scanner.nextLine();
                for (RequisicaoDeMesa rm : requisicoes) {
                    if (rm.getNomeCliente().equals(nome)) {
                        rm.fazerPedido();
                    }
                }

            } else if (opcao == 8) {

                System.out.println("Escolha a Mesa: ");
                requisicoes.forEach(requisicao -> System.out.println(requisicao + " Mesa: " + requisicao.getNomeCliente()));
                String nome = scanner.nextLine();
                for (RequisicaoDeMesa rm : requisicoes) {
                    if (rm.getNomeCliente().equals(nome)) {
                        System.out.println("R$: " + rm.calculaConta());
                    }
                }
            } else if (opcao == 9) {

                System.out.println("\nEncerrando programa.");
                
                break;

            } else {

                System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    }
}
