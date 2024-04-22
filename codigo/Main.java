package restaurante;

import java.util.*;
import java.time.LocalTime;

/*
criar metodo para colocar o horario de saida do cliente na requisicao de mesa
*/


public class Main {
  public static void main(String[] args) {

    ListaDeEspera le = new ListaDeEspera();

    le.adicionaNaLista(new RequisicaoDeMesa("Jorge", 8, LocalTime.of(14, 30)));
    le.adicionaNaLista(new RequisicaoDeMesa("Tadeu", 4, LocalTime.of(17, 0)));
    le.adicionaNaLista(new RequisicaoDeMesa("Mateus", 6, LocalTime.of(6, 0)));
    le.adicionaNaLista(new RequisicaoDeMesa("Joinha", 6, LocalTime.of(20, 15)));
    

    System.out.println("Antes de remover: \n" + le.imprimeLista());
    le.removeDaListaPorNome("Mateus");
    System.out.println("depois de remover: \n" + le.imprimeLista());

  
    Mesas m1 = new Mesas(4, false);
    System.out.println("Mesa 1 - Assentos: " + m1.getNumeroAssentos() + ", Disponível: " + (m1.isDisponivel()));
    Mesas m2 = new Mesas(6, true);
    System.out.println("Mesa 2 - Assentos: " + m2.getNumeroAssentos() + ", Disponível: " + (m2.isDisponivel()));
    Mesas m3 = new Mesas(8, false);
    System.out.println("Mesa 3 - Assentos: " + m3.getNumeroAssentos() + ", Disponível: " + (m3.isDisponivel()));
    
    
    System.out.println(le.imprimeHistorico());
  }

}
