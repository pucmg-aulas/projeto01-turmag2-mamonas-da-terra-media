/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package restaurante;
import java.util.ArrayList;
import java.time.LocalTime;
/**
 *
 * @author Pedro Morais
 */
public class Main {
    public static void main(String[] args) {
        
        LocalTime lo1;// = LocalTime.of(14,30);
        LocalTime lo2;// = LocalTime.of(17,30);
        ArrayList a = new ArrayList();
        ArrayList b = new ArrayList();
        ListaDeEspera le = new ListaDeEspera(a,b);
        RequisiçãoDeMesa jorge = new RequisiçãoDeMesa("Jorge",8,lo1 = LocalTime.of(14,30),lo2 = LocalTime.of(17,30));
        lo1 = LocalTime.of(17, 0); lo2 = LocalTime.of(20,10);
        RequisiçãoDeMesa tadeu = new RequisiçãoDeMesa("Tadeu",4,lo1,lo2);
        lo1 = LocalTime.of(06, 0); lo2 = LocalTime.of(07,56);
        RequisiçãoDeMesa mateus = new RequisiçãoDeMesa("Mateus",6,lo1,lo2);
        lo1 = LocalTime.of(20, 15); lo2 = LocalTime.of(22,30);
        RequisiçãoDeMesa joinha = new RequisiçãoDeMesa("Joinha",6,lo1,lo2);
        le.adicionaNaLista(jorge);
        le.adicionaNaLista(tadeu );
        le.adicionaNaLista(mateus);
        le.adicionaNaLista(joinha);
        System.out.println(le.imprimeLista());
        le.removeDaLista(mateus);
        System.out.println(le.imprimeLista());
    }
    
}
