/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

//TODO ************************************
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import restaurante.ItemMenu;
import restaurante.Mesa;
import restaurante.Pedido;
import restaurante.RequisicaoDeMesa;
import view.ContaView;

/**
 *
 * @author Pedro Morais
 */
public class ContaController {

    private ContaView view;
    private ArrayList<RequisicaoDeMesa> requisicoes;

    public ContaController() {
        this.view = new ContaView();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("requisicao.ser"))) {
            this.requisicoes = (ArrayList<RequisicaoDeMesa>) ois.readObject();
        } catch (IOException | ClassNotFoundException f) {
            f.printStackTrace();
        }

        this.view.getBtnClientePagou().addActionListener((e) -> {
            calculaConta();
        });

        this.view.getBtnBuscar().addActionListener((e) -> {
            calculaConta();
        });

        this.view.setVisible(true);
    }

    public void calculaConta() {

        String nome = this.view.getTxtProcuraCliente().getText();
        RequisicaoDeMesa requisicaoEncontrada = requisicoes.stream()
                .filter(rm -> rm.getNomeCliente().equals(nome))
                .findFirst()
                .orElse(null);
        if (requisicaoEncontrada != null) {
            carregarPedidos(requisicaoEncontrada);
            String txtTotalConta = "R$:" + requisicaoEncontrada.calculaConta();
            this.view.getTxtTotalConta().setText((String) txtTotalConta);

        } else {
            System.out.println("Errado");
        }
    }

    public void cancelar() {
        this.view.dispose();
        new MenuPrincipalController();
    }

    public void carregarPedidos(RequisicaoDeMesa rm) {

        DefaultListModel lm = new DefaultListModel();
        String nomeCliente = view.getTxtProcuraCliente().getText();
        RequisicaoDeMesa cliente = (RequisicaoDeMesa) requisicoes.stream()
                .filter(c -> c.getNomeCliente().equals(nomeCliente));

        List<ItemMenu> pedidos = cliente.getPedido().getItens();
        Iterator<ItemMenu> itens = pedidos.iterator();
        int count = 1;
        while (itens.hasNext()) {
            ItemMenu i = itens.next();
            String item = i.getNome() + " - " + i.getPreco();
            lm.addElement(item);
        }
        view.getItensList().setModel(lm);
    }

}
