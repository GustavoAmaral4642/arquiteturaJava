package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public void incluir(Vendedor v){
        vendedorRepository.save(v);
    }

    public Collection<Vendedor> obterLista(){
        return (Collection<Vendedor>) vendedorRepository.findAll();
    }

}
