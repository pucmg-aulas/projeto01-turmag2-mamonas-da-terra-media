/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Iterator;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import restaurante.ItemMenu;
import restaurante.Menu;
import view.MenuView;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.DefaultListModel;

/**
 *
 * @author Pedro Morais
 */
public class MenuController {

    private MenuView view;
    private Menu menu;

    public MenuController() {
        this.view = new MenuView();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("menu.ser"))) {
            menu = (Menu) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            menu = new Menu();
        }
        carregaMenu();
        this.view.getBtnSalvar().addActionListener((e)
                -> adicionarAoMenu());

        this.view.getBtnVoltar().addActionListener((e)
                -> cancelar());
        
        this.view.setVisible(true);
    }

    public void carregaMenu() {
        DefaultListModel lm = new DefaultListModel();
        Iterator<ItemMenu> itens = menu.getItens().iterator();
        while (itens.hasNext()) {
            ItemMenu i = itens.next();
            String item = i.getNome() + " - " + i.getPreco();
            lm.addElement(item);
        }
        view.getListaMenu().setModel(lm);

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
        carregaMenu();
    }

    public void cancelar() {
        this.view.dispose();
        new MenuPrincipalController();
    }

}
