package restaurante.model;

import javax.swing.*;

public class ItemMenu {
    private String nome;
    private double preco;
    private JFormattedTextField menuFormattedTextField;

    public ItemMenu(String nome, double preco) {

        this.nome = nome;
        this.preco = preco;

    }

    public String getNome() {

        return nome;
    }

    public double getPreco() {

        return preco;
    }

    @Override
    public String toString() {

        return nome + " - R$ " + preco;
    }
}
