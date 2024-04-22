package restaurante;
import java.util.*;

public class Mesas{

  private int numeroAssentos;
  private boolean estaDisponivel;

  public Mesas(int numeroAssentos, boolean estaDisponivel) { // adiciona uma mesa recebendo um parametro de assentos por fora.
    if (numeroAssentos < 1) {
      throw new IllegalArgumentException("A mesa deve ter no mínimo um assento, se não, não é uma mesa");
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
