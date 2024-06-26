package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurante.Menu;
import restaurante.ItemMenu;

import java.util.List;

public class MenuTest {

    @Test
    public void testGetInstance() {
        Menu menu1 = Menu.getInstance();
        Menu menu2 = Menu.getInstance();
        assertSame(menu1, menu2);
    }

    @Test
    public void testAdicionarItem() {
        Menu menu = Menu.getInstance();
        menu.adicionarItem("Pasta", 12.99);
        List<ItemMenu> itens = menu.getItens();

        assertEquals(1, itens.size());
        assertEquals("Pasta", itens.get(0).getNome());
        assertEquals(12.99, itens.get(0).getPreco());
    }

    @Test
    public void testRemoverItem() {
        Menu menu = Menu.getInstance();
        menu.adicionarItem("Pasta", 12.99);
        menu.removerItem("Pasta");
        List<ItemMenu> itens = menu.getItens();

        assertTrue(itens.isEmpty());
    }

    @Test
    public void testImprimirMenu() {
        Menu menu = Menu.getInstance();
        menu.adicionarItem("Pasta", 12.99);
        menu.adicionarItem("Pizza", 8.99);
        
        String expectedMenu = "Pasta: 12.99\nPizza: 8.99\n";
        assertEquals(expectedMenu, menu.imprimirMenu());
    }
}
