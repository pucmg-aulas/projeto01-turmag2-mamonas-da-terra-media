package view;

import javax.swing.JButton;

public class MenuPrincipalView extends javax.swing.JFrame {

    public MenuPrincipalView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        btnAdicionarCliente = new javax.swing.JButton();
        btnCardapio = new javax.swing.JButton();
        btnFazerPedido = new javax.swing.JButton();
        btnPedirConta = new javax.swing.JButton();
        btnMesas = new javax.swing.JButton();
        btnMostrarFila = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setText("Menu Principal");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdicionarCliente.setText("Adicionar Cliente ");
        btnAdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarClienteActionPerformed(evt);
            }
        });

        btnCardapio.setText("Cardapio");
        btnCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardapioActionPerformed(evt);
            }
        });

        btnFazerPedido.setText("Fazer Pedido");
        btnFazerPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFazerPedidoActionPerformed(evt);
            }
        });

        btnPedirConta.setText("Pedir Conta");
        btnPedirConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedirContaActionPerformed(evt);
            }
        });

        btnMesas.setText("Mesas");

        btnMostrarFila.setText("Mostrar Fila");

        btnSair.setText("Sair");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("MENU PRINCIPAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionarCliente)
                    .addComponent(btnMesas)
                    .addComponent(btnMostrarFila))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCardapio)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnFazerPedido)
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPedirConta)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(btnSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCardapio)
                    .addComponent(btnAdicionarCliente))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMesas)
                    .addComponent(btnFazerPedido))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPedirConta)
                    .addComponent(btnMostrarFila))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarClienteActionPerformed

    private void btnCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardapioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCardapioActionPerformed

    private void btnFazerPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFazerPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFazerPedidoActionPerformed

    private void btnPedirContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedirContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPedirContaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarCliente;
    private javax.swing.JButton btnCardapio;
    private javax.swing.JButton btnFazerPedido;
    private javax.swing.JButton btnMesas;
    private javax.swing.JButton btnMostrarFila;
    private javax.swing.JButton btnPedirConta;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnMesas() {
        return btnMesas;
    }

    public JButton getBtnAdicionarCliente() {
        return btnAdicionarCliente;
    }

    public JButton getBtnCardapio() {
        return btnCardapio;
    }

    public JButton getBtnFazerPedido() {
        return btnFazerPedido;
    }

    public JButton getBtnMostrarFila() {
        return btnMostrarFila;
    }

    public JButton getBtnPedirConta() {
        return btnPedirConta;
    }

    public JButton getBtnSair() {
        return btnSair;
    }
}
