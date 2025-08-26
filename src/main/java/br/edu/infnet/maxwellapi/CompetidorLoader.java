package br.edu.infnet.maxwellapi;


import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.model.domain.Endereco;
import br.edu.infnet.maxwellapi.service.CompetidorService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class CompetidorLoader implements ApplicationRunner {

    private final CompetidorService competidorService;

    public CompetidorLoader(CompetidorService competidorService) {
        this.competidorService = competidorService;
    }

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
//            competidor.setEndereco(endereco);
            competidor.setGenero(campos[9]);

            competidorService.incluir(competidor);

            System.out.println(competidor);

            linha = leitura.readLine();
        }

        System.out.println(" - --- - " + competidorService.obterLista().size());

        leitura.close();
    }
}

