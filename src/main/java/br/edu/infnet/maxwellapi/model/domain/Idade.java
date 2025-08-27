package br.edu.infnet.maxwellapi.model.domain;

public class Idade {
    private int idade = 31;
    private String master;

    public Idade(int idade) {
        if(idade > 29 && idade < 35)
                {
            System.out.println("O competidor é master");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }
}
