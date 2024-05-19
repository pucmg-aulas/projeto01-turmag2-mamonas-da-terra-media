package restaurante;
import java.util.*;


public class Menu {        
        
        ArrayList itens = new ArrayList();
        ArrayList<Double> preco = new ArrayList();
        
        public Menu(){
             itens.add("Moqueca De Tilapia");
             preco.add(1000.00);             
             itens.add("Falafel Assado");
             preco.add(1000.00);
             itens.add("Salada Primavera com Macarrão Konjac");
             preco.add(1000.00);
             itens.add("Escondidinho de frango");
             preco.add(1000.00);
             itens.add("Strogonoff");
             preco.add(1000.00);
             itens.add("Cacarola de Carne com Legumes");
             preco.add(1000.00);
             itens.add("Agua");
             preco.add(1000.00);
             itens.add("Suco");
             preco.add(1000.00);
             itens.add("Refrigerante");
             preco.add(1000.00);
             itens.add("Cerveja");
             preco.add(1000.00);
             itens.add("Taca de Vinho");
             preco.add(1000.00);
             String itens = "";
             for(int i=0; i<this.itens.size();i++){
             itens += this.itens.get(i) + ", ";
        }
             System.out.println(itens);
        }

        
        
    public static String imprimirMenu(){
        String menu = "";
        menu += "******************Comidas******************\n*1 - Moqueca de Tilapia                   *\n*2 - Falafel Assado                       *\n*3 - Salada Primavera com Macarrao Konjac *\n";
        menu += "*4 - Escondidinho de Frango               *\n*5 - Gostrognocoff                        *\n*6 - Cacarola de Carne com Legumes        *\n*******************************************";
        menu += "\n*******Bebidas*******\n*7 - Agua           *\n*8 - Suco           *\n";
        menu += "*9 - Refrigerante   *\n*10 - Cerveja       *\n*11 - Taca de Vinho *\n*********************";
        return menu;
    }
    
    
    public double getMoqueca(){
        return this.preco.get(1);
    }
    public double getFalafel(){
        return this.preco.get(2);
    }
    public double getSalada(){
        return this.preco.get(3);
    }
    public double getEscondidinho(){
        return this.preco.get(4);
    }
    public double getGostrognocoff(){
        return this.preco.get(5);
    }
    public double getCacarola(){
        return this.preco.get(6);
    }
    public double getAgua(){
        return this.preco.get(7);
    }
    public double getSuco(){
        return this.preco.get(8);
    }
    public double getRefrigerante(){
        return this.preco.get(9);
    }
    public double getCerveja(){
        return this.preco.get(10);
    }
    public double getTacaDeVinho(){
        return this.preco.get(11);
    }
}
    
   
