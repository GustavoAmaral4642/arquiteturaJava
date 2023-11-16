package br.edu.infnet.appvenda.controller;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProdutoController {

    @Autowired
    private AppController appController;

    @Autowired
    private ProdutoService produtoService;
    @GetMapping("/produto/pesquisar")
    public String pesquisar(Model model, String campoBusca) {

        List<Produto> produtos = produtoService.pesquisar(campoBusca);


        if (produtos != null && !produtos.isEmpty()) {
            model.addAttribute("objeto", produtos);
            return appController.showHome(model);
        }
        return "redirect:/produto/lista";
    }

    @GetMapping(value = "/produto/lista")
    public String obterListaProduto(Model model) {

        model.addAttribute("rota", "produto");
        model.addAttribute("titulo", "Produtos:");
        model.addAttribute("listagem", produtoService.obterLista());

        return appController.showHome(model);
    }

    @GetMapping(value = "/produto/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        produtoService.excluir(id);
        return "redirect:/produto/lista";
    }

}
