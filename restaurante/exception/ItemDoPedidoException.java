package restaurante.exception;

public class ItemDoPedidoException extends PedidoException {

    public ItemDoPedidoException(String message) {
        super(message);
    }

    public ItemDoPedidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
