package restaurante.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MesaView extends JFrame {

    private JLabel lblNumeroAssentos;
    private JLabel lblDisponibilidade;
    private JTextField txtNumeroAssentos;
    private JCheckBox chkDisponibilidade;
    private JButton btnOcupar;
    private JButton btnDesocupar;

    public MesaView() {
        setTitle("Informações da Mesa");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        lblNumeroAssentos = new JLabel("Número de Assentos:");
        lblNumeroAssentos.setBounds(10, 20, 150, 25);
        panel.add(lblNumeroAssentos);

        txtNumeroAssentos = new JTextField(10);
        txtNumeroAssentos.setBounds(160, 20, 120, 25);
        txtNumeroAssentos.setEditable(false);
        panel.add(txtNumeroAssentos);

        lblDisponibilidade = new JLabel("Disponibilidade:");
        lblDisponibilidade.setBounds(10, 50, 150, 25);
        panel.add(lblDisponibilidade);

        chkDisponibilidade = new JCheckBox();
        chkDisponibilidade.setBounds(160, 50, 120, 25);
        chkDisponibilidade.setEnabled(false);
        panel.add(chkDisponibilidade);

        btnOcupar = new JButton("Ocupar Mesa");
        btnOcupar.setBounds(10, 80, 130, 25);
        panel.add(btnOcupar);

        btnDesocupar = new JButton("Desocupar Mesa");
        btnDesocupar.setBounds(150, 80, 130, 25);
        panel.add(btnDesocupar);
    }

    public void addOcuparMesaListener(ActionListener listener) {
        btnOcupar.addActionListener(listener);
    }

    public void addDesocuparMesaListener(ActionListener listener) {
        btnDesocupar.addActionListener(listener);
    }

    public void setNumeroAssentos(int numeroAssentos) {
        txtNumeroAssentos.setText(String.valueOf(numeroAssentos));
    }

    public void setDisponibilidade(boolean disponibilidade) {
        chkDisponibilidade.setSelected(disponibilidade);
    }
}
