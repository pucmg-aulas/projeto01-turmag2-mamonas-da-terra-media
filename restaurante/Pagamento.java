/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante;

import java.util.ArrayList;

public abstract class Pagamento implements IPagavel {
    
     double valor;
     double desconto;
     int prazo;
     ArrayList <IPagavel> pagamentos;

    public Pagamento(double pagamento) {
        this.valor = pagamento;
    }
    
    @Override
    public double pagar() {
        return this.valor;
    }
    
    
}
