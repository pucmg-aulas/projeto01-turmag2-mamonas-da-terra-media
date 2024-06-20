package restaurante.controller;

import restaurante.model.ItemMenu;
import restaurante.model.Menu;
import restaurante.util.DataSerializer;
import restaurante.view.MenuView;

import java.io.IOException;

public class MenuController {
    private Menu menu;
    private MenuView view;

    public MenuController(MenuView view) {
        this.view = view;
        try {
            this.menu = (Menu) DataSerializer.deserialize("menu.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            this.menu = new Menu();
        }
    }

    public void adicionarItem(String nome, double preco) {
        this.menu.adicionarItem(nome, preco);
        try {
            DataSerializer.serialize(menu, "menu.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        atualizarView();
    }

    public void removerItem(String nome) {
        this.menu.removerItem(nome);
        try {
            DataSerializer.serialize(menu, "menu.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        atualizarView();
    }

    public void atualizarView() {
        view.displayMenu(menu.imprimirMenu());
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
        try {
            DataSerializer.serialize(menu, "menu.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
