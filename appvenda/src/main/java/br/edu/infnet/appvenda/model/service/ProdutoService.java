package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    private Map<Integer, Produto> mapaProduto = new HashMap<Integer,Produto>();

    public List<Produto> pesquisar(String modelo){
        return produtoRepository.findByModelo(modelo);
    }

    public void incluir(Produto p){

        produtoRepository.save(p);
    }

    public Collection<Produto> obterLista(){
        return (Collection<Produto>) produtoRepository.findAll();
    }


    public Collection<Produto> obterLista(Vendedor vendedor){
        return (Collection<Produto>) produtoRepository.buscaPorId(vendedor.getId());
    }

    public Long obterQuantidade(){
        return produtoRepository.count();
    }

    public void excluir(Integer id){
        produtoRepository.deleteById(id);
    }
}
