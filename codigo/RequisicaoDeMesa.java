/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

import java.time.LocalTime;
import java.util.*;

public class RequisicaoDeMesa {
    
    private String nomeCliente;
    private int quantiaPessoas;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    
    
    public RequisicaoDeMesa(String nomeCliente, int quantiaPessoas, LocalTime horaEntrada, LocalTime horaSaida){
        this.nomeCliente = nomeCliente; this.quantiaPessoas = quantiaPessoas;
        this.horaEntrada = horaEntrada; this.horaSaida = horaSaida;
        
    }
    
    public String getNomeCliente(){
        return this.nomeCliente;
    }
    public int getQuantiaPessoas(){
        return this.quantiaPessoas;
    }
    
    
}
