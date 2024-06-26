package restaurante.exception;

public class PagamentoException extends Exception {

    public PagamentoException(String message) {
        super(message);
    }

    public PagamentoException(String message, Throwable cause) {
        super(message, cause);
    }
}
