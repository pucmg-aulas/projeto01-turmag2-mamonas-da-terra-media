package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import restaurante.Mesa;

public class MesaTest {

    @Test
    public void testConstrutorComNumeroAssentosValido() {
        Mesa mesa = new Mesa(4, true);
        assertEquals(4, mesa.getNumeroAssentos());
        assertTrue(mesa.isDisponivel());
    }

    @Test
    public void testConstrutorComNumeroAssentosInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Mesa(0, true);
        });

        String expectedMessage = "Mesa tem que ter no mínimo 1 assento";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testOcuparMesa() {
        Mesa mesa = new Mesa(4, true);
        mesa.ocuparMesa();
        assertFalse(mesa.isDisponivel());
    }

    @Test
    public void testDesocuparMesa() {
        Mesa mesa = new Mesa(4, false);
        mesa.desocuparMesa();
        assertTrue(mesa.isDisponivel());
    }
}
