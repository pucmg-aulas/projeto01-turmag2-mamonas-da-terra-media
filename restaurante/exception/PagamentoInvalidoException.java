package restaurante.exception;

public class PagamentoInvalidoException extends PagamentoException {

    public PagamentoInvalidoException(String message) {
        super(message);
    }

    public PagamentoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
