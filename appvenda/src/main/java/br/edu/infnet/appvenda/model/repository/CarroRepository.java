package br.edu.infnet.appvenda.model.repository;

import br.edu.infnet.appvenda.model.domain.Carro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends CrudRepository<Carro, Integer> {
}
