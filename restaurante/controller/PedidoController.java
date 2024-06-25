package restaurante.controller;

import restaurante.model.ItemMenu;
import restaurante.model.Pedido;
import restaurante.view.PedidoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PedidoController {
    private Pedido model;
    private PedidoView view;

    public PedidoController(Pedido model, PedidoView view) {
        this.model = model;
        this.view = view;

        this.view.addAdicionarListener(new AdicionarListener());
        this.view.addRemoverListener(new RemoverListener());
        this.view.addLimparListener(new LimparListener());

        updateView();
    }

    class AdicionarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String itemName = view.getItemName();
            double itemPrice = view.getItemPrice();
            ItemMenu item = new ItemMenu(itemName, itemPrice);
            model.adicionarItem(item);
            updateView();
            view.clearInputs();
        }
    }

    class RemoverListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String itemName = view.getItemName();
            double itemPrice = view.getItemPrice();
            ItemMenu item = new ItemMenu(itemName, itemPrice);
            model.removerItem(item);
            updateView();
            view.clearInputs();
        }
    }

    class LimparListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.limparPedido();
            updateView();
        }
    }

    private void updateView() {
        view.setPedidoText(model.toString());
        view.setTotalText(String.format("Total: R$ %.2f", model.calcularTotal()));
    }
}
