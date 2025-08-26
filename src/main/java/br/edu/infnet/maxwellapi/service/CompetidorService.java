package br.edu.infnet.maxwellapi.service;

import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.model.domain.Endereco;
import br.edu.infnet.maxwellapi.model.domain.exceptions.ArbitroNaoEncontradoException;
import br.edu.infnet.maxwellapi.model.domain.exceptions.CompetidorInvalidoException;
import br.edu.infnet.maxwellapi.model.domain.exceptions.CompetidorNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CompetidorService implements CrudService <Competidor, Integer>{

    private final Map<Integer, Competidor> mapa = new ConcurrentHashMap<Integer, Competidor>();
    private final AtomicInteger nextId = new AtomicInteger(1);

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

        //validação específica: um novo vendedor nao ter ID
        //validação para o endereço: se ele foi fornecido

        competidor.setId(nextId.getAndIncrement());
        // atribuição do novo ID
        mapa.put(competidor.getId(), competidor);
        //persistência
        return competidor;
    }

    @Override
    public Competidor alterar(Integer id, Competidor competidor){

        if(id == null || id == 0){
            throw new IllegalArgumentException("ID para alteracao nao pode ser nulo/zero");
        }


        validar(competidor);

        obterPorId(id);

        competidor.setId(id);

        //se o ID é valido

        //validação para o vendedor: validar se o objeto está nulo e se o nome está prenchido

        //vendedor existe?

        mapa.put(competidor.getId(), competidor);

        //persistência

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
        competidor.setGenero("Masculino");

        return competidor;
    }
    @Override
    public Competidor obterPorId(Integer id) {

        Competidor competidor = mapa.get(id);

        if (competidor == null) {
            throw new IllegalArgumentException("Impossível obter o competidor pelo ID" + id);
        }

        return competidor;
    }


//    public Competidor obterListaPorSexo(String sexo) {
//
//        Competidor competidor = mapa.get(sexo);
//
//        return competidor;
//    }

    @Override
    public void excluir(Integer id) {
        if(id == null || id == 0){
            throw new IllegalArgumentException("ID para excluir nao pode ser nulo/zero");
        }
        if(!mapa.containsKey(id)){
            throw new CompetidorNaoEncontradoException("Competidor com ID " + id + " nao existe.");
        }

        mapa.remove(id);
    }

    public Competidor inativar(Integer id){
        if(id == null || id == 0){
            throw new IllegalArgumentException("ID para alteracao nao pode ser nulo/zero");
        }
        Competidor competidor = obterPorId(id);

        if(!competidor.isEhAtivo()){
            System.out.println("Competidor" + competidor.getNome() + "já está inativo");
            return competidor;
        }
        competidor.setEhAtivo(false);
        return null;
    }

    @Override
    public List<Competidor> obterLista() {

        return new ArrayList<Competidor>( mapa.values());
    }

    }

//    public ArrayList<Competidor> feminino(String genero){
//        if(genero == "feminino"){
//            return new ArrayList<Competidor>(mapa.values());
//        }
//        return feminino(genero);
//    }

//    @Override
//    public Competidor obterlistaSexo(Competidor competidor){
//        if(Objects.equals(competidor.getSexo(), "feminino")){
//
//        }
//        return competidor;
//    }


