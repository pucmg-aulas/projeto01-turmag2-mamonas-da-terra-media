package restaurante.exception;

public class PrecoInvalidoException extends RuntimeException {

    public PrecoInvalidoException(String mensagemErro) {
        super(mensagemErro);
    }
}