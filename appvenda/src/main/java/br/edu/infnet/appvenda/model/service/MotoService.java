package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.model.domain.Moto;
import br.edu.infnet.appvenda.model.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;
    private Map<Integer, Moto> mapaMoto = new HashMap<Integer,Moto>();

    public List<Moto> pesquisar(String campoBusca){
        return motoRepository.findByCilindrada(campoBusca);
    }

    public void incluir(Moto m){
        motoRepository.save(m);

    }

    public Collection<Moto> obterLista(){
        return (Collection<Moto>) motoRepository.findAll();
    }

    public Long obterQuantidade(){
        return motoRepository.count();
    }

    public void excluir(Integer id){
        motoRepository.deleteById(id);
    }
}
