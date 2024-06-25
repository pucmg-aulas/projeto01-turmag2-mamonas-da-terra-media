package restaurante.view;

import restaurante.model.RequisicaoDeMesa;
import restaurante.controller.RequisicaoDeMesaController;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class RequisicaoDeMesaView extends JFrame {
    private JTextField nomeClienteField;
    private JTextField quantiaPessoasField;
    private JTextField horaEntradaField;
    private JTextField mesaAtribuidaField;
    private JButton submitButton;

    public RequisicaoDeMesaView(RequisicaoDeMesaController controller) {
        super("Requisição de Mesa");
        setLayout(new GridLayout(5, 2));

        nomeClienteField = new JTextField();
        quantiaPessoasField = new JTextField();
        horaEntradaField = new JTextField();
        mesaAtribuidaField = new JTextField();
        submitButton = new JButton("Submit");

        add(new JLabel("Nome do Cliente:"));
        add(nomeClienteField);
        add(new JLabel("Quantia de Pessoas:"));
        add(quantiaPessoasField);
        add(new JLabel("Hora de Entrada (HH:MM):"));
        add(horaEntradaField);
        add(new JLabel("Mesa Atribuída:"));
        add(mesaAtribuidaField);
        add(submitButton);

        submitButton.addActionListener(e -> {
            String nomeCliente = nomeClienteField.getText();
            int quantiaPessoas = Integer.parseInt(quantiaPessoasField.getText());
            LocalTime horaEntrada = LocalTime.parse(horaEntradaField.getText());
            // Supondo que a mesa atribuída seja representada por um inteiro
            int mesaNumero = Integer.parseInt(mesaAtribuidaField.getText());
            controller.criarRequisicao(nomeCliente, quantiaPessoas, horaEntrada, mesaNumero);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
