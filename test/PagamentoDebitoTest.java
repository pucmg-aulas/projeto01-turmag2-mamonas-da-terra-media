package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurante.PagamentoDebito;
import restaurante.Pagamentos;

public class PagamentoDebitoTest {

    @Test
    public void testConstrutor() {
        PagamentoDebito pagamentoDebito = new PagamentoDebito(100.0);

        assertEquals(100.0, pagamentoDebito.getValor());
    }

    @Test
    public void testPagar() {
        PagamentoDebito pagamentoDebito = new PagamentoDebito(100.0);

        double valorEsperado = 100.0 * 0.986; // Aplica o desconto de 1.4%
        assertEquals(valorEsperado, pagamentoDebito.pagar());
    }

    @Test
    public void testAddPagamentos() {
        PagamentoDebito pagamentoDebito = new PagamentoDebito(100.0);
        pagamentoDebito.addPagamentos();

        Pagamentos pagamentos = Pagamentos.getInstance();
        assertEquals(1, pagamentos.getPagamentos().size());
        assertTrue(pagamentos.getPagamentos().get(0) instanceof PagamentoDebito);
        assertEquals(100.0, pagamentos.getPagamentos().get(0).getValor());
    }
}
