package restaurante;

import java.time.*;

public class RequisicaoDeMesa {
    
    private String nomeCliente;
    private int quantiaPessoas;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private Mesas mesaAtribuida;  

    public RequisicaoDeMesa(String nomeCliente, int quantiaPessoas, LocalTime horaEntrada, Mesas mesa) {
        this.nomeCliente = nomeCliente;
        this.quantiaPessoas = quantiaPessoas;
        this.horaEntrada = horaEntrada;
        this.mesaAtribuida = mesa;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public int getQuantiaPessoas() {
        return this.quantiaPessoas;
    }

    public LocalTime getHoraEntrada() {
        return this.horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return this.horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Mesas getMesaAtribuida() {
        return this.mesaAtribuida;
    }

    public void setMesaAtribuida(Mesas mesa) {
        this.mesaAtribuida = mesa;
    }
}
