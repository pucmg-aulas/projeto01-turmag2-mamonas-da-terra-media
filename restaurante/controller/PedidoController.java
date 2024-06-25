package controller;

import restaurante.ItemMenu;
import restaurante.Pedido;
import view.PedidoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import restaurante.Menu;
import restaurante.RequisicaoDeMesa;

public class PedidoController {

    private ArrayList<RequisicaoDeMesa> requisicoes;
    private Pedido model;
    private PedidoView view;
    private Menu menu;

    public PedidoController() {
        this.model = new Pedido();
        this.view = new PedidoView();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("menu.ser"))) {
            menu = (Menu) ois.readObject();
        } catch (IOException | ClassNotFoundException f) {
            f.printStackTrace();
            menu = new Menu();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("requisicao.ser"))) {
            this.requisicoes = (ArrayList<RequisicaoDeMesa>) ois.readObject();
        } catch (IOException | ClassNotFoundException f) {
            f.printStackTrace();
        }

        this.view.getBtnAdicionar().addActionListener(new AdicionarListener());
        this.view.getBtnRemover().addActionListener(new RemoverListener());
        this.view.getBtnVoltar().addActionListener((e) -> {
            voltar();
        });
        carregaCardapio();
        this.view.setVisible(true);

    }

    class AdicionarListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            
                String itemName = view.getNomeItem().getText();
                List<ItemMenu> itens = menu.getItens();
                ItemMenu item = (ItemMenu) itens.stream()
                        .filter(i -> i.getNome().equals(itemName));

                JLabel lm = new JLabel();
                lm.setText("Achou!");
                view.setVerificaAchouCliente(lm);

                String nomeCliente = view.getNomeCliente().getText();
                RequisicaoDeMesa cliente = (RequisicaoDeMesa) requisicoes.stream()
                        .filter(c -> c.getNomeCliente().equals(nomeCliente));
                cliente.getPedido().adicionarItem(item);
           
        }
    }

    class RemoverListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String itemName = view.getNomeItem().getText();
            List<ItemMenu> itens = menu.getItens();
            ItemMenu item = (ItemMenu) itens.stream()
                    .filter(i -> i.getNome().equals(itemName));

            String nomeCliente = view.getNomeCliente().getText();
            RequisicaoDeMesa cliente = (RequisicaoDeMesa) requisicoes.stream()
                    .filter(c -> c.getNomeCliente().equals(nomeCliente));
            cliente.getPedido().removerItem(item);
        }

    }
    
    public void carregaCardapio(){
        DefaultListModel lm = new DefaultListModel();
        Iterator<ItemMenu> itens = menu.getItens().iterator();
        while (itens.hasNext()) {
            ItemMenu i = itens.next();
            String item = i.getNome() + " - " + i.getPreco();
            lm.addElement(item);
        }
        view.getListaMenu().setModel(lm);
    }

    public void voltar() {
        new MenuPrincipalController();
        view.dispose();
    }
}
