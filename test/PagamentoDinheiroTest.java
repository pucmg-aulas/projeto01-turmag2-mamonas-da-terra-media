package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurante.PagamentoDinheiro;
import restaurante.Pagamentos;

public class PagamentoDinheiroTest {

    @Test
    public void testConstrutor() {
        PagamentoDinheiro pagamento = new PagamentoDinheiro(100.0);
        assertEquals(100.0, pagamento.pagar());
    }

    @Test
    public void testPagar() {
        PagamentoDinheiro pagamento = new PagamentoDinheiro(200.0);
        assertEquals(200.0, pagamento.pagar());
    }

    @Test
    public void testAddPagamentos() {
        PagamentoDinheiro pagamento = new PagamentoDinheiro(300.0);
        pagamento.addPagamentos();

        Pagamentos pagamentos = Pagamentos.getInstance();
        assertEquals(1, pagamentos.getPagamentos().size());
        assertEquals(300.0, pagamentos.getPagamentos().get(0).pagar());
    }
}
