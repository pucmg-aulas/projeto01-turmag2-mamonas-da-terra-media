package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import restaurante.RequisicaoDeMesa;
import restaurante.Mesa;
import restaurante.Pedido;

import java.time.LocalTime;

public class RequisicaoDeMesaTest {

    @Test
    public void testConstrutor() {
        Mesa mesa = new Mesa(); 
        RequisicaoDeMesa requisicao = new RequisicaoDeMesa("João", 4, LocalTime.of(19, 0), mesa);

        assertEquals("João", requisicao.getNomeCliente());
        assertEquals(4, requisicao.getQuantiaPessoas());
        assertEquals(LocalTime.of(19, 0), requisicao.getHoraEntrada());
        assertEquals(mesa, requisicao.getMesaAtribuida());
    }

    @Test
    public void testSetHoraSaida() {
        Mesa mesa = new Mesa();
        RequisicaoDeMesa requisicao = new RequisicaoDeMesa("João", 4, LocalTime.of(19, 0), mesa);

        requisicao.setHoraSaida(LocalTime.of(21, 0));
        assertEquals(LocalTime.of(21, 0), requisicao.getHoraSaida());
    }

    @Test
    public void testSetMesaAtribuida() {
        Mesa mesa1 = new Mesa();
        Mesa mesa2 = new Mesa();
        RequisicaoDeMesa requisicao = new RequisicaoDeMesa("João", 4, LocalTime.of(19, 0), mesa1);

        requisicao.setMesaAtribuida(mesa2);
        assertEquals(mesa2, requisicao.getMesaAtribuida());
    }

    @Test
    public void testCalculaConta() {
        Mesa mesa = new Mesa();
        RequisicaoDeMesa requisicao = new RequisicaoDeMesa("João", 4, LocalTime.of(19, 0), mesa);

        Pedido pedido = requisicao.getPedido();

        double totalEsperado = pedido.calcularTotal();
        assertEquals(totalEsperado, requisicao.calculaConta());
    }
}
