package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.model.domain.Moto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class MotoService {

    private Map<Integer, Moto> mapaMoto = new HashMap<Integer,Moto>();

    public void incluir(Moto m){
        mapaMoto.put(m.getCodigo(), m);
    }

    public Collection<Moto> obterLista(){
        return mapaMoto.values();
    }

}
