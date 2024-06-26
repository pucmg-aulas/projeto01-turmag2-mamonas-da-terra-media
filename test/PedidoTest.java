package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import restaurante.Pedido;
import restaurante.ItemMenu;

import java.util.List;

public class PedidoTest {

    @Test
    public void testAdicionarItem() {
        Pedido pedido = new Pedido();
        ItemMenu item = new ItemMenu("Pasta", 20.0);

        pedido.adicionarItem(item);
        List<ItemMenu> itens = pedido.getItens();
        
        assertEquals(1, itens.size());
        assertTrue(itens.contains(item));
        assertEquals(20.0, pedido.calcularTotal(), 0.001);
    }

    @Test
    public void testRemoverItem() {
        Pedido pedido = new Pedido();
        ItemMenu item = new ItemMenu("Pasta", 20.0);
        pedido.adicionarItem(item);

        pedido.removerItem(item);
        List<ItemMenu> itens = pedido.getItens();
        
        assertEquals(0, itens.size());
        assertFalse(itens.contains(item));
        assertEquals(0.0, pedido.calcularTotal(), 0.001);
    }

    @Test
    public void testCalcularTotal() {
        Pedido pedido = new Pedido();
        ItemMenu item1 = new ItemMenu("Pasta", 20.0);
        ItemMenu item2 = new ItemMenu("Salad", 10.0);

        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);
        
        double totalEsperado = (20.0 + 10.0) * 1.1;
        assertEquals(totalEsperado, pedido.calcularTotal(), 0.001);
    }

    @Test
    public void testLimparPedido() {
        Pedido pedido = new Pedido();
        ItemMenu item = new ItemMenu("Pasta", 20.0);
        pedido.adicionarItem(item);

        pedido.limparPedido();
        List<ItemMenu> itens = pedido.getItens();
        
        assertEquals(0, itens.size());
        assertEquals(0.0, pedido.calcularTotal(), 0.001);
    }

    @Test
    public void testToString() {
        Pedido pedido = new Pedido();
        ItemMenu item = new ItemMenu("Pasta", 20.0);
        pedido.adicionarItem(item);
        
        String expected = "Pasta - R$ 20.0\nTotal: R$ 20.0\n";
        assertEquals(expected, pedido.toString());
    }
}
