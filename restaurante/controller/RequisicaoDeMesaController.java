package restaurante.controller;

import restaurante.model.RequisicaoDeMesa;
import restaurante.model.Mesa;

import java.time.LocalTime;

public class RequisicaoDeMesaController {
    public void criarRequisicao(String nomeCliente, int quantiaPessoas, LocalTime horaEntrada, int mesaNumero) {
        Mesa mesa = new Mesa(mesaNumero, true);
        RequisicaoDeMesa requisicao = new RequisicaoDeMesa(nomeCliente, quantiaPessoas, horaEntrada, mesa);
        System.out.println("Requisição criada: " + requisicao.getNomeCliente());
    }
}
