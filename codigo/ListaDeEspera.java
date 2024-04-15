/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

import java.util.*;

public class ListaDeEspera {
    
    private ArrayList<RequisicaoDeMesa> listaRequisicao;
        
    public ListaDeEspera( ArrayList listaRequisicao){
        this.listaRequisicao = listaRequisicao;         
    }
    
    public void adicionaNaLista(RequisicaoDeMesa requisicao){
        this.listaRequisicao.add(requisicao);
    }
    
    public void removeDaLista(RequisicaoDeMesa requisicao){
        for (int i=0; i<this.listaRequisicao.size(); i++) {
            if (requisicao.equals(this.listaRequisicao.get(i))){
                this.listaRequisicao.remove(i);
            }
        }
    }
    
    public String imprimeLista(){
        String rtrn = "";
        for (int i = 0; i < listaRequisicao.size(); i++) {
            rtrn += "Cliente: "+listaRequisicao.get(i).getNomeCliente() +", "+listaRequisicao.get(i).getQuantiaPessoas() + "\n";
        }
        return rtrn;
    }
}
