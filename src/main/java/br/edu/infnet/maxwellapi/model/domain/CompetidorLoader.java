package br.edu.infnet.maxwellapi.model.domain;


import ch.qos.logback.core.util.SystemInfo;

import java.sql.SQLOutput;

public class CompetidorLoader {

    public static void main(String[] args) {


        Competidor competidorMaxwell = new Competidor();
        competidorMaxwell.nome = "Maxwell Simões Mineo";
        competidorMaxwell.cpf =  "04370389903";
        competidorMaxwell.email = "nacmineo@gmail.com";
        competidorMaxwell.telefone = "429996935648";
        competidorMaxwell.academia = "Armis";
        competidorMaxwell.idade = 33;
        competidorMaxwell.peso = 79.00;
        competidorMaxwell.faixa = "roxa";
        competidorMaxwell.pagamento = true;
        System.out.println(competidorMaxwell);


        Competidor competidorMessi = new Competidor();
        competidorMessi.nome = "Lionel E Messi";
        competidorMessi.cpf =  "07850389903";
        competidorMessi.email = "messi@gmail.com";
        competidorMessi.telefone = "429996915986";
        competidorMessi.academia = "Maggo";
        competidorMessi.idade = 29;
        competidorMessi.peso = 84.00;
        competidorMessi.faixa = "azul";
        competidorMessi.pagamento = false;
        System.out.println(competidorMessi);



    }
}