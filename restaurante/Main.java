package restaurante;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = carregarMenu();
        ArrayList<RequisicaoDeMesa> requisicoes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mesa> mesas = carregarMesas();
        ListaDeEspera listaDeEspera = carregarListaDeEspera(mesas);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Incluir pessoa na fila de espera por mesa");
            System.out.println("2 - Remover pessoa da fila de espera");
            System.out.println("3 - Buscar pessoa na fila de espera");
            System.out.println("4 - Mostrar toda a lista de espera");
            System.out.println("5 - Mostrar disponibilidade das mesas");
            System.out.println("6 - Imprimir Menu");
            System.out.println("7 - Fazer Pedido");
            System.out.println("8 - Pedir a conta");
            System.out.println("10 - Mostrar clientes por mesa");
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
                requisicoes.removeIf(rm -> rm.getNomeCliente().equals(nome));
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
                System.out.print("Digite o número de lugares da mesa: ");
                int numeroAssentos = scanner.nextInt();
                scanner.nextLine();
                Mesa mesaEscolhida = mesas.stream()
                        .filter(mesa -> mesa.getNumeroAssentos() == numeroAssentos)
                        .findFirst()
                        .orElse(null);

                if (mesaEscolhida != null) {
                    System.out.print("Nome do Cliente: ");
                    String nome = scanner.nextLine();
                    RequisicaoDeMesa requisicaoEncontrada = requisicoes.stream()
                            .filter(rm -> rm.getNomeCliente().equals(nome) && rm.getMesaAtribuida().equals(mesaEscolhida))
                            .findFirst()
                            .orElse(null);

                    if (requisicaoEncontrada != null) {
                        System.out.println("Menu:\n" + menu.imprimirMenu());
                        System.out.print("Digite o nome do item para adicionar ao pedido: ");
                        String itemNome = scanner.nextLine();
                        ItemMenu item = menu.getItens().stream()
                                .filter(i -> i.getNome().equalsIgnoreCase(itemNome))
                                .findFirst()
                                .orElse(null);

                        if (item != null) {
                            requisicaoEncontrada.getPedido().adicionarItem(item);
                            System.out.println("Item adicionado ao pedido!");
                        } else {
                            System.out.println("Item não encontrado no menu! :(");
                        }
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                } else {
                    System.out.println("Mesa não encontrada!");
                }
            } else if (opcao == 8) {
                System.out.println("Escolha a Mesa: ");
                requisicoes.forEach(requisicao -> System.out.println("Cliente: " + requisicao.getNomeCliente() + " - Mesa: " + requisicao.getMesaAtribuida().getNumeroAssentos() + " lugares"));
                System.out.print("Nome do Cliente: ");
                String nome = scanner.nextLine();
                RequisicaoDeMesa requisicaoEncontrada = requisicoes.stream()
                        .filter(rm -> rm.getNomeCliente().equals(nome))
                        .findFirst()
                        .orElse(null);
                if (requisicaoEncontrada != null) {
                    System.out.println("Total a pagar: R$ " + requisicaoEncontrada.calculaConta());
                } else {
                    System.out.println("Cliente não encontrado!");
                }
            } else if (opcao == 10) {
                System.out.print("Digite o número de lugares da mesa: ");
                int numeroAssentos = scanner.nextInt();
                scanner.nextLine();
                Mesa mesaEscolhida = mesas.stream()
                        .filter(mesa -> mesa.getNumeroAssentos() == numeroAssentos)
                        .findFirst()
                        .orElse(null);

                if (mesaEscolhida != null) {
                    System.out.println("Clientes ocupando a mesa " + numeroAssentos + " lugares:");
                    requisicoes.stream()
                            .filter(rm -> rm.getMesaAtribuida().equals(mesaEscolhida))
                            .forEach(rm -> System.out.println("Cliente: " + rm.getNomeCliente()));
                } else {
                    System.out.println("Mesa não encontrada!");
                }
            } else if (opcao == 9) {
                System.out.println("\nEncerrando programa.");
                break;
            } else {
                System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    }

    private static Menu carregarMenu() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("menu.ser"))) {
            return (Menu) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Menu();
        }
    }

    private static ArrayList<Mesa> carregarMesas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mesas.ser"))) {
            return (ArrayList<Mesa>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static ListaDeEspera carregarListaDeEspera(ArrayList<Mesa> mesas) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("listaDeEspera.ser"))) {
            return (ListaDeEspera) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ListaDeEspera(mesas);
        }
    }
}
