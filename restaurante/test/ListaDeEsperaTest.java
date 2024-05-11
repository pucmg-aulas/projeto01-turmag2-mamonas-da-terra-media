import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import restaurante.ListaDeEspera;
import restaurante.RequisicaoDeMesa;

class ListaDeEsperaTest {

	@Test
	void adicionaVazioListaDeEsperaTest() {
		ListaDeEspera listaTest = new ListaDeEspera();
		assertThrows(IllegalArgumentException.class, () ->{
			listaTest.adicionarNaLista(null);
		});
	}

	@Test
    	void adicionaClienteNaListaDeEsperaTest() {
	        ListaDeEspera listaTest = new ListaDeEspera();
        	listaTest.adicionarNaLista(new RequisicaoDeMesa("João", 4));
	        String listaEsperada = "Cliente: João, 4\n";
	        assertEquals(listaEsperada, listaTest.imprimirLista(), "Cliente não foi adicionado corretamente à lista de espera");
    }

}
