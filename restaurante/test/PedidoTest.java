import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import restaurante.Pedido;

class PedidoTest {

     @Test
    void registraPedidosConsecutivosTest() {
        Pedido pedido = new Pedido();
        pedido.fazerPedido(new int[]{6, 8, 7, 5, 0});
        String pedidoEsperado = "Cacarola de Carne com Legumes, Suco, Agua, Strogonoff, ";
        assertEquals(pedidoEsperado, pedido.imprimePedido(), "Pedido não foi registrado corretamente");
    }

    @Test
    void registraNenhumPedidoTest() {
        Pedido pedido = new Pedido();
        pedido.fazerPedido(new int[]{0});
        String pedidoEsperado = "";
        assertEquals(pedidoEsperado, pedido.imprimePedido(), "Não deveria haver nenhum pedido registrado");
    }

}
