package restaurante.controller;

import restaurante.model.Mesa;
import restaurante.view.MesaView;
import restaurante.util.DataSerializer;

import java.io.IOException;
import java.util.ArrayList;

public class MesaController {

    private ArrayList<Mesa> mesas;
    private MesaView view;

    public MesaController(MesaView view) {
        this.view = view;
        try {
            this.mesas = (ArrayList<Mesa>) DataSerializer.deserialize("mesas.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            this.mesas = new ArrayList<>();
        }
    }

    public void adicionarMesa(Mesa mesa) {
        this.mesas.add(mesa);
        try {
            DataSerializer.serialize(mesas, "mesas.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void atualizarView() {
        // Este método deve ser implementado conforme a necessidade do seu projeto para atualizar a view
        for (Mesa mesa : mesas) {
            view.setNumeroAssentos(mesa.getNumeroAssentos());
            view.setDisponibilidade(mesa.isDisponivel());
        }
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
        try {
            DataSerializer.serialize(mesas, "mesas.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
