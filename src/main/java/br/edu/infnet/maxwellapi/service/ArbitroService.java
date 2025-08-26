package br.edu.infnet.maxwellapi.service;

import br.edu.infnet.maxwellapi.model.domain.Arbitro;
import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.model.domain.Endereco;
import br.edu.infnet.maxwellapi.model.domain.exceptions.CompetidorInvalidoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ArbitroService implements CrudService <Arbitro, Integer> {

    private final Map<Integer, Arbitro> mapa = new ConcurrentHashMap<Integer,Arbitro>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    private void validar(Arbitro arbitro){
        if(arbitro == null){
            throw new IllegalArgumentException("Arbitro sem ID (invalido)");
        }
        if(arbitro.getNome() == null || arbitro.getNome().trim().isEmpty()){
            throw new CompetidorInvalidoException("Nome do arbitro é obrigatorio!");
        }
    }

    @Override
    public Arbitro incluir(Arbitro arbitro) {

        validar(arbitro);

        if(arbitro.getId() != null && arbitro.getId() != 0){
            throw new IllegalArgumentException("NOVO arbitro NÃO PODE TER ID NA INCLUSAO");
        }

        arbitro.setId(nextId.getAndIncrement());

        mapa.put(arbitro.getId(), arbitro);

        return arbitro;
    }

    @Override
    public Arbitro alterar(Integer id, Arbitro arbitro) {

        if(id == null || id == 0){
            throw new IllegalArgumentException("ID para alteracao nao pode ser nulo/zero");
        }

        validar(arbitro);

        obterPorId(id);

        arbitro.setId(id);

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
            throw new IllegalArgumentException("Impossível obter o árbitro pelo ID" + id);
        }

        return arbitro;
    }

    @Override
    public void excluir(Integer id) {
        mapa.remove(id);
    }

    public Arbitro inativar(Integer id){
        if(id == null || id == 0){
            throw new IllegalArgumentException("ID para alteracao nao pode ser nulo/zero");
        }
        Arbitro arbitro = obterPorId(id);

        if(!arbitro.isContrato()){
            System.out.println("Arbitro" + arbitro.getNome() + "já está inativo");
            return arbitro;
        }
        arbitro.setContrato(false);
        return null;
    }

    @Override
    public List<Arbitro> obterLista() {

        return new ArrayList<Arbitro>( mapa.values());
    }


}
