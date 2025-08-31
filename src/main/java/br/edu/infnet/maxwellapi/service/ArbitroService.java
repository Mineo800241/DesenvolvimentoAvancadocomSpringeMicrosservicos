package br.edu.infnet.maxwellapi.service;

import br.edu.infnet.maxwellapi.model.domain.Arbitro;

import br.edu.infnet.maxwellapi.model.domain.exceptions.ArbitroInvalidoException;
import br.edu.infnet.maxwellapi.model.domain.exceptions.ArbitroNaoEncontradoException;

import br.edu.infnet.maxwellapi.model.repository.ArbitroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class ArbitroService implements CrudService <Arbitro, Integer> {

    private final ArbitroRepository arbitroRepository;

    public ArbitroService(ArbitroRepository arbitroRepository) {
        this.arbitroRepository = arbitroRepository;
    }


    private void validar(Arbitro arbitro){
        if(arbitro == null){
            throw new IllegalArgumentException("Arbitro sem ID (invalido)");
        }
        if(arbitro.getNome() == null || arbitro.getNome().trim().isEmpty()){
            throw new ArbitroInvalidoException("Nome do arbitro é obrigatorio!");
        }
    }

    @Override
    @Transactional
    public Arbitro incluir(Arbitro arbitro) {

        validar(arbitro);

        if(arbitro.getId() != null && arbitro.getId() != 0){
            throw new IllegalArgumentException("NOVO arbitro NÃO PODE TER ID NA INCLUSAO");
        }

        return arbitroRepository.save(arbitro);
    }

    @Override
    @Transactional
    public Arbitro alterar(Integer id, Arbitro arbitro) {

        if(id == null || id == 0){
            throw new IllegalArgumentException("ID para alteracao nao pode ser nulo/zero");
        }

        validar(arbitro);

        obterPorId(id);

        arbitro.setId(id);

        return arbitroRepository.save(arbitro);
    }

    @Override
    public Arbitro obterPorId(Integer id) {

        if(id == null || id <= 0){
            throw new IllegalArgumentException("ID para alteracao nao pode ser nulo/zero");
        }

        return arbitroRepository.findById(id).orElseThrow(()-> new ArbitroNaoEncontradoException("Arbitro com ID " + id + " nao existe."));
    }

    @Override
    @Transactional
    public void excluir(Integer id) {

        obterPorId(id);

        arbitroRepository.delete(obterPorId(id));
    }
    @Transactional
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
        return arbitroRepository.save(arbitro);
    }

    @Override
    public List<Arbitro> obterLista() {

        return arbitroRepository.findAll();
    }


}
