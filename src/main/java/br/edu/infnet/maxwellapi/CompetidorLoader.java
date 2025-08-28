package br.edu.infnet.maxwellapi;


import br.edu.infnet.maxwellapi.model.domain.Arbitro;
import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.model.domain.Endereco;
import br.edu.infnet.maxwellapi.service.CompetidorService;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

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


        System.out.println("[CompetidorLoader] Iniciando carregamento de competidor do arquivo...");

        while(linha != null) {
            campos = linha.split(";");

            Endereco endereco = new Endereco();
            endereco.setCidade("campos[11]");
            endereco.setEstado("campos[12]");

            Competidor competidor = new Competidor();
            competidor.setNome(campos[0]);
            competidor.setCpf(campos[1]);
            competidor.setEmail(campos[2]);
            competidor.setTelefone(campos[3]);
            competidor.setAcademia(campos[4]);
            competidor.setIdade(Integer.valueOf(campos[5]));
            competidor.setPeso(Double.valueOf(campos[6]));
            competidor.setFaixa(campos[7]);
            competidor.setPagamento(Boolean.valueOf(campos[8]));
            competidor.setGenero(campos[9]);
            competidor.setAtivo(Boolean.valueOf(campos[10]));
            competidor.setEndereco(endereco);

            competidorService.incluir(competidor);

//            System.out.println(competidor);

            linha = leitura.readLine();
        }

//        for(Competidor competidor : competidorService.obterLista()) {
//            System.out.println(competidor);
//        }

        System.out.println("[Competidor Loader] Carregamento concluido com sucesso.");


        List<Competidor> competidor =  competidorService.obterLista();
        competidor.forEach(System.out::println);


        System.out.println("---- Competidores Carregados ----");
        competidor.forEach(System.out::println);
        System.out.println("---------------------------------");

        leitura.close();
    }
}

