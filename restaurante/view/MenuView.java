package restaurante.view;

import restaurante.Menu;  

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuView extends JFrame {
    private JTextArea menuArea;
    private JButton adicionarButton;
    private JButton removerButton;
    private JTextField itemField;
    private JTextField precoField;

    public MenuView() {
        setTitle("Menu do Restaurante");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        menuArea = new JTextArea();
        menuArea.setEditable(false);
        add(new JScrollPane(menuArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        itemField = new JTextField();
        precoField = new JTextField();

        inputPanel.add(new JLabel("Item:"));
        inputPanel.add(itemField);
        inputPanel.add(new JLabel("Preço:"));
        inputPanel.add(precoField);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        adicionarButton = new JButton("Adicionar");
        removerButton = new JButton("Remover");

        buttonPanel.add(adicionarButton);
        buttonPanel.add(removerButton);

        add(buttonPanel, BorderLayout.SOUTH);

        Menu menu = Menu.getInstance();  
        setMenuText(menu.imprimirMenu());

        setVisible(true);
    }

    public String getItemName() {
        return itemField.getText();
    }

    public double getItemPrice() {
        try {
            return Double.parseDouble(precoField.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public void setMenuText(String text) {
        menuArea.setText(text);
    }

    public void addAdicionarListener(ActionListener listener) {
        adicionarButton.addActionListener(listener);
    }

    public void addRemoverListener(ActionListener listener) {
        removerButton.addActionListener(listener);
    }
}
