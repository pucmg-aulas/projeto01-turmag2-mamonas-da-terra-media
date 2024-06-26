package restaurante.exception;

public class DataInitializationException extends Exception {

    public DataInitializationException(String message) {
        super(message);
    }

    public DataInitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
