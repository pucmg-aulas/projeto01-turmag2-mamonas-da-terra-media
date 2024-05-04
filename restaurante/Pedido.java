
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;
import java.util.*;

public class Pedido extends Menu {
    
    double valorPedido = 0;
    String pedido = "";
    
    public Pedido(){}
     
    public void fazerPedido(){
        
        Scanner ler = new Scanner(System.in);
        System.out.println(imprimeMenuComida());
        System.out.println(imprimeMenuBebida());
        System.out.println("Aperte 0 para encerrar!");
        System.out.println("Numeros do Pedido: ");
        int x = ler.nextInt();
        while(x != 0){
            if(x == 1){
                this.valorPedido += MOQUECA_DE_TILAPIA;
                this.pedido += "Moqueca De Tilapia, ";              
            }
            if(x == 2){
                this.valorPedido += FALAFEL_ASSADO;
                this.pedido += "Falafel Assado, ";              
            }
            if(x == 3){
                this.valorPedido += SALADA_PRIMAVERA_COM_MACARRAO;
                this.pedido += "Salada Primavera com Macarrão Konjac, ";              
            }
            if(x == 4){
                this.valorPedido += ESCONDIDINHO_DE_FRANGO;
                this.pedido += "Escondidinho de Frango, ";              
            }
            if(x == 5){
                this.valorPedido += STROGONOFF;
                this.pedido += "Strogonoff, ";              
            }
            if(x == 6){
                this.valorPedido += CACAROLA_DE_CARNE_COM_LEGUMES;
                this.pedido += "Cacarola de Carne com Legumes, ";              
            }
            if(x == 7){
                this.valorPedido += AGUA;
                this.pedido += "Agua, ";              
            }
            if(x == 8){
                this.valorPedido += SUCO;
                this.pedido += "Suco, ";              
            }
            if(x == 9){
                this.valorPedido += REFRIGERANTE;
                this.pedido += "Refrigerante, ";              
            }
            if(x == 10){
                this.valorPedido += CERVEJA;
                this.pedido += "Cerveja, ";              
            }
            if(x == 11){
                this.valorPedido += VINHO;
                this.pedido += "Taca de Vinho, ";              
            }
            x = ler.nextInt();
        }
    }
    
    public String imprimePedido(){
        return this.pedido;
    }
}
