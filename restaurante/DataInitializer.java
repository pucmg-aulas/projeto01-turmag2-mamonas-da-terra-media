package restaurante;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.util.ArrayList;

public class DataInitializer {

    public static void main(String[] args) {
        ArrayList<Mesa> mesas = new ArrayList<>();
        Menu menu = new Menu();
        ListaDeEspera listaDeEspera = new ListaDeEspera(mesas);

        
        mesas.add(new Mesa(4, true));
        mesas.add(new Mesa(6, true));
        mesas.add(new Mesa(8, true));

        menu.adicionarItem("Hamburguer", 10.0);
        menu.adicionarItem("Batata Frita", 5.0);
        menu.adicionarItem("Refrigerante", 3.0);

        RequisicaoDeMesa req1 = new RequisicaoDeMesa("Cliente1", 4, LocalTime.now(), mesas.get(0));
        RequisicaoDeMesa req2 = new RequisicaoDeMesa("Cliente2", 2, LocalTime.now(), mesas.get(1));
        listaDeEspera.adicionarNaLista(req1);
        listaDeEspera.adicionarNaLista(req2);

        
        try (ObjectOutputStream oosMesas = new ObjectOutputStream(new FileOutputStream("mesas.ser"));
             ObjectOutputStream oosMenu = new ObjectOutputStream(new FileOutputStream("menu.ser"));
             ObjectOutputStream oosListaDeEspera = new ObjectOutputStream(new FileOutputStream("listaDeEspera.ser"))) {

            oosMesas.writeObject(mesas);
            oosMenu.writeObject(menu);
            oosListaDeEspera.writeObject(listaDeEspera);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
