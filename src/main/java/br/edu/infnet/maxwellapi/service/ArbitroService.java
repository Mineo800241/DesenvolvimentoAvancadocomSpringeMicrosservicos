package br.edu.infnet.maxwellapi.service;

import br.edu.infnet.maxwellapi.model.domain.Arbitro;
import br.edu.infnet.maxwellapi.model.domain.Endereco;

import br.edu.infnet.maxwellapi.model.domain.exceptions.ArbitroInvalidoException;
import br.edu.infnet.maxwellapi.model.domain.exceptions.ArbitroNaoEncontradoException;
import br.edu.infnet.maxwellapi.model.domain.exceptions.CompetidorInvalidoException;

import br.edu.infnet.maxwellapi.model.repository.ArbitroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ArbitroService implements CrudService <Arbitro, Integer> {

    private final ArbitroRepository arbitroRepository;

    public ArbitroService(ArbitroRepository arbitroRepository) {
        this.arbitroRepository = arbitroRepository;
    }

    private final Map<Integer, Arbitro> mapa = new ConcurrentHashMap<Integer, Arbitro>();

    private void validar(Arbitro arbitro){
        if(arbitro == null){
            throw new IllegalArgumentException("Arbitro sem ID (invalido)");
        }
        if(arbitro.getNome() == null || arbitro.getNome().trim().isEmpty()){
            throw new ArbitroInvalidoException("Nome do arbitro é obrigatorio!");
        }
    }

    @Override
    public Arbitro incluir(Arbitro arbitro) {

        validar(arbitro);

        if(arbitro.getId() != null && arbitro.getId() != 0){
            throw new IllegalArgumentException("NOVO arbitro NÃO PODE TER ID NA INCLUSAO");
        }

        return arbitroRepository.save(arbitro);
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
    public Arbitro obterPorId(Integer id) {

        Arbitro arbitro = mapa.get(id);

        if (arbitro == null) {
            throw new IllegalArgumentException("Impossível obter o árbitro pelo ID" + id);
        }

        return arbitro;
    }

    @Override
    public void excluir(Integer id) {
        if(id == null || id == 0){
            throw new IllegalArgumentException("ID para exclusao nao pode ser nulo/zero");
        }
        if(!mapa.containsKey(id)){
            throw new ArbitroNaoEncontradoException("Arbitro com ID " + id + " nao existe.");
        }
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

        return arbitroRepository.findAll();
    }


}
