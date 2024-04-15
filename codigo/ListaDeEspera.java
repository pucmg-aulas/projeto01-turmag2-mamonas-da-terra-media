/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

import java.util.ArrayList;

public class ListaDeEspera {
    
    private ArrayList listaNomes;
    private ArrayList listaMesas;
    
    
    public ListaDeEspera( ArrayList nomes, ArrayList mesas){
        this.listaNomes = nomes; 
        this.listaMesas = mesas;
        
    }
    
    public void adicionaNaLista(RequisiçãoDeMesa rm){
        this.listaNomes.add(rm.getNomeCliente());
        this.listaMesas.add(rm.getQuantiaPessoas());
    }
    
    public void removeDaLista(RequisiçãoDeMesa rm){
        for (int i=0; i<this.listaNomes.size(); i++) {
            if (rm.getNomeCliente().equals(this.listaNomes.get(i))){
                this.listaNomes.remove(i);
                this.listaMesas.remove(i);
            }
        }
    }
    
    public String imprimeLista(){
        String rtrn = "";
        for (int i = 0; i < listaNomes.size(); i++) {
            rtrn += "Cliente: "+listaNomes.get(i)+ ", "+ listaMesas.get(i)+"\n";
        }
        return rtrn;
    }
}
