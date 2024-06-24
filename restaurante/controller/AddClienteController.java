/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalTime;
import restaurante.*;
import view.AddClienteView;
import java.util.*;

public class AddClienteController {

    private AddClienteView view;
    private ListaDeEspera lista;

    public AddClienteController() {
        this.view = new AddClienteView();
        this.lista = new ListaDeEspera(new ArrayList<>());

        this.view.getBtnSalvar().addActionListener((e) -> {
            addCliente();
        });

        this.view.getBtnCancelar().addActionListener((e) -> {
            cancelar();
            new MenuPrincipalController();
        });

    }

    public void addCliente() {
        ArrayList<RequisicaoDeMesa> requisicoes = new ArrayList<>(); 
        ArrayList<Mesa> mesas = new ArrayList<Mesa>(); 
        mesas.add(new Mesa(4, true));  
        mesas.add(new Mesa(6, true));  
        mesas.add(new Mesa(8, true)); 
        Scanner scanner = new Scanner(System.in);
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
            this.lista.adicionarNaLista(requisicao);
            requisicoes.add(requisicao);
            System.out.println("Cliente adicionado com sucesso!");
        } else {
            System.out.println("Nenhuma mesa disponível no momento.");
        }
    }

    public void cancelar() {
        this.view.dispose();
    }

}
