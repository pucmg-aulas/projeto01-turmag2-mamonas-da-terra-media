
package controller;

import restaurante.ItemMenu;
import restaurante.Menu;
import view.AddItemMenuView;

public class AddItemMenuController {

    private AddItemMenuView view;
    private Menu menu;

    public AddItemMenuController() {
        this.view = new AddItemMenuView();
        this.menu = Menu.getInstance();

        this.view.getBtnSalvar().addActionListener((e)
                -> adicionarAoMenu());

        this.view.getBtnCancelar().addActionListener((e)
                -> cancelar());
        
        this.view.setVisible(true);
    }

    public void adicionarAoMenu() {
        String nome = view.getTxtNome().getText();
        double valor = Double.parseDouble(this.view.getTxtPreco().getText());
        try {
            ItemMenu item = new ItemMenu(nome, valor);
            menu.adicionarItem(item);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }

    public void cancelar() {
        this.view.dispose();
    }

}
