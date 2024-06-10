package restaurante.controller;

import restaurante.model.ListaDeEspera;
import restaurante.model.RequisicaoDeMesa;
import restaurante.model.Mesa;
import restaurante.view.ListaDeEsperaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class ListaDeEsperaController {
    private ListaDeEspera model;
    private ListaDeEsperaView view;

    public ListaDeEsperaController(ListaDeEspera model, ListaDeEsperaView view) {
        this.model = model;
        this.view = view;

        this.view.addAdicionarButtonListener(new AdicionarListener());
        this.view.addRemoverButtonListener(new RemoverListener());
        this.view.addImprimirListaButtonListener(new ImprimirListaListener());
    }

    class AdicionarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nomeCliente = view.getNomeCliente();
            int quantiaPessoas = view.getQuantiaPessoas();
            RequisicaoDeMesa requisicao = new RequisicaoDeMesa(nomeCliente, quantiaPessoas, LocalTime.now(), new Mesa(4, true));
            model.adicionarNaLista(requisicao);
        }
    }

    class RemoverListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nomeCliente = view.getNomeCliente();
            model.removerDaListaPorNome(nomeCliente);
        }
    }

    class ImprimirListaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String lista = model.imprimirLista();
            view.setListaText(lista);
        }
    }
}
