package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import restaurante.ListaDeEspera;
import restaurante.RequisicaoDeMesa;
import restaurante.Mesa;

import java.time.LocalTime;

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
		Mesa mesa = new Mesa(4, true);
		ListaDeEspera listaTest = new ListaDeEspera();
		RequisicaoDeMesa requisicao = new RequisicaoDeMesa("João", 4, LocalTime.of(12, 30), mesa);
		listaTest.adicionarNaLista(requisicao);
		String listaEsperada = "Cliente: João, Lugares: 4, Mesa: 4 lugares\n";
		assertEquals(listaEsperada, listaTest.imprimirLista(), "Cliente não foi adicionado corretamente à lista de espera");
	}

}
