/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

public class PagamentoPix extends Pagamento {

    int prazo = 0;
    double desconto = 0.9855;

    public PagamentoPix(double pagamento) {
        super(pagamento);
    }

    @Override
    public double pagar() {
        if (this.valor * desconto < valor - 10) {
            return this.valor - 10;
        } else {
            return this.valor * desconto;
        }
    }
    @Override
    public void addPagamentos() {
        Pagamentos pagamentos = Pagamentos.getInstance();
        pagamentos.addPagamentos(new PagamentoPix(valor));
    }

}
