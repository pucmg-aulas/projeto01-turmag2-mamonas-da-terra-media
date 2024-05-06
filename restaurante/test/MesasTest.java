import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import restaurante.Mesas;

class MesasTest {

	@Test
	public void numerosAssentosMenorQueUmTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Mesas(0, true);
		});
	}
	
	@Test
	public void numeroAssentosMaiorQueUmtest() {
		Mesas Mesa1 = new Mesas(6, true);
		assertEquals(6, Mesa1.getNumeroAssentos());
	}

}
