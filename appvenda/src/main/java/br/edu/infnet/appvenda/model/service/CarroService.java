package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.model.domain.Carro;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CarroService {

    private Map<Integer, Carro> mapaCarro = new HashMap<Integer,Carro>();

    public void incluir(Carro c){
        mapaCarro.put(c.getCodigo(), c);
    }

    public Collection<Carro> obterLista(){
        return mapaCarro.values();
    }

}
