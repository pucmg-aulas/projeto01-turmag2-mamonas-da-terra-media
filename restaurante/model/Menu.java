package restaurante.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<ItemMenu> itens;

    public Menu() {
        this.itens = new ArrayList<>();

        itens.add(new ItemMenu("Hamburguer", 10.0));
        itens.add(new ItemMenu("Batata Frita", 5.0));
        itens.add(new ItemMenu("Refrigerante", 3.0));
    }

    public List<ItemMenu> getItens() {
        return itens;
    }

    public void adicionarItem(String nome, double preco) {

        itens.add(new ItemMenu(nome, preco));
    }

    public void removerItem(String nome) {

        itens.removeIf(item -> item.getNome().equals(nome));
    }

    public String imprimirMenu() {

        StringBuilder menu_carrier = new StringBuilder();
        for (ItemMenu item : itens) {

            menu_carrier.append(item.toString()).append("\n");
        }
        return menu_carrier.toString();
    }
}
