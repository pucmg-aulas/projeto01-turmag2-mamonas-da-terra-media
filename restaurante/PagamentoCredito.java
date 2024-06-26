/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

public class PagamentoCredito extends Pagamento {

    int prazo = 30;
    double desconto = 0.969 ;

    public PagamentoCredito(double pagamento) {
        super(pagamento);
    }

    @Override
    public double pagar() {
        return this.valor * desconto;
    }

    @Override
    public void addPagamentos() {
        Pagamentos pagamentos = Pagamentos.getInstance();
        pagamentos.addPagamentos(new PagamentoCredito(valor));
    }

}
