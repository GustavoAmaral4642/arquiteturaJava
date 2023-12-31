package br.edu.infnet.appvenda.model.repository;

import br.edu.infnet.appvenda.model.domain.Vendedor;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {

    Vendedor findByEmail(String email);
    List<Vendedor> findAll(Sort sort);

    Vendedor findByCpf(String cpf);
}
