package restaurante;

import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDeEspera listaDeEspera = new ListaDeEspera();
        ArrayList<Mesas> mesas = new ArrayList<Mesas>(); 
        mesas.add(new Mesas(4, true));  
        mesas.add(new Mesas(6, true));  
        mesas.add(new Mesas(8, true)); 


        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Incluir pessoa na fila de espera por mesa");
            System.out.println("2 - Remover pessoa da fila de espera");
            System.out.println("3 - Buscar pessoa na fila de espera");
            System.out.println("4 - Mostrar toda a lista de espera");
            System.out.println("5 - Mostrar disponibilidade das mesas");
            System.out.println("6 - Sair");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {

                System.out.print("\nDigite o nome do cliente: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o número de lugares: ");
                int lugares = scanner.nextInt();
                scanner.nextLine();

                Mesas mesaDisponivel = mesas.stream().filter(Mesas::isDisponivel).findFirst().orElse(null);
                if (mesaDisponivel != null) {
                    mesaDisponivel.ocuparMesa();
                    RequisicaoDeMesa novaRequisicao = new RequisicaoDeMesa(nome, lugares, LocalTime.now(), mesaDisponivel);
                    listaDeEspera.adicionarNaLista(novaRequisicao);
                    System.out.println("Cliente adicionado com sucesso!");
                } else {
                    System.out.println("Nenhuma mesa disponível no momento.");
                }

            } else if (opcao == 2) {

                System.out.print("\nDigite o nome do cliente a ser removido: ");
                String nome = scanner.nextLine();
                listaDeEspera.removerDaListaPorNome(nome);
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

                System.out.println("Encerrando...");
                scanner.close();
                break;
                
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
