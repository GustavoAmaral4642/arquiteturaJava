package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.model.domain.Vendedor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class VendedorService {

    private Map<String, Vendedor> mapaVendedor = new HashMap<String,Vendedor>();

    public void incluir(Vendedor v){
        mapaVendedor.put(v.getCpf(), v);
    }

    public Collection<Vendedor> obterLista(){
//        mapaVendedor.keySet(); //retorna um Set
        return mapaVendedor.values(); //retorna uma Collection
    }

}
