package restaurante;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemMenu> itens;
    private double total;

    public Pedido() {


        this.itens = new ArrayList<>();
        this.total = 0.0;
    }

    public void adicionarItem(ItemMenu item) {

        itens.add(item);
        total += item.getPreco();
    }

    public void removerItem(ItemMenu item) {


        if (itens.remove(item)) {
            total -= item.getPreco();
        }
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
