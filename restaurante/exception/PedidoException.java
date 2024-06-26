package restaurante.exception;

public class PedidoException extends Exception {

    public PedidoException(String message) {
        super(message);
    }

    public PedidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
