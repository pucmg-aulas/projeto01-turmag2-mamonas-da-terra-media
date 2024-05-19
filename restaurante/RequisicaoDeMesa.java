package restaurante;

import java.time.*;
import java.util.*;

public class RequisicaoDeMesa {
    
    private String nomeCliente;
    private int quantiaPessoas;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private Mesa mesaAtribuida;  
    private ArrayList<Pedido> pedidos = new ArrayList();
    private double conta;

    public RequisicaoDeMesa(String nomeCliente, int quantiaPessoas, LocalTime horaEntrada, Mesa mesa) {
        this.nomeCliente = nomeCliente;
        this.quantiaPessoas = quantiaPessoas;
        this.horaEntrada = horaEntrada;
        this.mesaAtribuida = mesa;
        this.conta = 0;
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

    public Mesa getMesaAtribuida() {
        return this.mesaAtribuida;
    }

    public void setMesaAtribuida(Mesa mesa) {
        this.mesaAtribuida = mesa;
    }
    
    public void fazerPedido(){
        Pedido pedido = new Pedido();
        pedido.fazerPedido();
        pedidos.add(pedido);
         for(int i=0; i<pedido.getPedido().size();i++){
            this.conta+= pedido.getValores(i);
        }
    }
    
    public double calculaConta(){
       
        return this.conta * 1.1;
    }
}
