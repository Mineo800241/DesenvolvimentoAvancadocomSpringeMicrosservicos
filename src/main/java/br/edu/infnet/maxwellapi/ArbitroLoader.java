package br.edu.infnet.maxwellapi;

import br.edu.infnet.maxwellapi.model.domain.Arbitro;
import br.edu.infnet.maxwellapi.model.domain.Endereco;
import br.edu.infnet.maxwellapi.model.domain.exceptions.ArbitroInvalidoException;
import br.edu.infnet.maxwellapi.model.domain.exceptions.CompetidorInvalidoException;
import br.edu.infnet.maxwellapi.service.ArbitroService;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

@Component
public class ArbitroLoader implements ApplicationRunner {

    private final ArbitroService arbitroService;

    public ArbitroLoader(ArbitroService arbitroService) {
        this.arbitroService = arbitroService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader arquivo = new FileReader("arbitro.txt");
        BufferedReader leitura = new BufferedReader(arquivo);

        String linha = leitura.readLine();
        String[] campos = null;


        System.out.println("[ArbitroLoader] Iniciando carregamento de arbitro do arquivo...");

        while (linha != null) {
            campos = linha.split(";");

            Endereco endereco = new Endereco();
            endereco.setCidade(campos[5]);
            endereco.setEstado(campos[6]);

            Arbitro arbitro = new Arbitro();
            arbitro.setNome(campos[0]);
            arbitro.setCpf(campos[1]);
            arbitro.setEmail(campos[2]);
            arbitro.setTelefone(campos[3]);
            arbitro.setContrato(Boolean.valueOf(campos[4]));

            arbitro.setEndereco(endereco);

//            arbitroService.incluir(arbitro);

            try {
                arbitroService.incluir(arbitro);
            } catch (ArbitroInvalidoException e) {
                System.err.println("Problema na inclusao do arbitro: " + e.getMessage());
            }



            linha = leitura.readLine();
        }

//        for(Arbitro arbitro : arbitroService.obterLista()) {
//            System.out.println(arbitro);
//        }

        System.out.println("[Arbitro Loader] Carregamento concluido com sucesso.");

        List<Arbitro> arbitro =  arbitroService.obterLista();
        arbitro.forEach(System.out::println);

        System.out.println("---- Arbitro Carregados ----");
        arbitro.forEach(System.out::println);
        System.out.println("---------------------------------");

            leitura.close();

    }
}