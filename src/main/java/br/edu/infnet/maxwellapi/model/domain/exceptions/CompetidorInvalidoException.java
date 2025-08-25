package br.edu.infnet.maxwellapi.model.domain.exceptions;

public class CompetidorInvalidoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CompetidorInvalidoException(String msg) {
        super(msg);
    }
}
