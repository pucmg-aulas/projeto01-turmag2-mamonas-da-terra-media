package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurante.ListaDeEspera;
import restaurante.Mesa;
import restaurante.RequisicaoDeMesa;

import java.time.LocalTime;
import java.util.ArrayList;

public class ListaDeEsperaTest {
    private ListaDeEspera listaDeEspera;
    private ArrayList<Mesa> mesasDisponiveis;

    @BeforeEach
    public void setUp() {
        mesasDisponiveis = new ArrayList<>();
        mesasDisponiveis.add(new Mesa(4));
        mesasDisponiveis.add(new Mesa(2));
        listaDeEspera = new ListaDeEspera(mesasDisponiveis);
    }

    @Test
    public void testAdicionarNaLista() {
        RequisicaoDeMesa requisicao = new RequisicaoDeMesa("Ana", 2, LocalTime.of(20, 0), null);
        listaDeEspera.adicionarNaLista(requisicao);
        assertEquals(1, listaDeEspera.imprimirLista().split("\n").length);
        assertTrue(requisicao.getMesaAtribuida().isOcupada());
    }

    @Test
    public void testAdicionarNaListaSemMesaDisponivel() {
        mesasDisponiveis.get(0).ocuparMesa();
        mesasDisponiveis.get(1).ocuparMesa();
        RequisicaoDeMesa requisicao = new RequisicaoDeMesa("Ana", 2, LocalTime.of(20, 0), null);
        listaDeEspera.adicionarNaLista(requisicao);
        assertEquals(0, listaDeEspera.imprimirLista().split("\n").length);
    }

    @Test
    public void testRemoverDaLista() {
        RequisicaoDeMesa requisicao = new RequisicaoDeMesa("Ana", 2, LocalTime.of(20, 0), null);
        listaDeEspera.adicionarNaLista(requisicao);
        listaDeEspera.removerDaLista(requisicao);
        assertEquals(0, listaDeEspera.imprimirLista().split("\n").length);
        assertFalse(requisicao.getMesaAtribuida().isOcupada());
    }

    @Test
    public void testRemoverDaListaPorNome() {
        RequisicaoDeMesa requisicao = new RequisicaoDeMesa("Ana", 2, LocalTime.of(20, 0), null);
        listaDeEspera.adicionarNaLista(requisicao);
        listaDeEspera.removerDaListaPorNome("Ana");
        assertEquals(0, listaDeEspera.imprimirLista().split("\n").length);
        assertFalse(requisicao.getMesaAtribuida().isOcupada());
    }

    @Test
    public void testImprimirLista() {
        RequisicaoDeMesa requisicao1 = new RequisicaoDeMesa("Ana", 2, LocalTime.of(20, 0), null);
        RequisicaoDeMesa requisicao2 = new RequisicaoDeMesa("Pedro", 4, LocalTime.of(21, 0), null);
        listaDeEspera.adicionarNaLista(requisicao1);
        listaDeEspera.adicionarNaLista(requisicao2);
        String lista = listaDeEspera.imprimirLista();
        assertTrue(lista.contains("Ana"));
        assertTrue(lista.contains("Pedro"));
    }

    @Test
    public void testImprimirHistorico() {
        RequisicaoDeMesa requisicao1 = new RequisicaoDeMesa("Ana", 2, LocalTime.of(20, 0), null);
        RequisicaoDeMesa requisicao2 = new RequisicaoDeMesa("Pedro", 4, LocalTime.of(21, 0), null);
        listaDeEspera.adicionarNaLista(requisicao1);
        listaDeEspera.adicionarNaLista(requisicao2);
        listaDeEspera.removerDaLista(requisicao1);
        String historico = listaDeEspera.imprimirHistorico();
        assertTrue(historico.contains("Ana"));
        assertTrue(historico.contains("Pedro"));
    }

    @Test
    public void testImprimirCliente() {
        RequisicaoDeMesa requisicao = new RequisicaoDeMesa("Ana", 2, LocalTime.of(20, 0), null);
        listaDeEspera.adicionarNaLista(requisicao);
        String infoCliente = listaDeEspera.imprimirCliente("Ana");
        assertTrue(infoCliente.contains("Ana"));
        assertTrue(infoCliente.contains("2"));
    }
}
