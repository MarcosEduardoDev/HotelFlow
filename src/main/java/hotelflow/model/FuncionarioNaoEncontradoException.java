package hotelflow.model;

public class FuncionarioNaoEncontradoException extends RuntimeException {
    public FuncionarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
