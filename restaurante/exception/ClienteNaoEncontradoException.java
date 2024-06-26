package restaurante.exception;

public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException(String nomeCliente) {
        super("Cliente " + nomeCliente + " não encontrado na lista de espera.");
    }
}

