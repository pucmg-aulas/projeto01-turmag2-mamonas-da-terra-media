package controller;

import view.ListaDeEsperaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import restaurante.ItemMenu;
import restaurante.ListaDeEspera;
import restaurante.Mesa;
import restaurante.Pedido;
import restaurante.RequisicaoDeMesa;

public class ListaDeEsperaController {

    private ListaDeEspera model;
    private ListaDeEsperaView view;

    public ListaDeEsperaController() {
        this.model = new ListaDeEspera(new ArrayList<Mesa>());
        this.view = new ListaDeEsperaView();

        carregaTabela();
        
        this.view.setVisible(true);

    }
    
    public void carregaTabela(){
        
        ArrayList<Mesa> mesas = new ArrayList<Mesa>(); 
        mesas.add(new Mesa(4, true));  
        mesas.add(new Mesa(6, true));  
        mesas.add(new Mesa(8, true));   
        ListaDeEspera le = new ListaDeEspera(mesas);
        Object colunas[] = {"Nome", "Cadeiras"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);
        tm.setNumRows(0);
        Iterator<RequisicaoDeMesa> listaDeEspera = le.getListaRequisicao().iterator();
        while (listaDeEspera.hasNext()) {
        RequisicaoDeMesa rm = listaDeEspera.next();
        String item = rm.getNomeCliente()+ " - " + rm.getQuantiaPessoas();
        String linha[] = item.split("%");
        tm.addRow(new Object[]{linha[0], linha[1]});
        }
        view.getListaDeEspera().setModel((ListModel<String>) tm);
    }
}
