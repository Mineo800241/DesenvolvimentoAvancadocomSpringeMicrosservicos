package br.edu.infnet.maxwellapi;

import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.model.domain.Endereco;
import br.edu.infnet.maxwellapi.model.domain.Modalidade;
import br.edu.infnet.maxwellapi.model.domain.exceptions.CompetidorInvalidoException;
import br.edu.infnet.maxwellapi.model.domain.exceptions.CompetidorNaoEncontradoException;
import br.edu.infnet.maxwellapi.service.CompetidorService;
import br.edu.infnet.maxwellapi.service.ModalidadeService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

@Order(3)
@Component
public class ModalidadeLoader implements ApplicationRunner {

    private final ModalidadeService modalidadeService;
    private final CompetidorService competidorService;

    public ModalidadeLoader(ModalidadeService modalidadeService, CompetidorService competidorService) {
        this.modalidadeService = modalidadeService;
        this.competidorService = competidorService;}

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader arquivo = new FileReader("modalidade.txt");
        BufferedReader leitura = new BufferedReader(arquivo);

        String linha = leitura.readLine();
        String[] campos = null;


        System.out.println("[ModadlidadeLoader] Iniciando carregamento de modalidade do arquivo...");

        while(linha != null) {
            campos = linha.split(";");

//            Modalidade modalidade = new Modalidade();
//            modalidade.setCodigoluta(campos[0]);
//            modalidade.setModalidadeluta(campos[1]);
//            modalidade.setGenero(campos[2]);
//            modalidade.setCategoriaPorIdade(campos[3]);
//            modalidade.setFaixaJiujitsu(campos[4]);
//            modalidade.setPeso(campos[5]);
//            modalidade.setPesoOuabsolutoOuambos(campos[6]);

            String Codigoluta = campos[0];
            String Modalidadeluta = campos[1];
            String GeneroModalidade = campos[2];
            String CategoriaPorIdade = campos[3];
            String FaixaJiujitsu = campos[4];
            String PesoModalidade = campos[5];
            String PesoOuabsolutoOuambos = campos[6];
            String cpfCompetidor = campos[7];

            Competidor responsavel = null;

            try{
                responsavel = competidorService.obterporCpf(cpfCompetidor);
                if (responsavel == null) {
                    System.err.println("[CPF] competidor com cpf " + cpfCompetidor + "Não encontrado na lista" + Modalidadeluta);
                    linha = leitura.readLine();
                    continue;
                }

            } catch (CompetidorNaoEncontradoException e){
                linha = leitura.readLine();
                continue;
            }

            Modalidade modalidade = new Modalidade();
            modalidade.setCodigoluta(Codigoluta);
            modalidade.setModalidadeluta(Modalidadeluta);
            modalidade.setGeneroModalidade(GeneroModalidade);
            modalidade.setCategoriaPorIdade(CategoriaPorIdade);
            modalidade.setFaixaJiujitsu(FaixaJiujitsu);
            modalidade.setPesoModalidade(PesoModalidade);
            modalidade.setPesoOuabsolutoOuambos(PesoOuabsolutoOuambos);

            modalidade.setCompetidor(responsavel);


            try {
                modalidadeService.incluir(modalidade);
                System.out.println("[Modalidade cadastrado com sucesso]" + modalidade.getCodigoluta() + "incluido com sucesso");
            } catch (Exception e) {
                System.err.println("Problema na inclusao da modalidade: " + modalidade.getCodigoluta() + ":" + e.getMessage());
            }

            linha = leitura.readLine();
        }


        System.out.println("[Modalidade Loader] Carregamento concluido com sucesso.");


        List<Modalidade> modalidade =  modalidadeService.obterLista();
        modalidade.forEach(System.out::println);


        System.out.println("---- Modalidade Carregados ----");
        modalidade.forEach(System.out::println);
        System.out.println("---------------------------------");

        leitura.close();
    }
}

