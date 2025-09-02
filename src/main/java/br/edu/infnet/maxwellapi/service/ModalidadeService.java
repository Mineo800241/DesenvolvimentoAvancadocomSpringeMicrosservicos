package br.edu.infnet.maxwellapi.service;

import br.edu.infnet.maxwellapi.model.domain.Modalidade;
import br.edu.infnet.maxwellapi.model.repository.CompetidorRepository;
import br.edu.infnet.maxwellapi.model.repository.ModalidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalidadeService implements CrudService<Modalidade, Integer> {

    private final ModalidadeRepository modalidadeRepository;

    public ModalidadeService(ModalidadeRepository modalidadeRepository) {
        this.modalidadeRepository = modalidadeRepository;
    }



    @Override
    @Transactional
    public Modalidade incluir(Modalidade modalidade) {
        return modalidadeRepository.save(modalidade);
    }

    @Override
    public Modalidade alterar(Integer id, Modalidade entity) {
        return null;
    }

    @Override
    public Modalidade obterPorId(Integer id) {
        return null;
    }

    @Override
    public void excluir(Integer id) {

    }

    @Override
    public List<Modalidade> obterLista() {
        return modalidadeRepository.findAll();
    }
}
