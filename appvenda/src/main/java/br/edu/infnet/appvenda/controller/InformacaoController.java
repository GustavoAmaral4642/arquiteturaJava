package br.edu.infnet.appvenda.controller;

import br.edu.infnet.appvenda.model.domain.Informacao;
import br.edu.infnet.appvenda.model.service.InformacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InformacaoController {

    @Autowired
    private InformacaoService informacaoService;

    @PostMapping(value = "/informacoes/incluir")
    public String incluir(Informacao informacao){

        Informacao result = informacaoService.incluir(informacao);

        return "redirect:/";
    }

}
