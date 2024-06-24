/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

//TODO ************************************
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.AbstractListModel;
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

    public ContaController() {
        this.view = new ContaView();

        this.view.getBtnClientePagou().addActionListener((e) -> {
            calculaConta();
        });

        this.view.getBtnBuscar().addActionListener((e) -> {
            calculaConta();
        });

        this.view.setVisible(true);
    }

    public void calculaConta() {

        ArrayList<RequisicaoDeMesa> requisicoes = new ArrayList<>();
        ArrayList<Mesa> mesas = new ArrayList<Mesa>();
        mesas.add(new Mesa(4, true));
        mesas.add(new Mesa(6, true));
        mesas.add(new Mesa(8, true));
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
        
        /*Pedido pedido = rm.getPedido();
        List<ItemMenu> itens = pedido.getItens();
        AbstractListModel tabela = null;
        for (ItemMenu i : itens){
            tabela.add(i.getNome() + " - " + i.getPreco());                               
        }
        this.view.getItensList().setModel(tabela);*/
        
        Object colunas[] = {"Nome", "Preco"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);
        tm.setNumRows(0);
        Iterator<ItemMenu> itens = rm.getPedido().getItens().iterator();
        while (itens.hasNext()) {
        ItemMenu i = itens.next();
        String item = i.getNome() + " - " + i.getPreco();
        String linha[] = item.split("%");
        tm.addRow(new Object[]{linha[0], linha[1]});
        }
        view.getItensList().setModel((ListModel<String>) tm);
    }

}
