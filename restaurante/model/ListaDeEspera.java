package restaurante.model;

import java.util.*;

public class ListaDeEspera {

    private ArrayList<RequisicaoDeMesa> listaRequisicao;
    private ArrayList<RequisicaoDeMesa> historico;
    private ArrayList<Mesa> mesasDisponiveis;

    public ListaDeEspera(ArrayList<Mesa> mesasDisponiveis) {
        this.listaRequisicao = new ArrayList<>();
        this.historico = new ArrayList<>();
        this.mesasDisponiveis = mesasDisponiveis;
    }


    public void adicionarNaLista(RequisicaoDeMesa requisicao) {
        if (requisicao == null) {
            throw new IllegalArgumentException("Requisição não pode ser vazia");
        }
        Mesa mesaAtribuida = encontrarMesa(requisicao.getQuantiaPessoas());
        if (mesaAtribuida != null) {
            requisicao.setMesaAtribuida(mesaAtribuida);
            mesaAtribuida.ocuparMesa();
            this.listaRequisicao.add(requisicao);
            this.historico.add(requisicao);
        } else {
            System.out.println("Nenhuma mesa disponível para a requisição.");
        }
    }


    public void removerDaLista(RequisicaoDeMesa requisicao) {
        this.listaRequisicao.remove(requisicao);
        requisicao.getMesaAtribuida().desocuparMesa();
    }



    public void removerDaListaPorNome(String nomeCliente) {
        Iterator<RequisicaoDeMesa> it = listaRequisicao.iterator();
        while (it.hasNext()) {
            RequisicaoDeMesa requisicao = it.next();
            if (requisicao.getNomeCliente().equals(nomeCliente)) {
                it.remove();
                requisicao.getMesaAtribuida().desocuparMesa();
            }
        }
    }

    public String imprimirLista() {
        StringBuilder sb = new StringBuilder();
        for (RequisicaoDeMesa requisicao : listaRequisicao) {
            sb.append("Cliente: ").append(requisicao.getNomeCliente())
              .append(", Lugares: ").append(requisicao.getQuantiaPessoas())
              .append(", Mesa: ").append(requisicao.getMesaAtribuida().getNumeroAssentos())
              .append(" lugares\n");
        }
        return sb.toString();
    }

    public String imprimirHistorico() {
        StringBuilder sb = new StringBuilder();
        for (RequisicaoDeMesa requisicao : historico) {
            sb.append("Cliente: ").append(requisicao.getNomeCliente())
              .append(", Lugares: ").append(requisicao.getQuantiaPessoas())
              .append("\n");
        }
        return sb.toString();
    }

    public String imprimirCliente(String nomeCliente) {
        for (RequisicaoDeMesa requisicao : listaRequisicao) {
            if (requisicao.getNomeCliente().equals(nomeCliente)) {
                return "Cliente: " + requisicao.getNomeCliente() +
                       ", Número de assentos: " + requisicao.getQuantiaPessoas() +
                       ", Hora de entrada: " + requisicao.getHoraEntrada().toString() +
                       ", Mesa: " + requisicao.getMesaAtribuida().getNumeroAssentos() + " lugares";
            }
        }
        return "Cliente não encontrado na lista.";
    }



    private Mesa encontrarMesa(int quantiaPessoas) {
        Mesa mesaExata = null;
        Mesa mesaMenor = null;
        for (Mesa mesa : mesasDisponiveis) {
            if (mesa.isDisponivel()) {
                if (mesa.getNumeroAssentos() == quantiaPessoas) {
                    mesaExata = mesa;
                    break;
                } else if (mesa.getNumeroAssentos() > quantiaPessoas) {
                    if (mesaMenor == null || mesa.getNumeroAssentos() < mesaMenor.getNumeroAssentos()) {
                        mesaMenor = mesa;
                    }
                }
            }
        }
        return (mesaExata != null) ? mesaExata : mesaMenor;
    }
}
