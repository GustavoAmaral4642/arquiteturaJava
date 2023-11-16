package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.clients.IvendasClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendasService {

    @Autowired
    private IvendasClient vendasClient;

    public List<String> obterInformacao() {
        return vendasClient.obterInformacao();
    }

}
