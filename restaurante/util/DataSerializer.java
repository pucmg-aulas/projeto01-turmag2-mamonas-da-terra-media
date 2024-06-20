package restaurante.util;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import restaurante.model.*;

public class DataSerializer {

    public static void serialize(Object object, String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(object);
        }
    }

    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return in.readObject();
        }
    }

    public static void main(String[] args) {
        // Dados fake para inicialização
        ArrayList<Mesa> mesas = new ArrayList<>();
        mesas.add(new Mesa(4, true));
        mesas.add(new Mesa(2, true));
        mesas.add(new Mesa(6, false));

        Menu menu = new Menu();
        menu.adicionarItem("Pasta", 12.99);
        menu.adicionarItem("Pizza", 15.99);
        menu.adicionarItem("Salad", 8.99);

        ListaDeEspera listaDeEspera = new ListaDeEspera(mesas);
        listaDeEspera.adicionarNaLista(new RequisicaoDeMesa("Cliente 1", 4, LocalTime.now(), mesas.get(0)));
        listaDeEspera.adicionarNaLista(new RequisicaoDeMesa("Cliente 2", 2, LocalTime.now(), mesas.get(1)));

        try {
            serialize(mesas, "mesas.ser");
            serialize(menu, "menu.ser");
            serialize(listaDeEspera, "listaDeEspera.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
