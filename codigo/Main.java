
import java.util.*;
import java.time.LocalTime;

public class Main {
  public static void main(String[] args) {

    ArrayList<RequisicaoDeMesa> a = new ArrayList<>();
    ListaDeEspera le = new ListaDeEspera(a);

    le.adicionaNaLista(new RequisicaoDeMesa("Jorge", 8, LocalTime.of(14, 30), LocalTime.of(17, 30)));
    le.adicionaNaLista(new RequisicaoDeMesa("Tadeu", 4, LocalTime.of(17, 0), LocalTime.of(20, 10)));
    le.adicionaNaLista(new RequisicaoDeMesa("Mateus", 6, LocalTime.of(6, 0), LocalTime.of(7, 56)));
    le.adicionaNaLista(new RequisicaoDeMesa("Joinha", 6, LocalTime.of(20, 15), LocalTime.of(22, 30)));


    System.out.println("antes de remover: " + le.imprimeLista());
    le.removeDaListaPorNome("Mateus");
    System.out.println("depois de remover: " + le.imprimeLista());

  
    Mesa m1 = new Mesa(4, false);
    System.out.println("Mesa 1 - Assentos: " + m1.getNumeroAssentos() + ", Disponível: " + (m1.isDisponivel()));
    Mesa m2 = new Mesa(6, true);
    System.out.println("Mesa 2 - Assentos: " + m2.getNumeroAssentos() + ", Disponível: " + (m2.isDisponivel()));
    Mesa m3 = new Mesa(8, false);
    System.out.println("Mesa 3 - Assentos: " + m3.getNumeroAssentos() + ", Disponível: " + (m3.isDisponivel()));
  }

}
