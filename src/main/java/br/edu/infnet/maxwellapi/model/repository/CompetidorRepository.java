package br.edu.infnet.maxwellapi.model.repository;


import br.edu.infnet.maxwellapi.model.domain.Competidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompetidorRepository extends JpaRepository<Competidor, Integer> {

    Optional <Competidor> findByCpf(String cpf);

}
