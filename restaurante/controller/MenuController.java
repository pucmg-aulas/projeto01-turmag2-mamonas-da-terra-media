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

/**
 *
 * @author Pedro Morais
 */
public class MenuController {
    
    private MenuView view;
    
    public MenuController() {
        this.view = new MenuView();
    
        
        this.view.getBtnCancelar().addActionListener((E) -> {
            cancelar();
        });
    }
    
    public void carregarMenu(){
        Menu menu = Menu.getInstance();
        Object colunas[] = {"Nome", "Preco"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);
        tm.setNumRows(0);
        Iterator<ItemMenu> itens = menu.getItens().iterator();
        while (itens.hasNext()) {
        ItemMenu i = itens.next();
        String item = i.getNome() + " - " + i.getPreco();
        String linha[] = item.split("%");
        tm.addRow(new Object[]{linha[0], linha[1]});
        }
        view.getListaItens().setModel((ListModel<String>) tm);

    }
    
    public void cancelar(){
        this.view.dispose();
    }
           
    
}
