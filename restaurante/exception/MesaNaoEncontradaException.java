package restaurante.exception;

public class MesaNaoEncontradaException extends RuntimeException {

    public MesaNaoEncontradaException(int numeroAssentos) {
        super("Mesa com " + numeroAssentos + " lugares não disponível.");
    }
}
