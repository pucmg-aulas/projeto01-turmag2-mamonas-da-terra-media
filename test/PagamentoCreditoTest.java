package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import restaurante.PagamentoCredito;
import restaurante.Pagamentos;

public class PagamentoCreditoTest {

    @Test
    public void testConstrutor() {
        PagamentoCredito pagamento = new PagamentoCredito(100.0);
        assertEquals(100.0, pagamento.getValor());
    }

    @Test
    public void testPagar() {
        PagamentoCredito pagamento = new PagamentoCredito(100.0);
        double valorEsperado = 100.0 * 0.969;
        assertEquals(valorEsperado, pagamento.pagar());
    }

    @Test
    public void testAddPagamentos() {
        PagamentoCredito pagamento = new PagamentoCredito(100.0);

        Pagamentos pagamentos = Pagamentos.getInstance();
        int tamanhoAntes = pagamentos.getListaPagamentos().size();

        pagamento.addPagamentos();

        int tamanhoDepois = pagamentos.getListaPagamentos().size();
        assertEquals(tamanhoAntes + 1, tamanhoDepois);
    }
}
