package restaurante;

public class PagamentoDebito extends Pagamento {

    int prazo = 14;
    double desconto = 0.986;

    public PagamentoDebito(double pagamento) {
        super(pagamento);
    }

    @Override
    public double pagar() {
        return this.valor * desconto;

    }
    
    @Override
    public void addPagamentos() {
        Pagamentos pagamentos = Pagamentos.getInstance();
        pagamentos.addPagamentos(new PagamentoDebito(valor));
    }
}
