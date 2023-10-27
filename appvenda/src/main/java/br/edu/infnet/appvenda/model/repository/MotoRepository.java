package br.edu.infnet.appvenda.model.repository;

import br.edu.infnet.appvenda.model.domain.Moto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends CrudRepository<Moto, Integer> {
}
