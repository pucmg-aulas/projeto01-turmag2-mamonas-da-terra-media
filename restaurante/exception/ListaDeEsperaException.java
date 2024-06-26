package restaurante.exception;

public class ListaDeEsperaException extends IllegalArgumentException {

    public ListaDeEsperaException(String mensagemErro) {
        super(mensagemErro);
    }
}
