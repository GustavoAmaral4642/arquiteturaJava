package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.model.domain.Carro;
import br.edu.infnet.appvenda.model.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public void incluir(Carro c){
        carroRepository.save(c);
    }

    public Collection<Carro> obterLista(){

        return (Collection<Carro>) carroRepository.findAll();
    }

}
