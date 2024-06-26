package restaurante.exception;

public class MesaSerializationException extends FileOperationException {

    public MesaSerializationException(String message) {
        super(message);
    }

    public MesaSerializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
