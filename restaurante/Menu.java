package restaurante;


public abstract class Menu {
    
        
        final double MOQUECA_DE_TILAPIA = 600;
        final double FALAFEL_ASSADO = 500;
        final double SALADA_PRIMAVERA_COM_MACARRAO = 1000;
        final double ESCONDIDINHO_DE_FRANGO = 400;
        final double STROGONOFF = 300;
        final double CACAROLA_DE_CARNE_COM_LEGUMES = 1300;
        final double AGUA = 20;
        final double SUCO = 50;
        final double REFRIGERANTE = 40;
        final double CERVEJA = 100;
        final double VINHO = 300;
        
    
    public String imprimeMenuComida(){
        String menu = "";
        menu += "******Comidas******\n *1 - Moqueca de Tilapia *\n*2- Falafel Assado *\n*3 - Salada Primavera com Macarrão Konjac*\n";
        menu += "*4 - Escondidinho de Frango *\n*5 - Strogonoff *\n*6 - Caçarola de Carne com Legumes*";
        return menu;
    }
    
    public String imprimeMenuBebida(){
        String menu = "";
        menu += "******Bebidas******\n *7 - Agua *\n*8- Suco *\n";
        menu += "*9 - Refrigerante *\n*10 - Cerveja *\n*11 - Taça de Vinho*";
        return menu;
    }
    
    
}

