package restaurante.controller;

import restaurante.model.Mesa;
import restaurante.view.MesaView;


public class MesaController {

    private Mesa model;
    private MesaView view;

    public MesaController(Mesa model, MesaView view) {
        this.model = model;
        this.view = view;

        this.view.setNumeroAssentos(this.model.getNumeroAssentos());
        this.view.setDisponibilidade(this.model.isDisponivel());

    }
}
