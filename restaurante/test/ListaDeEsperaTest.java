import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import restaurante.ListaDeEspera;

class ListaDeEsperaTest {

	@Test
	void adicionaVazioListaDeEsperaTest() {
		ListaDeEspera ListaTest = new ListaDeEspera();
		assertThrows(IllegalArgumentException.class, () ->{
			ListaTest.adicionarNaLista(null);
		});
	}

}