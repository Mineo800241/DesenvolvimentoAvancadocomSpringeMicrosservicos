package br.edu.infnet.maxwellapi;


import br.edu.infnet.maxwellapi.model.domain.Competidor;
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

            Competidor competidor = new Competidor();
            competidor.nome = campos[0];
            competidor.cpf = campos[1];
            competidor.email = campos[2];
            competidor.telefone = campos[3];
            competidor.academia = campos[4];
            competidor.idade = Float.parseFloat(campos[5]);
            competidor.peso = Float.parseFloat(campos[6]);
            competidor.faixa = campos[7];
            competidor.pagamento = Boolean.valueOf(campos[8]);

            System.out.println(competidor);

            linha = leitura.readLine();
        }

        leitura.close();
    }
}

