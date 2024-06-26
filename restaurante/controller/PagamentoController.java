/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JTextField;
import restaurante.*;
import view.PagamentoView;

/**
 *
 * @author Pedro Morais
 */
public class PagamentoController {

    private IPagavel model;
    private PagamentoView view;
    private double valorConta;

    public PagamentoController(double valorConta) {
        this.view = new PagamentoView();
        this.valorConta = valorConta;

        this.view.getBtnConcluir().addActionListener((e) -> {
            encerrar();
        });
        this.view.getBtnVoltar().addActionListener((e) -> {
            voltar();
        });
        this.view.getSelecaoPagamento().addActionListener((e) -> {
            escolhePagamento();

        });
        this.view.setVisible(true);
    }

    public void escolhePagamento() {
        String tipo = (String) view.getSelecaoPagamento().getSelectedItem();

        switch (tipo) {
            case "Pix":
                this.model = new PagamentoPix(valorConta);
                calculaPagamento(this.model.pagar());
                break;

            case "Dinheiro":
                this.model = new PagamentoDinheiro(valorConta);
                calculaPagamento(this.model.pagar());
                break;

            case "Credito":
                this.model = new PagamentoCredito(valorConta);
                calculaPagamento(this.model.pagar());
                break;

            case "Debito":
                this.model = (IPagavel) new PagamentoDebito(valorConta);
                calculaPagamento(this.model.pagar());
                break;

        }
    }

    public void calculaPagamento(double valor) {
        String txtTotalConta = "R$:" + String.format("%.02f", valor);
        this.view.getTxtTotal().setText(txtTotalConta);
    }

    public void encerrar() {
        this.view.dispose();
    }

    public void voltar() {
        this.view.dispose();
        new ContaController();
    }

}
