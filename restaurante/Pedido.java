package restaurante;

import java.util.*;

public class Pedido{
    
    ArrayList itens = new ArrayList();
    ArrayList<Double> valores = new ArrayList<>();
    
    public Pedido(){}
     
    public void fazerPedido(){
        
        Menu cardapio = new Menu();
        Scanner ler = new Scanner(System.in);
        System.out.println(cardapio.imprimirMenu());
        System.out.println("Aperte 0 para encerrar!");
        System.out.println("Numeros do Pedido: ");
        int x = ler.nextInt();
        while(x != 0){
            if(x == 1){
                itens.add("Moqueca De Tilapia");
                valores.add(cardapio.getMoqueca());
                x = ler.nextInt();
            }
            if(x == 2){
                itens.add("Falafel Assado");
                valores.add(cardapio.getFalafel());
                x = ler.nextInt();
                
            }
            if(x == 3){
                itens.add("Salada Primavera com Macarrao Konjac");
                valores.add(cardapio.getSalada());
                x = ler.nextInt();
            }
            if(x == 4){
                itens.add("Escondidinho de Frango");
                valores.add(cardapio.getEscondidinho());
                x = ler.nextInt();
            }
            if(x == 5){
                itens.add("Strogonoff");
                valores.add(cardapio.getGostrognocoff());
                x = ler.nextInt();
            }
            if(x == 6){
                itens.add("Cacarola de Carne com Legumes");
                valores.add(cardapio.getCacarola());
                x = ler.nextInt();
            }
            if(x == 7){
                itens.add("Agua");
                valores.add(cardapio.getAgua());
                x = ler.nextInt();
                
            }
            if(x == 8){
                itens.add("Suco");
                valores.add(cardapio.getSuco());
                x = ler.nextInt();
            }
            if(x == 9){
                itens.add("Refrigerante");
                valores.add(cardapio.getRefrigerante());
                x = ler.nextInt();
            }
            if(x == 10){
                itens.add("Cerveja");
                valores.add(cardapio.getCerveja());
                x = ler.nextInt();
            }
            if(x == 11){
                itens.add("Taca De Vinho");
                valores.add(cardapio.getTacaDeVinho());
                x = ler.nextInt();
            }       
        }
    }
    
    public ArrayList getPedido(){
        return this.itens;
    }
    
    public double getValores(int i){
        return this.valores.get(i);
    }
    public String imprimirPedido(){
        String itens = "";
        for(int i = 0; i<this.itens.size(); i++){
            itens += this.itens.get(i) + ", ";
        }
        return itens;
    }
}
