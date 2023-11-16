package br.edu.infnet.appvenda.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8081/api/vendas", name = "vendasClient")
public interface IvendasClient {

    @GetMapping(value = "/informacoes")
    public List<String> obterInformacao();
}
