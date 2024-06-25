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
import restaurante.Mesa;
import restaurante.RequisicaoDeMesa;
import view.ClientesView;

/**
 *
 * @author Pedro Morais
 */
public class ClientesController {

    private ArrayList<RequisicaoDeMesa> model;
    private ArrayList<Mesa> mesas;
    private ClientesView view;

    public ClientesController() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("requisicao.ser"))) {
            this.model = (ArrayList<RequisicaoDeMesa>) ois.readObject();
        } catch (IOException | ClassNotFoundException f) {
            f.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mesas.ser"))) {
            mesas = (ArrayList<Mesa>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            mesas = new ArrayList<>();
        }
        this.view = new ClientesView();

        this.view.getBtnAdicionar().addActionListener((e) -> {
            adicionaCliente();
        });
        this.view.getBtnRemover().addActionListener((e) -> {
            removeCliente();
        });
        
        this.view.setVisible(true);

    }

    private void adicionaCliente() {
        String nomeCliente = view.getNomeCliente().getText();
        int numeroAscentos = Integer.valueOf(this.view.getNumeroAscentos().getText());
        Mesa mesaDisponivel = mesas.stream()
                .filter(mesa -> mesa.isDisponivel() && mesa.getNumeroAssentos() >= numeroAscentos)
                .sorted(Comparator.comparingInt(Mesa::getNumeroAssentos))
                .findFirst()
                .orElse(null);

        if (mesaDisponivel != null) {
            RequisicaoDeMesa requisicao = new RequisicaoDeMesa(nomeCliente, numeroAscentos, LocalTime.now(), mesaDisponivel);
            model.add(requisicao);
            JLabel lm = new JLabel();
            lm.setText("Cliente Adicionado!");  
            view.setStatus(lm);
            carregaClientes();
        } else {
            new ListaDeEsperaController();
        }
    }
    
    private void removeCliente(){
        String nomeCliente = view.getNomeCliente().getText();
        RequisicaoDeMesa cliente = (RequisicaoDeMesa) model.stream()
                .filter(c -> c.getNomeCliente().equals(nomeCliente));
            model.remove(cliente);
            carregaClientes();
    }
    
    private void carregaClientes(){
        DefaultListModel lm = new DefaultListModel();
            Iterator<RequisicaoDeMesa> clientes = model.iterator();
            while (clientes.hasNext()) {
                RequisicaoDeMesa rm = clientes.next();
                String item = rm.getNomeCliente() + " - " + rm.getQuantiaPessoas();
                lm.addElement(item);
            }
            view.getListaClientes().setModel(lm);
    }
}
