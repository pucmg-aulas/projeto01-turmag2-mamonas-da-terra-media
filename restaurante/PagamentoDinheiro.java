package restaurante;

public class PagamentoDinheiro extends Pagamento {

    int prazo = 0;
    double desconto = 0;

    public PagamentoDinheiro(double pagamento) {
        super(pagamento);

    }
    
    @Override
    public double pagar(){
        return this.valor;
    }
    
    @Override
    public void addPagamentos() {
        Pagamentos pagamentos = Pagamentos.getInstance();
        pagamentos.addPagamentos(new PagamentoDinheiro(valor));
    }

}
