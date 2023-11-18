package br.edu.infnet.appvenda.clients;

import br.edu.infnet.appvenda.model.domain.Informacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8081/api/informacao", name = "informacaoClient")
public interface IInformcaoesClient {

    @GetMapping(value = "/lista")
    public List<Informacao> obterLista();

    @PostMapping(value = "/incluir")
    public Informacao incluir(Informacao informacao);
}
