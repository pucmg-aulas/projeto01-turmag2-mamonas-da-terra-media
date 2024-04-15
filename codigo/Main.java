
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
  

    Mesa m1 = new Mesa(4, false);
    System.out.println(m1.getNumeroAssentos());
    System.out.println(m1.getEstaDisponivel());
    Mesa m2 = new Mesa(6, true);
    System.out.println(m2.getNumeroAssentos());
    System.out.println(m2.getEstaDisponivel());
    Mesa m3 = new Mesa(8, false);
    System.out.println(m3.getNumeroAssentos());
    System.out.println(m3.getEstaDisponivel());
  }

  

}
