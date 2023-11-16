package br.edu.infnet.appvenda.model.repository;

import br.edu.infnet.appvenda.model.domain.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    @Query("from Produto p where p.vendedor.id = :idvendedor")
    public Collection<Produto> buscaPorId(Integer idvendedor);

    List<Produto> findByModelo(String modelo);
}
