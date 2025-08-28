package br.edu.infnet.maxwellapi.model.domain;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.validation.annotation.Validated;

@Entity
@Table
public class Competidor extends Pessoa {


    private String academia;
    private int idade;
    private double peso;
    private String faixa;
    private boolean pagamento;
    private String genero;
    private boolean ativo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Override
    public String obterPessoa() {
        return "Competidor ";
    }


    @Override
    public String toString() {
        return String.format("Competidor, %s, academia: %s, idade: %d, peso: %.2f, faixa: %s, pagamento? %s, genero: %s, cadastro? %s, endereco: %s", super.toString(), academia, idade, peso, faixa, pagamento ? "ok" : "falta", genero, ativo ? "ativo" : "inativo", endereco);
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}


