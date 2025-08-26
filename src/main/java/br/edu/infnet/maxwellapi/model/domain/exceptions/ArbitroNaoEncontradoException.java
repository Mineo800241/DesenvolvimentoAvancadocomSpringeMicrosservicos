package br.edu.infnet.maxwellapi.model.domain.exceptions;

public class ArbitroNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ArbitroNaoEncontradoException(String msg) {
        super(msg);
    }
}
