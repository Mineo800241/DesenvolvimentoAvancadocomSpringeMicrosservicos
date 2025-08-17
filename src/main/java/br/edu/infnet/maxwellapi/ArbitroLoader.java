package br.edu.infnet.maxwellapi;

import br.edu.infnet.maxwellapi.model.domain.Arbitro;
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

        while(linha != null) {
            campos = linha.split(";");

            Arbitro arbitro = new Arbitro();
            arbitro.nome = campos[0];
            arbitro.cpf = campos[1];
            arbitro.email = campos[2];
            arbitro.telefone = campos[3];
            arbitro.contrato = Boolean.valueOf(campos[4]);

            System.out.println(arbitro);

            linha = leitura.readLine();
        }

        leitura.close();


    }
}