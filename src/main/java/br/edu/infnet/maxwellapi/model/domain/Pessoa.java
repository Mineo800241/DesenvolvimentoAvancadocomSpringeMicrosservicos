package br.edu.infnet.maxwellapi.model.domain;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 50, message = "O NOME TEM QUE TER DE 3 A 50 CARACTERES!")
    private String nome;

    //@NotBlank
    //@Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3} -\\d{2}$")
    private String cpf;

    @NotBlank(message = "email é obrigatório")
//    @Email(message = "email invalido")
    private String email;

    @NotBlank(message = "telefone é obrigatório")
    private String telefone;

    @Override
    public String toString() {
        return String.format("ID: %s, nome: %s, cpf: %s, email: %s, telefone: %s",id, nome, cpf, email,telefone);
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
