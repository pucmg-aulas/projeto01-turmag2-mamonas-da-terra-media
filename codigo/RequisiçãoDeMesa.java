/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

import java.time.LocalDateTime;

public class RequisiçãoDeMesa {
    
    String nomeCliete;
    int quantiaPessoas;
    LocalDateTime dataEntrada;
    LocalDateTime dataSaida;
    
    
    public RequisiçãoDeMesa(String nomeCliente, int quantiaPessoas, LocalDateTime dataEntrada, LocalDateTime dataSaida){
        this.nomeCliete = nomeCliente; this.quantiaPessoas = quantiaPessoas;
        this.dataEntrada = dataEntrada; this.dataSaida = dataSaida;
        
    }
    
    
}
