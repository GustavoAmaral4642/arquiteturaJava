package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.clients.IEnderecoClient;
import br.edu.infnet.appvenda.model.domain.Endereco;
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

    @Autowired
    private IEnderecoClient enderecoClient;

    public void incluir(Vendedor v){

        Endereco endereco = enderecoClient.buscarCep(v.getEndereco().getCep());
        v.setEndereco(endereco);

        vendedorRepository.save(v);
    }

    public Collection<Vendedor> obterLista(){
        return (Collection<Vendedor>) vendedorRepository.findAll();
    }

    public Long obterQuantidade(){
        return vendedorRepository.count();
    }

    public void excluir(Integer id){
        vendedorRepository.deleteById(id);
    }

}
