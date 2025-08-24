package br.edu.infnet.maxwellapi.model.domain;

public class Competidor extends Pessoa{


    private Integer id;
    private String academia;
    private double idade;
    private double peso;
    private String faixa;
    private boolean pagamento;
    private Endereco endereco;

    @Override
    public String obterPessoa() {
        return "Competidor ";
    }


    @Override
    public String toString() {
        return String.format("Numero ---  %d, Extends Pessoa o competidor %s, %s, %s, %.0f,%.2f, %s,%s", id, super.toString(),academia, endereco, idade, peso, faixa, pagamento ? "ok" : "falta");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public boolean isPagamento() {
        return pagamento;
    }

    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
