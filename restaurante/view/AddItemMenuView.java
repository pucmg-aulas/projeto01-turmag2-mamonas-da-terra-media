package restaurante.view;

import java.awt.event.ActionListener;
import javax.swing.*;

public class AddItemMenuView {
    private JFrame frame;
    private JTextField nomeField;
    private JTextField valorField;
    private JButton adicionarButton;

    public AddItemMenuView() {
        frame = new JFrame("Adicionar Item ao Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 20, 80, 25);
        panel.add(nomeLabel);

        nomeField = new JTextField(20);
        nomeField.setBounds(100, 20, 165, 25);
        panel.add(nomeField);

        JLabel valorLabel = new JLabel("Valor:");
        valorLabel.setBounds(10, 50, 80, 25);
        panel.add(valorLabel);

        valorField = new JTextField(20);
        valorField.setBounds(100, 50, 165, 25);
        panel.add(valorField);

        adicionarButton = new JButton("Adicionar");
        adicionarButton.setBounds(10, 80, 150, 25);
        panel.add(adicionarButton);
    }

    public String getNome() {
        return nomeField.getText();
    }

    public double getValor() {
        return Double.parseDouble(valorField.getText());
    }

    public void addAdicionarButtonListener(ActionListener listener) {
        adicionarButton.addActionListener(listener);
    }
}
