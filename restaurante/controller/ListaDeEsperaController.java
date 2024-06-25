package controller;

import view.ListaDeEsperaView;
import restaurante.ListaDeEspera;
import restaurante.RequisicaoDeMesa;
import restaurante.Mesa;
import view.ListaDeEsperaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

public class ListaDeEsperaController {

    private ListaDeEspera model;
    private ListaDeEsperaView view;

    public ListaDeEsperaController() {
        this.model = new ListaDeEspera(new ArrayList<Mesa>());
        this.view = new ListaDeEsperaView();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("listaDeEspera.ser"))) {
            model = (ListaDeEspera) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            model = new ListaDeEspera(new ArrayList<>());
        }
        this.view.getBtnAdicionar().addActionListener(new AdicionarListener());
        this.view.getBtnRemover().addActionListener(new RemoverListener());
        this.view.getBtnVoltar().addActionListener((e) -> {
            new MenuPrincipalController();
            this.view.dispose();
        });
        
        carregaLista();
        this.view.setVisible(true);
    }

    class AdicionarListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String nomeCliente = view.getNomeCliente().getText();
            String quantiaPessoas = view.getQuantiaPessoas().getText();
            RequisicaoDeMesa requisicao = new RequisicaoDeMesa(nomeCliente, Integer.valueOf(quantiaPessoas), LocalTime.now(), new Mesa(4, true));
            model.adicionarNaLista(requisicao);
            carregaLista();
            
        }
    }

    class RemoverListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String nomeCliente = view.getNomeCliente().getText();
            model.removerDaListaPorNome(nomeCliente);
            carregaLista();
        }
    }

        public void carregaLista() {
            DefaultListModel lm = new DefaultListModel();
            Iterator<RequisicaoDeMesa> listaDeEspera = model.getListaRequisicao().iterator();
            while (listaDeEspera.hasNext()) {
                RequisicaoDeMesa rm = listaDeEspera.next();
                String item = rm.getNomeCliente() + " - " + rm.getQuantiaPessoas();
                lm.addElement(item);
            }
            view.getListaDeEspera().setModel(lm);
        
    }
}
