package br.edu.infnet.appvenda.model.repository;

import br.edu.infnet.appvenda.model.domain.Moto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends CrudRepository<Moto, Integer> {

    List<Moto> findByCilindrada(String cilindrada);
}
