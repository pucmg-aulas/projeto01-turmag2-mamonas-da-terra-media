package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import restaurante.Mesa;

class MesaTest {

	@Test
	public void numerosAssentosMenorQueUmTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Mesa(0, true);
		});
	}
	
	@Test
	public void numeroAssentosMaiorQueUmtest() {
		Mesa Mesa1 = new Mesa(6, true);
		assertEquals(6, Mesa1.getNumeroAssentos());
	}

}
