package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    private Map<Integer, Produto> mapaProduto = new HashMap<Integer,Produto>();

    public void incluir(Produto p){

        produtoRepository.save(p);
    }

    public Collection<Produto> obterLista(){
        return (Collection<Produto>) produtoRepository.findAll();
    }


    public Collection<Produto> obterLista(Vendedor vendedor){
        return (Collection<Produto>) produtoRepository.buscaPorId(vendedor.getId());
    }

}
