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

    @Test
    void registraPedidoMoquecaSucoTest() {
        Pedido pedido = new Pedido();
        pedido.fazerPedido(new int[]{1, 8, 0});
        String pedidoEsperado = "Moqueca De Tilapia, Suco, ";
        assertEquals(pedidoEsperado, pedido.imprimePedido(), "Pedido não foi registrado corretamente");
    }

    @Test
    void registraPedidoFalafelCervejaTest() {
        Pedido pedido = new Pedido();
        pedido.fazerPedido(new int[]{2, 10, 0});
        String pedidoEsperado = "Falafel Assado, Cerveja, ";
        assertEquals(pedidoEsperado, pedido.imprimePedido(), "Pedido não foi registrado corretamente");
    }


    @Test
    void registraPedidoSaladaAguaTest() {
        Pedido pedido = new Pedido();
        pedido.fazerPedido(new int[]{3, 7, 0});
        String pedidoEsperado = "Salada Primavera com Macarrão Konjac, Agua, ";
        assertEquals(pedidoEsperado, pedido.imprimePedido(), "Pedido não foi registrado corretamente");
    }

    @Test
    void registraPedidoEscondidinhoVinhoTest() {
        Pedido pedido = new Pedido();
        pedido.fazerPedido(new int[]{4, 11, 0});
        String pedidoEsperado = "Escondidinho de Frango, Taca de Vinho, ";
        assertEquals(pedidoEsperado, pedido.imprimePedido(), "Pedido não foi registrado corretamente");
    }

    @Test
    void registraPedidoStrogonoffRefrigeranteTest() {
        Pedido pedido = new Pedido();
        pedido.fazerPedido(new int[]{5, 9, 0});
        String pedidoEsperado = "Strogonoff, Refrigerante, ";
        assertEquals(pedidoEsperado, pedido.imprimePedido(), "Pedido não foi registrado corretamente");
    }

}
