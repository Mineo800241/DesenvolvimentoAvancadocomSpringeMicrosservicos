package br.edu.infnet.maxwellapi.service;

import br.edu.infnet.maxwellapi.model.domain.Arbitro;
import br.edu.infnet.maxwellapi.model.domain.Endereco;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ArbitroService implements CrudService <Arbitro, Integer> {

    private final Map<Integer, Arbitro> mapa = new ConcurrentHashMap<Integer,Arbitro>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public Arbitro salvar(Arbitro arbitro) {

        arbitro.setId(nextId.getAndIncrement());

        mapa.put(arbitro.getId(), arbitro);

        return arbitro;
    }

    @Override
    public Arbitro obter() {

        Endereco endereco = new Endereco();
        endereco.setCep("86047490");
        endereco.setLocalidade("Londrina");

        Arbitro arbitro = new Arbitro();
        arbitro.setNome("Maxwell Simoes");
        arbitro.setCpf("000.000.000-00");
        arbitro.setEmail("macs@gol.com");
        arbitro.setTelefone("43 991136662");
        arbitro.setContrato(Boolean.valueOf(true));
//        arbitro.setEndereco(endereco);

        return arbitro;
    }

    @Override
    public Arbitro obterPorId(Integer id) {

        Arbitro arbitro = mapa.get(id);

        if (arbitro == null) {

        }

        return arbitro;
    }

    @Override
    public void excluir(Integer id) {
        mapa.remove(id);
    }

    @Override
    public List<Arbitro> obterLista() {

        return new ArrayList<Arbitro>( mapa.values());
    }
}
