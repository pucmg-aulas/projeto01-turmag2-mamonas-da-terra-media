package restaurante.main;

import restaurante.model.*;
import restaurante.view.*;
import restaurante.controller.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Mesa> mesasDisponiveis = new ArrayList<>();
        mesasDisponiveis.add(new Mesa(4, true));
        mesasDisponiveis.add(new Mesa(6, true));
        mesasDisponiveis.add(new Mesa(8, true));

        ListaDeEspera listaModel = new ListaDeEspera(mesasDisponiveis);
        ListaDeEsperaView listaView = new ListaDeEsperaView();
        ListaDeEsperaController listaController = new ListaDeEsperaController(listaModel, listaView);

        Pedido pedidoModel = new Pedido();
        PedidoView pedidoView = new PedidoView();
        PedidoController pedidoController = new PedidoController(pedidoModel, pedidoView);

        RequisicaoDeMesaController controller = new RequisicaoDeMesaController();
        RequisicaoDeMesaView requisicaoDeMesaView = new RequisicaoDeMesaView(controller);

        Mesa mesaModel = new Mesa(4, true);
        MesaView mesaView = new MesaView();
        MesaController mesaController1 = new MesaController(mesaModel, mesaView);

    }
}
