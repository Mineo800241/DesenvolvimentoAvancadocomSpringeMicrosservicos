package br.edu.infnet.maxwellapi.model.domain;

public class Arbitro extends Pessoa {

    private Integer id;
    private boolean contrato;
//    private Endereco endereco;

    @Override
    public String obterPessoa() {
        return "Arbitro";
    }

    @Override
    public String toString() {
        return String.format("ID %d, Arbitro, %s, contrato %s, endereço: ", id, super.toString(), contrato ? "ativo" : "inativo");
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

//    public Endereco getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(Endereco endereco) {
//        this.endereco = endereco;
//    }
}
