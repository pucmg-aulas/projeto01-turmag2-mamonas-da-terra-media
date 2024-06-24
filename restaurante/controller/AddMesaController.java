package controller;

import restaurante.Mesa;
import view.AddMesaView;


public class AddMesaController {

    private Mesa model;
    private AddMesaView view;

    public AddMesaController() {
        this.model = new Mesa(4, true);
        this.view = new AddMesaView();

        this.view.getTxtAscentos().addActionListener((e) -> {
            salvarMesa();
        });
        
        
        this.view.setVisible(true);

    }
    
    public void salvarMesa(){
         double ascentos = Double.parseDouble(this.view.getTxtAscentos().getText());
         //ABRIR MESAS E SALVAR
    }
}
