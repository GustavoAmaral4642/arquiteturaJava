package br.edu.infnet.appvenda.model.repository;

import br.edu.infnet.appvenda.model.domain.Carro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends CrudRepository<Carro, Integer> {

    List<Carro> findByMotor(String motor);
}
