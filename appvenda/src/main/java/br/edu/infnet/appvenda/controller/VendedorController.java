package br.edu.infnet.appvenda.controller;

import br.edu.infnet.appvenda.model.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VendedorController {

    @Autowired
    private AppController appController;

    @Autowired
    private VendedorService vendedorService;

    @GetMapping(value = "/vendedor/lista")
    public String obterListaVendedor(Model model){

        model.addAttribute("rota", "vendedor");
        model.addAttribute("titulo", "Vendedores:");
        model.addAttribute("listagem", vendedorService.obterLista());

        return appController.showHome(model);
    }

    @GetMapping(value = "/vendedor/{id}/excluir")
    public String excluir(@PathVariable Integer id){

        vendedorService.excluir(id);

        return "redirect:/vendedor/lista";
    }
}
