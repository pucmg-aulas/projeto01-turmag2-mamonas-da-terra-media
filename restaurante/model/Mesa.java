package restaurante.model;

import java.io.Serializable;

public class Mesa implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numeroAssentos;
    private boolean estaDisponivel;

    public Mesa(int numeroAssentos, boolean estaDisponivel) {
        if (numeroAssentos < 1) {
            throw new IllegalArgumentException("Mesa tem que ter no mínimo 1 assento");
        }
        this.numeroAssentos = numeroAssentos;
        this.estaDisponivel = estaDisponivel;
    }

    public int getNumeroAssentos() {
        return this.numeroAssentos;
    }

    public boolean isDisponivel() {
        return this.estaDisponivel;
    }

    public void ocuparMesa() {
        this.estaDisponivel = false;
    }

    public void desocuparMesa() {
        this.estaDisponivel = true;
    }
}
