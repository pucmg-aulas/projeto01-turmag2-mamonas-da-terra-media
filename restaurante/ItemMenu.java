package restaurante;

import java.io.Serializable;

import restaurante.exception.PrecoInvalidoException;

public class ItemMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private double preco;

    public ItemMenu(String nome, double preco) throws PrecoInvalidoException {
        if (preco < 0) {
            throw new PrecoInvalidoException("Preço do item não pode ser negativo.");
        }
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
