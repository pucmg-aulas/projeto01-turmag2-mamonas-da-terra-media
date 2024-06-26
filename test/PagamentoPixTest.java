package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import restaurante.PagamentoPix;
import restaurante.Pagamentos;

public class PagamentoPixTest {

    @Test
    public void testConstrutor() {
        PagamentoPix pagamentoPix = new PagamentoPix(100.0);
        assertEquals(100.0, pagamentoPix.getValor());
    }

    @Test
    public void testPagarDescontoMaior() {
        PagamentoPix pagamentoPix = new PagamentoPix(100.0);
        double resultado = pagamentoPix.pagar();
        assertEquals(90.0, resultado);
    }

    @Test
    public void testPagarComDesconto() {
        PagamentoPix pagamentoPix = new PagamentoPix(15.0);
        double resultado = pagamentoPix.pagar();
        assertEquals(15.0 * 0.9855, resultado);
    }

    @Test
    public void testAddPagamentos() {
        Pagamentos pagamentos = Pagamentos.getInstance();
        int tamanhoInicial = pagamentos.getPagamentos().size();

        PagamentoPix pagamentoPix = new PagamentoPix(50.0);
        pagamentoPix.addPagamentos();

        assertEquals(tamanhoInicial + 1, pagamentos.getPagamentos().size());
        assertEquals(50.0, pagamentos.getPagamentos().get(tamanhoInicial).getValor());
    }
}
