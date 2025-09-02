package br.edu.infnet.maxwellapi.model.domain;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;



@Entity
@Table(name = "tmodalidade")
public class Modalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String codigoluta;


    private String modalidadeluta;


    private String generoModalidade;
//arrumar aqui depois

    private String categoriaPorIdade;


    private String faixaJiujitsu;


    private String pesoModalidade;


    private String pesoOuabsolutoOuambos;


//    @NotBlank
//    @Enumerated(EnumType.STRING)
//    private TipodeLuta tipodeLuta;

    //private String voucher

    //enumerator

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "competidor_id")
    private Competidor competidor;


//    @ManyToOne(fetch =  FetchType.LAZY)
//    @JoinColumn(name = "modalidade_id", nullable = false)
//    private Modalidade modalidade;


//    @Override
//    public String toString() {
//        return String.format("ID: %d, codigoluta, %s, codigoluta: %s, modalidadeluta: %s, genero: %s, categoriaPorIdade: %s, faixaJiujitsu: %s, peso: %s, pesoOuabsolutoOuambos: %s, competidor: %s", id, codigoluta, modalidadeluta, generoModalidade, categoriaPorIdade, faixaJiujitsu, pesoModalidade, pesoOuabsolutoOuambos, competidor);
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoluta() {
        return codigoluta;
    }

    public void setCodigoluta(String codigoluta) {
        this.codigoluta = codigoluta;
    }

    public String getModalidadeluta() {
        return modalidadeluta;
    }

    public void setModalidadeluta(String modalidadeluta) {
        this.modalidadeluta = modalidadeluta;
    }

    public String getGeneroModalidade() {
        return generoModalidade;
    }

    public void setGeneroModalidade(String generoModalidade) {
        this.generoModalidade = generoModalidade;
    }

    public String getCategoriaPorIdade() {
        return categoriaPorIdade;
    }

    public void setCategoriaPorIdade(String categoriaPorIdade) {
        this.categoriaPorIdade = categoriaPorIdade;
    }

    public String getFaixaJiujitsu() {
        return faixaJiujitsu;
    }

    public void setFaixaJiujitsu(String faixaJiujitsu) {
        this.faixaJiujitsu = faixaJiujitsu;
    }

    public String getPesoModalidade() {
        return pesoModalidade;
    }

    public void setPesoModalidade(String pesoModalidade) {
        this.pesoModalidade = pesoModalidade;
    }

    public String getPesoOuabsolutoOuambos() {
        return pesoOuabsolutoOuambos;
    }

    public void setPesoOuabsolutoOuambos(String pesoOuabsolutoOuambos) {
        this.pesoOuabsolutoOuambos = pesoOuabsolutoOuambos;
    }

    public Competidor getCompetidor() {
        return competidor;
    }

    public void setCompetidor(Competidor competidor) {
        this.competidor = competidor;
    }
}



