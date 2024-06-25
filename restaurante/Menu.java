package restaurante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Menu instance;
    private List<ItemMenu> itens;

    public Menu() {
        this.itens = new ArrayList<>();
    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
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
