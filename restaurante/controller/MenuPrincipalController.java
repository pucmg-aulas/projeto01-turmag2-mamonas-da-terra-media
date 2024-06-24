package controller;

import view.MenuPrincipalView;

public class MenuPrincipalController {
    
    private MenuPrincipalView view;

    public MenuPrincipalController() {
        this.view = new MenuPrincipalView();
        
        this.view.setVisible(true);
        
        this.view.getBtnAdicionarCliente().addActionListener((e) ->{ 
            new AddClienteController();
        });
        this.view.getBtnRemoverCliente().addActionListener((e) ->{ 
            new RemoverClienteController();
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
