package controller;

import view.MenuPrincipalView;

public class MenuPrincipalController {
    
    private MenuPrincipalView view;

    public MenuPrincipalController() {
        this.view = new MenuPrincipalView();
        
        this.view.setVisible(true);
        
        this.view.getBtnAdicionarCliente().addActionListener((e) ->{ 
            new ClientesController();
        });
        this.view.getBtnMesas().addActionListener((e) ->{ 
            new MesasController();
        });
        this.view.getBtnCardapio().addActionListener((e) ->{
            new MenuController();
                });
        this.view.getBtnMostrarFila().addActionListener((e)->{
            new ListaDeEsperaController();
                });
        this.view.getBtnPedirConta().addActionListener((e) ->{
            new ContaController();
                });
        this.view.getBtnFazerPedido().addActionListener((e) ->{
            new PedidoController();
                });
        
        this.view.getBtnSair().addActionListener((e) ->{
            cancelar();
                });
    }

    private void cancelar() {
        this.view.dispose();
    }
    

    
    
}
