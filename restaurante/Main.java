package restaurante;

import java.util.*;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDeEspera listaDeEspera = new ListaDeEspera();
        Mesas m1 = new Mesas(4,true);
        Mesas m2 = new Mesas(6,true);
        Mesas m3 = new Mesas(8,true);

        while (true) {
            System.out.println("\nEscolha uma opcao:");
            System.out.println("1 - Incluir pessoa na fila de espera");
            System.out.println("2 - Remover pessoa da fila de espera");
            System.out.println("3 - Buscar pessoa na fila de espera");
            System.out.println("4 - Mostrar toda a lista de espera");
            System.out.println("5 - Mostrar disponibilidade das mesas");
            System.out.println("6 - Desocupar Mesa");
            System.out.println("7 - Ocupar Mesa");
            System.out.println("8 - Sair");

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
                
                 System.out.println("\nMesas:");
                System.out.println("Mesa 4 lugares: " + m1.isDisponivel());
                System.out.println("Mesa 6 lugares: " + m2.isDisponivel());
                System.out.println("Mesa 8 lugares: " + m3.isDisponivel());
                
            } else if (opcao == 6) {
              
               System.out.println("\nDesocupar mesa :");
               System.out.println("1- Mesa 4 lugares ");
                System.out.println("2- Mesa 6 lugares ");
                System.out.println("3- Mesa 8 lugares ");
               int x = scanner.nextInt();
               if (x == 1){
     
                   m1.desocuparMesa();
               }
               if (x == 2){
                   m2.desocuparMesa();
               }
               if (x == 3){
                   m3.desocuparMesa();
               }
                
            }
            else if (opcao == 7) {
               
                System.out.println("\nOcupar mesa :");
               System.out.println("1- Mesa 4 lugares ");
               System.out.println("2- Mesa 6 lugares ");
               System.out.println("3- Mesa 8 lugares ");
               int x = scanner.nextInt();
               if (x == 1){
     
                   m1.ocuparMesa();
               }
               if (x == 2){
                   m2.ocuparMesa();
               }
               if (x == 3){
                   m3.ocuparMesa();
               }
                
            }else if (opcao == 8) {
                System.out.println("\nEncerrando programa.");
                break;
            }else {
                
                System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}

