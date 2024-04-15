/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

import java.time.LocalTime;

public class RequisiçãoDeMesa {
    
    private String nomeCliente;
    private int quantiaPessoas;
    private LocalTime dataEntrada;
    private LocalTime dataSaida;
    
    
    public RequisiçãoDeMesa(String nomeCliente, int quantiaPessoas, LocalTime dataEntrada, LocalTime dataSaida){
        this.nomeCliente = nomeCliente; this.quantiaPessoas = quantiaPessoas;
        this.dataEntrada = dataEntrada; this.dataSaida = dataSaida;
        
    }
    
    public String getNomeCliente(){
        return this.nomeCliente;
    }
    public int getQuantiaPessoas(){
        return this.quantiaPessoas;
    }
    
    
}
