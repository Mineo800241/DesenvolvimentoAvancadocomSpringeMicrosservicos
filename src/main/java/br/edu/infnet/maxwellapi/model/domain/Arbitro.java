package br.edu.infnet.maxwellapi.model.domain;

public class Arbitro {

    public String nome;
    public String cpf;
    public String email;
    public String telefone;
    public boolean contrato;

    @Override
    public String toString() {

        return String.format("O arbitro %s, cpf %s, com email %s, com telefone %s, esta com cadastro %s ", nome, cpf, email, telefone, contrato ? "ativo" : "inativo");
    }
}
