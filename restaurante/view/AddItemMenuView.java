package restaurante.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddItemMenuView extends JFrame {
    private JTextField txtNome;
    private JTextField txtValor;
    private JButton btnSalvar;
    private JButton btnCancelar;

    public AddItemMenuView() {
        setTitle("Adicionar Item ao Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Valor:"));
        txtValor = new JTextField();
        add(txtValor);

        btnSalvar = new JButton("Salvar");
        add(btnSalvar);

        btnCancelar = new JButton("Cancelar");
        add(btnCancelar);

        pack();
        setVisible(true);
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtValor() {
        return txtValor;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
