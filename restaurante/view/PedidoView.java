package restaurante.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PedidoView extends JFrame {
    private JTextArea pedidoArea;
    private JButton adicionarButton;
    private JButton removerButton;
    private JButton limparButton;
    private JTextField itemField;
    private JTextField precoField;
    private JLabel totalLabel;

    public PedidoView() {
        setTitle("Sistema de Pedidos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        pedidoArea = new JTextArea();
        pedidoArea.setEditable(false);
        add(new JScrollPane(pedidoArea), BorderLayout.CENTER);

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
        limparButton = new JButton("Limpar");

        buttonPanel.add(adicionarButton);
        buttonPanel.add(removerButton);
        buttonPanel.add(limparButton);

        add(buttonPanel, BorderLayout.SOUTH);

        totalLabel = new JLabel("Total: R$ 0.00");
        add(totalLabel, BorderLayout.EAST);

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

    public void setPedidoText(String text) {
        pedidoArea.setText(text);
    }

    public void setTotalText(String text) {
        totalLabel.setText(text);
    }

    public void addAdicionarListener(ActionListener listener) {
        adicionarButton.addActionListener(listener);
    }

    public void addRemoverListener(ActionListener listener) {
        removerButton.addActionListener(listener);
    }

    public void addLimparListener(ActionListener listener) {
        limparButton.addActionListener(listener);
    }

    public void clearInputs() {
        itemField.setText("");
        precoField.setText("");
    }
}
