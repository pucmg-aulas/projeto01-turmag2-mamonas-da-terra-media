package restaurante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import restaurante.exception.ItemDoPedidoException;
import restaurante.exception.PedidoException;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<ItemMenu> itens;
    private double total;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.total = 0.0;
    }

    public void adicionarItem(ItemMenu item) throws PedidoException {
        if (item == null) {
            throw new PedidoException("Item de menu nulo.");
        }

        itens.add(item);
        total += item.getPreco();
    }

    public void removerItem(ItemMenu item) throws PedidoException {
        if (item == null) {
            throw new PedidoException("Item de menu nulo.");
        }

        if (!itens.remove(item)) {
            throw new ItemDoPedidoException("Item não encontrado no pedido.");
        }

        total -= item.getPreco();
    }

    public double calcularTotal() {
        return total * 1.1; 
    }

    public List<ItemMenu> getItens() {
        return itens;
    }

    public void limparPedido() {
        itens.clear();
        total = 0.0;
    }

    @Override
    public String toString() {
        StringBuilder pedido_carrier = new StringBuilder();
        for (ItemMenu item : itens) {
            pedido_carrier.append(item.toString()).append("\n");
        }
        pedido_carrier.append("Total: R$ ").append(total).append("\n");
        return pedido_carrier.toString();
    }
}
