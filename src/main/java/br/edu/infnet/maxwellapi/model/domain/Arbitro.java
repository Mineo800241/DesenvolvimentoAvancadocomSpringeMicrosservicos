package br.edu.infnet.maxwellapi.model.domain;

public class Arbitro extends Pessoa {

    private boolean contrato;
    private Endereco endereco;

    @Override
    public String obterPessoa() {
        return "Arbitro";
    }

    @Override
    public String toString() {
        return String.format("Da classe arbitro tem %s e com o contrato %s, tem endereço: %s", super.toString() , contrato ? "ativo" : "inativo", endereco );
    }

    public boolean isContrato() {
        return contrato;
    }

    public void setContrato(boolean contrato) {
        this.contrato = contrato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
