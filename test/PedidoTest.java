package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import java.util.Scanner;

import restaurante.Pedido;

class PedidoTest {

    @Test
    void registraPedidosConsecutivosTest() {
        Pedido pedido = new Pedido();

        int[] pedidos = {6, 8, 7, 5, 0};
        for (int x : pedidos) {
            if (x != 0) {
                switch (x) {
                    case 6:
                        pedido.getPedido().add("Cacarola de Carne com Legumes");
                        break;
                    case 8:
                        pedido.getPedido().add("Suco");
                        break;
                    case 7:
                        pedido.getPedido().add("Agua");
                        break;
                    case 5:
                        pedido.getPedido().add("Strogonoff");
                        break;
                    default:
                        break;
                }
            } else {
                break;
            }
        }

        String pedidoReal = pedido.imprimirPedido();
        String pedidoEsperado = "Cacarola de Carne com Legumes, Suco, Agua, Strogonoff, ";
        assertEquals(pedidoEsperado, pedidoReal, "Pedido não foi registrado corretamente");
    }

    @Test
    void registraNenhumPedidoTest() {
        Pedido pedido = new Pedido();
        String pedidoReal = pedido.imprimirPedido();
        String pedidoEsperado = "";
        assertEquals(pedidoEsperado, pedidoReal, "Não deveria haver nenhum pedido registrado");
    }

}
