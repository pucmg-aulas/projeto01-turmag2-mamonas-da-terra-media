/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

import java.util.ArrayList;
public class Pagamentos {
    
    private ArrayList<IPagavel> pagamentos;
    private static Pagamentos instance;

    private Pagamentos() {
    }
    
    public static Pagamentos getInstance(){
        if (instance == null){
            instance = new Pagamentos();
        }
        return instance;
    }
    
    public void addPagamentos(IPagavel e){
        instance.pagamentos.add(e);
    }
    public ArrayList<IPagavel> getPagamentos(){
        return this.pagamentos;
    }
            
    
}
