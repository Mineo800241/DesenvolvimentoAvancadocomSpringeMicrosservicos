package br.edu.infnet.maxwellapi.model.domain;

public class Arbitro extends Pessoa {

    private Integer id;
    private boolean contrato;
    private Endereco endereco;

    @Override
    public String obterPessoa() {
        return "Arbitro";
    }

    @Override
    public String toString() {
        return String.format("Numero %d - - Da classe arbitro tem %s e com o contrato %s, tem endereço: %s", id, super.toString(), contrato ? "ativo" : "inativo", endereco);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
