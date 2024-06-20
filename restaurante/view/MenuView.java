package restaurante.view;

import restaurante.model.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class MenuView extends JPanel {

    private JList<String> itemList;
    private JScrollPane scrollPane;

    public MenuView() {
        initComponents();
    }

    private void initComponents() {
        scrollPane = new JScrollPane();
        itemList = new JList<>();

        setLayout(new BorderLayout());

        itemList.setModel(new AbstractListModel<String>() {
            Menu menu = new Menu();
            List<String> data = menu.getItens().stream()
                                    .map(item -> item.getNome() + " - R$" + item.getPreco())
                                    .collect(Collectors.toList());

            public int getSize() {
                return data.size();
            }

            public String getElementAt(int i) {
                return data.get(i);
            }
        });

        scrollPane.setViewportView(itemList);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void displayMenu(String menuText) {
        String[] items = menuText.split("\n");
        itemList.setListData(items);
    }
}
