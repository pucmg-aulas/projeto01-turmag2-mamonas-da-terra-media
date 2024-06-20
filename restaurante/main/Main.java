package restaurante.main;

import java.io.IOException;
import java.util.ArrayList;
import restaurante.controller.*;
import restaurante.model.*;
import restaurante.util.DataSerializer;
import restaurante.view.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Mesa> mesasDisponiveis;
        Menu menu;
        ListaDeEspera listaModel;

        try {
            mesasDisponiveis = (ArrayList<Mesa>) DataSerializer.deserialize("mesas.ser");
            menu = (Menu) DataSerializer.deserialize("menu.ser");
            listaModel = (ListaDeEspera) DataSerializer.deserialize("listaDeEspera.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            mesasDisponiveis = new ArrayList<>();
            mesasDisponiveis.add(new Mesa(4, true));
            mesasDisponiveis.add(new Mesa(6, true));
            mesasDisponiveis.add(new Mesa(8, true));

            menu = new Menu();
            listaModel = new ListaDeEspera(mesasDisponiveis);
        }

        ListaDeEsperaView listaView = new ListaDeEsperaView();
        ListaDeEsperaController listaController = new ListaDeEsperaController(listaView);

        Pedido pedidoModel = new Pedido();
        PedidoView pedidoView = new PedidoView();
        PedidoController pedidoController = new PedidoController(pedidoModel, pedidoView);

        RequisicaoDeMesaController requisicaoDeMesaController = new RequisicaoDeMesaController();
        RequisicaoDeMesaView requisicaoDeMesaView = new RequisicaoDeMesaView(requisicaoDeMesaController);

        MesaView mesaView = new MesaView();
        MesaController mesaController = new MesaController(mesaView);

        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView);

    }
}
