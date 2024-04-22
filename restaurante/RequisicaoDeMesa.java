package restaurante;

import java.time.*;

public class RequisicaoDeMesa {
    
    private String nomeCliente;
    private int quantiaPessoas;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    
    public RequisicaoDeMesa(String nomeCliente, int quantiaPessoas, LocalTime horaEntrada) {
        this.nomeCliente = nomeCliente;
        this.quantiaPessoas = quantiaPessoas;
        this.horaEntrada = horaEntrada;
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
}
