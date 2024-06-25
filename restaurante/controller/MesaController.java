package restaurante.controller;

import restaurante.model.Mesa;
import restaurante.view.MesaView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MesaController {

    private ArrayList<Mesa> mesas;
    private MesaView view;

    public MesaController(MesaView view) {
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mesas.ser"))) {
            mesas = (ArrayList<Mesa>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            mesas = new ArrayList<>();
        }
        this.view = view;
        if (!mesas.isEmpty()) {
            Mesa model = mesas.get(0);  
            this.view.setNumeroAssentos(model.getNumeroAssentos());
            this.view.setDisponibilidade(model.isDisponivel());
        }
    }
}
