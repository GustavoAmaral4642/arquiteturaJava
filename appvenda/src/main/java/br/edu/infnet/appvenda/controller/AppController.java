package br.edu.infnet.appvenda.controller;

import br.edu.infnet.appvenda.model.service.CarroService;
import br.edu.infnet.appvenda.model.service.MotoService;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private VendedorService vendedorService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private CarroService carroService;
    @Autowired
    private MotoService motoService;

    @GetMapping(value = "/")
    public String showHome(Model model){

        model.addAttribute("qtdeVendedor", vendedorService.obterQuantidade() );
        model.addAttribute("qtdeProduto", produtoService.obterQuantidade());
        model.addAttribute("qtdeCarro", carroService.obterQuantidade());
        model.addAttribute("qtdeMoto", motoService.obterQuantidade());
        return "home";
    }



}
