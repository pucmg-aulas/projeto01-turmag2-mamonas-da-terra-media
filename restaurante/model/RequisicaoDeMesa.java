package restaurante.model;

import java.io.Serializable;
import java.time.LocalTime;

public class RequisicaoDeMesa implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nomeCliente;
    private int quantiaPessoas;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private Mesa mesaAtribuida;
    private Pedido pedido;
    private double conta;

    public RequisicaoDeMesa(String nomeCliente, int quantiaPessoas, LocalTime horaEntrada, Mesa mesa) {
        this.nomeCliente = nomeCliente;
        this.quantiaPessoas = quantiaPessoas;
        this.horaEntrada = horaEntrada;
        this.mesaAtribuida = mesa;
        this.pedido = new Pedido();
        this.conta = 0;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getQuantiaPessoas() {
        return quantiaPessoas;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Mesa getMesaAtribuida() {
        return mesaAtribuida;
    }

    public void setMesaAtribuida(Mesa mesa) {
        this.mesaAtribuida = mesa;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public double calculaConta() {
        return pedido.calcularTotal();
    }
}
