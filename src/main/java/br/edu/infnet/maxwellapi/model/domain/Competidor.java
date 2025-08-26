package br.edu.infnet.maxwellapi.model.domain;

public class Competidor extends Pessoa{


    private Integer id;
    private String academia;
    private double idade;
    private double peso;
    private String faixa;
    private boolean pagamento;
    private String genero;
    private boolean EhAtivo;
//    private Endereco endereco;

    @Override
    public String obterPessoa() {
        return "Competidor ";
    }


    @Override
    public String toString() {
        return String.format("ID %d, Competidor, %s, academia: %s, idade: %.0f, peso: %.2f, faixa: %s, pagamento?%s,%s,cadastro?%s", id, super.toString(),academia, idade, peso, faixa, pagamento? "ok" : "falta",genero,EhAtivo?"ativo":"inativo");
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

//    public Endereco getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(Endereco endereco) {
//        this.endereco = endereco;
//


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isEhAtivo() {
        return EhAtivo;
    }

    public void setEhAtivo(boolean ehAtivo) {
        EhAtivo = ehAtivo;
    }
}
