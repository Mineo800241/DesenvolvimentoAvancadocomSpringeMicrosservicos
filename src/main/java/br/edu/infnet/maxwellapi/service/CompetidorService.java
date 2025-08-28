package br.edu.infnet.maxwellapi.service;

import br.edu.infnet.maxwellapi.model.domain.Competidor;

import br.edu.infnet.maxwellapi.model.domain.exceptions.CompetidorInvalidoException;
import br.edu.infnet.maxwellapi.model.domain.exceptions.CompetidorNaoEncontradoException;

import br.edu.infnet.maxwellapi.model.repository.CompetidorRepository;
import org.springframework.stereotype.Service;


import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;



@Service
public class CompetidorService implements CrudService <Competidor, Integer>{

    private final CompetidorRepository competidorRepository;

    public CompetidorService(CompetidorRepository competidorRepository) {
        this.competidorRepository = competidorRepository;
    }

    private final Map<Integer, Competidor> mapa = new ConcurrentHashMap<Integer,Competidor>();

    private void validar(Competidor competidor){
        if(competidor == null){
            throw new IllegalArgumentException("Competidor sem ID (invalido)");
        }
        if(competidor.getNome() == null || competidor.getNome().trim().isEmpty()){
            throw new CompetidorInvalidoException("Nome do competidor é obrigatorio!");
        }
    }

    @Override
    public Competidor incluir(Competidor competidor){

        validar(competidor);

        if(competidor.getId() != null && competidor.getId() != 0){
            throw new IllegalArgumentException("NOVO Competidor NÃO PODE TER ID NA INCLUSAO");
        }

        return competidorRepository.save(competidor);
    }

    @Override
    public Competidor alterar(Integer id, Competidor competidor){

        if(id == null || id == 0){
            throw new IllegalArgumentException("ID para alteracao nao pode ser nulo/zero");
        }


        validar(competidor);

        obterPorId(id);

        competidor.setId(id);

        mapa.put(competidor.getId(), competidor);

        return competidor;

    }

    @Override
    public Competidor obterPorId(Integer id) {

        if(id == null || id <= 0){
            throw new IllegalArgumentException("ID para alteracao nao pode ser nulo/zero");
        }

        return competidorRepository.findById(id).orElseThrow(() -> new CompetidorNaoEncontradoException("Competidor com ID " + id + " nao existe."));
    }

    @Override
    public void excluir(Integer id) {

        obterPorId(id);

        competidorRepository.deleteById(id);
    }

    public Competidor inativar(Integer id){
        if(id == null || id == 0){
            throw new IllegalArgumentException("ID para alteracao nao pode ser nulo/zero");
        }
        Competidor competidor = obterPorId(id);

        if(!competidor.isAtivo()){
            System.out.println("Competidor" + competidor.getNome() + "já está inativo");
            return competidor;
        }
        competidor.setAtivo(false);
        return null;
    }

    @Override
    public List<Competidor> obterLista() {

        return competidorRepository.findAll();
    }

    }


