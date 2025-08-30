package br.edu.infnet.maxwellapi.model.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;



@Entity

public class Arbitro extends Pessoa {


    private boolean contrato;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    @Valid
    private Endereco endereco;

    @Override
    public String obterPessoa() {
        return "Arbitro";
    }

    @Override
    public String toString() {
        return String.format("Arbitro, %s, contrato: %s, endereco: %s", super.toString(), contrato ? "ativo" : "inativo",endereco);
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
