package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.clients.IInformcaoesClient;
import br.edu.infnet.appvenda.model.domain.Informacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformacaoService {

    @Autowired
    private IInformcaoesClient informacoesClient;

    public List<Informacao> obterLista() {
        return informacoesClient.obterLista();
    }

    public Informacao incluir(Informacao informacao){
        return informacoesClient.incluir(informacao);
    }

}
