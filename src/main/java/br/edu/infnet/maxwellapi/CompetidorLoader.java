package br.edu.infnet.maxwellapi;


import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.model.domain.Endereco;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class CompetidorLoader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader arquivo = new FileReader("competidor.txt");
        BufferedReader leitura = new BufferedReader(arquivo);

        String linha = leitura.readLine();
        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Endereco endereco = new Endereco();
            endereco.setCep("86047490");
            endereco.setLocalidade("Londrina");

            Competidor competidor = new Competidor();
            competidor.setNome(campos[0]);
            competidor.setCpf(campos[1]);
            competidor.setEmail(campos[2]);
            competidor.setTelefone(campos[3]);
            competidor.setAcademia(campos[4]);
            competidor.setIdade(Float.parseFloat(campos[5]));
            competidor.setPeso(Float.parseFloat(campos[6]));
            competidor.setFaixa(campos[7]);
            competidor.setPagamento(Boolean.parseBoolean(campos[8]));
            competidor.setEndereco(endereco);

            System.out.println(competidor);

            linha = leitura.readLine();
        }

        leitura.close();
    }
}

