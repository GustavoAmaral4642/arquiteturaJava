package br.edu.infnet.appvenda.controller;

import br.edu.infnet.appvenda.model.domain.Moto;
import br.edu.infnet.appvenda.model.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MotoController {

    @Autowired
    private AppController appController;

    @Autowired
    private MotoService motoService;

    @GetMapping(value = "/moto/pesquisar")
    public String pesquisar(Model model, String campoBusca){

        List<Moto> motos = motoService.pesquisar(campoBusca);
        if (motos != null && !motos.isEmpty()) {
            model.addAttribute("objeto", motos);
            return appController.showHome(model);
        }
        return "redirect:/moto/lista";
    }

    @GetMapping(value = "/moto/lista")
    public String obterListaMoto(Model model){

        model.addAttribute("rota", "moto");
        model.addAttribute("titulo", "Motos:");
        model.addAttribute("listagem", motoService.obterLista());

        return appController.showHome(model);
    }

    @GetMapping(value = "/moto/{id}/excluir")
    public String excluir(@PathVariable Integer id){

        motoService.excluir(id);
        return "redirect:/moto/lista";
    }
}
