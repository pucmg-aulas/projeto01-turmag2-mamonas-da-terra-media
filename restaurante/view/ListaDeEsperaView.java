package restaurante.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ListaDeEsperaView extends JFrame {
    private JTextArea listaTextArea;
    private JTextField nomeClienteField;
    private JTextField quantiaPessoasField;
    private JButton adicionarButton;
    private JButton removerButton;
    private JButton imprimirListaButton;

    public ListaDeEsperaView() {
        setTitle("Lista de Espera do Restaurante");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        listaTextArea = new JTextArea();
        listaTextArea.setEditable(false);
        add(new JScrollPane(listaTextArea), BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Nome do Cliente:"));
        nomeClienteField = new JTextField();
        panel.add(nomeClienteField);

        panel.add(new JLabel("Quantia de Pessoas:"));
        quantiaPessoasField = new JTextField();
        panel.add(quantiaPessoasField);

        adicionarButton = new JButton("Adicionar à Lista");
        panel.add(adicionarButton);

        removerButton = new JButton("Remover da Lista");
        panel.add(removerButton);

        imprimirListaButton = new JButton("Imprimir Lista");
        panel.add(imprimirListaButton);

        add(panel, BorderLayout.SOUTH);
    }

    public String getNomeCliente() {
        return nomeClienteField.getText();
    }

    public int getQuantiaPessoas() {
        return Integer.parseInt(quantiaPessoasField.getText());
    }

    public void setListaText(String text) {
        listaTextArea.setText(text);
    }

    public void addAdicionarButtonListener(ActionListener listener) {
        adicionarButton.addActionListener(listener);
    }

    public void addRemoverButtonListener(ActionListener listener) {
        removerButton.addActionListener(listener);
    }

    public void addImprimirListaButtonListener(ActionListener listener) {
        imprimirListaButton.addActionListener(listener);
    }
}
