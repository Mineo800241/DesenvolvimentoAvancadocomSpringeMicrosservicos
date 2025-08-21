package br.edu.infnet.maxwellapi;


import br.edu.infnet.maxwellapi.model.domain.Arbitro;
import br.edu.infnet.maxwellapi.model.domain.Endereco;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class ArbitroLoader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader arquivo = new FileReader("arbitro.txt");
        BufferedReader leitura = new BufferedReader(arquivo);

        String linha = leitura.readLine();
        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            Endereco endereco = new Endereco();
            endereco.setCep("86047490");
            endereco.setLocalidade("Londrina");

            Arbitro arbitro = new Arbitro();
            arbitro.setNome(campos[0]);
            arbitro.setCpf(campos[1]);
            arbitro.setEmail(campos[2]);
            arbitro.setTelefone(campos[3]);
            arbitro.setContrato(Boolean.valueOf(campos[4]));
            arbitro.setEndereco(endereco);


            System.out.println(arbitro);


            linha = leitura.readLine();
        }
            leitura.close();

    }
}