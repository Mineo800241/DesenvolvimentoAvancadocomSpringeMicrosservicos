package br.edu.infnet.maxwellapi.model.domain.exceptions;

public class CompetidorNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CompetidorNaoEncontradoException(String msg) {
        super(msg);
    }
}
