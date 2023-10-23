package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.model.domain.Produto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProdutoService {

    private Map<Integer, Produto> mapaProduto = new HashMap<Integer,Produto>();

    public void incluir(Produto p){
        mapaProduto.put(p.getCodigo(), p);
    }

    public Collection<Produto> obterLista(){
        return mapaProduto.values();
    }

}
