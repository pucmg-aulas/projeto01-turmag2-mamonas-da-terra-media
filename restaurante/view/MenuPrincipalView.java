
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
        btnRemoverCliente = new javax.swing.JButton();
        btnMostrarFila = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setText("Menu Principal");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

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

        btnRemoverCliente.setText("Remover Cliente da Fila");

        btnMostrarFila.setText("Mostrar Fila");

        btnSair.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdicionarCliente)
                            .addComponent(btnRemoverCliente)
                            .addComponent(btnMostrarFila))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCardapio)
                            .addComponent(btnPedirConta)
                            .addComponent(btnFazerPedido)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(btnSair)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCardapio)
                    .addComponent(btnAdicionarCliente))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoverCliente)
                    .addComponent(btnFazerPedido))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPedirConta)
                    .addComponent(btnMostrarFila))
                .addGap(18, 18, 18)
                .addComponent(btnSair)
                .addContainerGap(7, Short.MAX_VALUE))
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
    private javax.swing.JButton btnMostrarFila;
    private javax.swing.JButton btnPedirConta;
    private javax.swing.JButton btnRemoverCliente;
    private javax.swing.JButton btnSair;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnRemoverCliente() {
        return btnRemoverCliente;
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
