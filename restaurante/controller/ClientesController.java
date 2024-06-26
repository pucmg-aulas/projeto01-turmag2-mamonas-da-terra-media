/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import restaurante.*;
import restaurante.RequisicaoDeMesa;
import restaurante.RequisicoesDeMesa;
import view.ClientesView;

/**
 *
 * @author Pedro Morais
 */
public class ClientesController {

    private RequisicoesDeMesa model;
    private Mesas mesas;
    private ClientesView view;

    public ClientesController(RequisicoesDeMesa rm, ListaDeEspera lista, Mesas mesas) {

        this.model = rm;
        this.mesas = mesas;   
        this.view = new ClientesView();

        carregaClientes();
        this.view.getBtnAdicionar().addActionListener((e) -> {
            adicionaCliente(lista);
        });
        this.view.getBtnRemover().addActionListener((e) -> {
            removeCliente();
        });

        this.view.getBtnVoltar().addActionListener((e) -> {
            voltar();
        });
        this.view.setVisible(true);

        
    }

    private void adicionaCliente(ListaDeEspera lista) {
        String nomeCliente = view.getNomeCliente().getText();
        int numeroAscentos = Integer.valueOf(this.view.getNumeroAscentos().getText());
        Mesa mesaDisponivel = mesas.getMesas().stream()
                .filter(mesa -> mesa.isDisponivel() && mesa.getNumeroAssentos() >= numeroAscentos)
                .sorted(Comparator.comparingInt(Mesa::getNumeroAssentos))
                .findFirst()
                .orElse(null);

        if (mesaDisponivel != null) {
            RequisicaoDeMesa requisicao = new RequisicaoDeMesa(nomeCliente, numeroAscentos, LocalTime.now(), mesaDisponivel);
            model.getRequisicoes().add(requisicao);
            JLabel lm = new JLabel();
            lm.setText("Cliente Adicionado!");
            view.setStatus(lm);
            carregaClientes();
        } else {
            new ListaDeEsperaController(lista);
        }
    }
    

    public void removeCliente() {
        String nomeCliente = view.getNomeCliente().getText();
        RequisicaoDeMesa cliente = (RequisicaoDeMesa) model.getRequisicoes().stream()
                .filter(c -> c.getNomeCliente().equals(nomeCliente));
        model.getRequisicoes().remove(cliente);
        carregaClientes();
    }

    public void carregaClientes() {
        DefaultListModel lm = new DefaultListModel();
        Iterator<RequisicaoDeMesa> clientes = model.getRequisicoes().iterator();
        while (clientes.hasNext()) {
            RequisicaoDeMesa rm = clientes.next();
            String item = rm.getNomeCliente() + " - " + rm.getQuantiaPessoas();
            lm.addElement(item);
        }
        view.getListaClientes().setModel(lm);
    }
    
    public void voltar(){
        this.view.dispose();
    }
}
