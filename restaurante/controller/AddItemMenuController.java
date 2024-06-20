package restaurante.controller;

import restaurante.model.ItemMenu;
import restaurante.model.Menu;
import restaurante.view.AddItemMenuView;

public class AddItemMenuController {
    private AddItemMenuView view;
    private Menu menu;

    public AddItemMenuController() {
        this.view = new AddItemMenuView();
        this.menu = new Menu();
    }

    public void adicionarItemMenu(String nome, double valor) {
        menu.adicionarItem(nome, valor);
    }
}
