package br.edu.infnet.maxwellapi.model.repository;

import br.edu.infnet.maxwellapi.model.domain.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModalidadeRepository extends JpaRepository<Modalidade, Integer> {

List<Modalidade> findAll();
List<Modalidade> findByFaixaJiujitsu(String faixaJiujitsu);
List<Modalidade>findByGeneroModalidade(String generoModalidade);
List<Modalidade>findByCategoriaPorIdade(String categoriaPorIdade);
List<Modalidade> findByPesoModalidade(String pesoModalidade);
}
