package br.edu.infnet.maxwellapi.model.domain.exceptions;

public class ArbitroInvalidoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ArbitroInvalidoException(String msg) {
        super(msg);
    }
}
