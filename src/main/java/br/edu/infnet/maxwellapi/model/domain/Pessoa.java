package br.edu.infnet.maxwellapi.model.domain;

public abstract class Pessoa {


    private String nome;
    private String cpf;
    private String email;

    @Override
    public String toString() {
        return String.format("nome: %s, cpf: %s, email: %s", nome, cpf, email);
    }

    public abstract String obterPessoa();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    private String telefone;

}
