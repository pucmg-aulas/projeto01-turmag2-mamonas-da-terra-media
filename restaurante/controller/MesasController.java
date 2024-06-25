/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import restaurante.Mesa;
import view.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import restaurante.ItemMenu;

public class MesasController {

    private ArrayList<Mesa> mesas;
    private MesaView view;

    public MesasController() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mesas.ser"))) {
            mesas = (ArrayList<Mesa>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            mesas = new ArrayList<>();
        }
        this.view = new MesaView();
        /*if (!mesas.isEmpty()) {
            Mesa model = mesas.get(0);
            this.view.setNumeroAssentos(model.getNumeroAssentos());
            this.view.setDisponibilidade(model.isDisponivel());
        }*/
        
        carregarMesas();
        this.view.getBtnSalvar().addActionListener((e) -> {
            AdicionarMesa();
        });
        this.view.setVisible(true);

    }

    public void carregarMesas() {
        
        
        DefaultListModel lm = new DefaultListModel();
        Iterator<Mesa> itens = mesas.iterator();
        int count = 1;
        while (itens.hasNext()) {
            Mesa i = itens.next();
            String item = "Mesa " + count + " - " + i.getNumeroAssentos() + " Cadeiras" + " - " + i.isDisponivel();
            lm.addElement(item);
            count++;
        }
        view.getListaMesas().setModel(lm);

    }
    
    public void AdicionarMesa(){
        int numeroAscentos = Integer.valueOf(this.view.getNumeroAscentos().getText());
        Mesa mesa = new Mesa(numeroAscentos, true);
        this.mesas.add(mesa);
        carregarMesas();
    }
}
