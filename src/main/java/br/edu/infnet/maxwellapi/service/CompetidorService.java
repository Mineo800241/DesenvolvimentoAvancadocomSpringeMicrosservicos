package br.edu.infnet.maxwellapi.service;


import br.edu.infnet.maxwellapi.model.domain.Arbitro;
import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.model.domain.Endereco;
import br.edu.infnet.maxwellapi.model.domain.exceptions.CompetidorInvalidoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CompetidorService implements CrudService <Competidor, Integer> {

    private final Map<Integer, Competidor> mapa = new ConcurrentHashMap<Integer, Competidor>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public Competidor salvar(Competidor competidor) {

        if(competidor.getNome() == null){
            throw new CompetidorInvalidoException("Nome do competidor é obrigatorio!");
        }

        competidor.setId(nextId.getAndIncrement());
        mapa.put(competidor.getId(), competidor);
        return competidor;
    }

    @Override
    public Competidor obter() {

        Endereco endereco = new Endereco();
        endereco.setCep("86047490");
        endereco.setLocalidade("Londrina");

        Competidor competidor = new Competidor();
        competidor.setNome("Roger Gracie");
        competidor.setCpf("999.99.000-00");
        competidor.setEmail("roger@gol.com");
        competidor.setTelefone("43 991146663");
        competidor.setAcademia("Gracie Barra");
        competidor.setIdade(40);
        competidor.setPeso(101.00);
        competidor.setFaixa("Preta");
        competidor.setPagamento(Boolean.valueOf(true));
//        competidor.setEndereco(endereco);
        competidor.setId(1);
        competidor.setSexo("Masculino");

        return competidor;
    }

    public Competidor obterPorId(Integer id) {

        Competidor competidor = mapa.get(id);

        if (competidor == null) {
            throw new IllegalArgumentException("Impossível obter o competidor pelo ID" + id);
        }

        return competidor;
    }

    public Competidor obterPorSexo(String sexo) {

        Competidor competidor = mapa.get(sexo);

        if (competidor == null) {
            throw new IllegalArgumentException("Impossível obter o competidor sem sexo" + sexo);
        }

        return competidor;
    }

    @Override
    public void excluir(Integer id) {
        mapa.remove(id);
    }

    @Override
    public List<Competidor> obterLista() {

        return new ArrayList<Competidor>( mapa.values());
    }
}
