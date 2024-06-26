/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import restaurante.IPagavel;
import restaurante.Mesa;
import restaurante.Pagamentos;
import view.PagamentosView;

/**
 *
 * @author Pedro Morais
 */
public class MostraPagamentosController {
    
    private PagamentosView view;
    private Pagamentos pagamentos;
    private double totalGanho;

    public MostraPagamentosController() {
        this.view = new PagamentosView();
        this.totalGanho=0;
        this.pagamentos = Pagamentos.getInstance();
        this.view.getBtnSair().addActionListener((e) -> {
            sair();
        });
        
        carregaPagamentos();
    }
    
    public void carregaPagamentos(){
        DefaultListModel lm = new DefaultListModel();
        Iterator<IPagavel> itens = pagamentos.getPagamentos().iterator();
        int count = 1;
        while (itens.hasNext()) {
            IPagavel i = itens.next();
            String item = "Tipo: " + i.getClass() + " - R$" + String.format("%.02f", i.pagar()) ;
            this.totalGanho += i.pagar();
            lm.addElement(item);
            count++;
        }
        view.getListaPagamentos().setModel(lm);
        
        JLabel label = new JLabel();
        label.setText("R$:" + String.format("%.02f", totalGanho));
        view.setTxtTotalGanho(label);
    }
    public void sair(){
        this.view.dispose();
    }
    
}
