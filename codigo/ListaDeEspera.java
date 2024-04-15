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
        if (requisicao == null) {
            throw new IllegalArgumentException("não pode ser vazio");
        }
        this.listaRequisicao.add(requisicao);
    }
    
    public void removeDaLista(RequisicaoDeMesa requisicao){
        this.listaRequisicao.remove(requisicao);
    }

    public void removeDaListaPorNome(String nomeCliente) {
        
    listaRequisicao.removeIf(requisicao -> requisicao.getNomeCliente().equals(nomeCliente));
    }
    
    public String imprimeLista(){
        String rtrn = "";
        for (int i = 0; i < listaRequisicao.size(); i++) {
            rtrn += "Cliente: "+listaRequisicao.get(i).getNomeCliente() +", "+listaRequisicao.get(i).getQuantiaPessoas() + "\n";
        }
        return rtrn;
    }
}
