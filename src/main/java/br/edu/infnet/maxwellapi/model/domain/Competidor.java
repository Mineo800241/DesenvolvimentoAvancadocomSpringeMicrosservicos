package br.edu.infnet.maxwellapi.model.domain;

public class Competidor {

    public String nome;
    public String cpf;
    public String email;
    public String telefone;
    public String academia;
    public double idade;
    public double peso;
    public String faixa;
    public boolean pagamento;

    @Override
    public String toString() {

        return String.format("O competidor %s, cpf %s, com email %s, com telefone %s, academia %s, idade %.0f, peso %.2f, faixa %s, esta com pagamento %s ", nome, cpf, email, telefone, academia, idade, peso, faixa, pagamento ? "ok" : "falta");
    }
}
