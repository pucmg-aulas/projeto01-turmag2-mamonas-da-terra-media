
import java.util.*;
import java.time.LocalTime;

public class Main {
  public static void main(String[] args) {

    ArrayList<RequisicaoDeMesa> a = new ArrayList<>();
    ListaDeEspera le = new ListaDeEspera(a);

    LocalTime lo1;// = LocalTime.of(14,30);
    LocalTime lo2;// = LocalTime.of(17,30);
    RequisicaoDeMesa jorge = new RequisicaoDeMesa("Jorge", 8, lo1 = LocalTime.of(14, 30), lo2 = LocalTime.of(17, 30));
    lo1 = LocalTime.of(17, 0);
    lo2 = LocalTime.of(20, 10);
    RequisicaoDeMesa tadeu = new RequisicaoDeMesa("Tadeu", 4, lo1, lo2);
    lo1 = LocalTime.of(06, 0);
    lo2 = LocalTime.of(07, 56);
    RequisicaoDeMesa mateus = new RequisicaoDeMesa("Mateus", 6, lo1, lo2);
    lo1 = LocalTime.of(20, 15);
    lo2 = LocalTime.of(22, 30);
    RequisicaoDeMesa joinha = new RequisicaoDeMesa("Joinha", 6, lo1, lo2);
    le.adicionaNaLista(jorge);
    le.adicionaNaLista(tadeu);
    le.adicionaNaLista(mateus);
    le.adicionaNaLista(joinha);
    System.out.println(le.imprimeLista());
    le.removeDaLista(mateus);
    System.out.println(le.imprimeLista());
  

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
